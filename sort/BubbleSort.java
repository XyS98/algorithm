package sort;

import recursion.util.ArrayAndListUtil;

/**
 * 冒泡排序
 * 时间复杂度：
 *  最坏情况：O(n)=(1/2)n^2=n^2
 *  最好情况：O(n)=n-1=n
 *  平均时间复杂度：
 */
public class BubbleSort{

    public int[] bubbleSort(int[] array){
        int i,j;
        int current,next;
        for(i=0;i<array.length-1;i++){ // 每次遍历数组,都将第n大的值放到数组末尾
            for(j=0;j<array.length-1;j++){
                current = array[j];
                next = array[j+1];
                if(current>next){ // 比较数组大小，如果当前值比下个值大，则进行交换。
                    array[j] = next;
                    array[j+1] = current;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] originArray = {4,5,1,0,3,6,2,9,8};
        BubbleSort sort = new BubbleSort();
        int[] orderedArray = sort.bubbleSort(originArray);
        System.out.println(ArrayAndListUtil.printArray(orderedArray));
    }
}