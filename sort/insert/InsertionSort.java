package sort.insert;

import java.util.ArrayList;

import util.ArrayUtil;

/**
 * 简单插入排序 1.思路: 从无序集合中依次拿取元素插入到有序集合中，
 *                 插入之前找到新元素在有序集合中的位置，
 *                 使得插入后的集合依然有序。
 *          2.时间复杂度:
 *              最优情况: O(n) = n-1 --> n
 *              最糟糕情况: O(n) = 1/2*(n-1)n --> n^2 
 */
public class InsertionSort {


    public  ArrayList<Integer> insertionSort(ArrayList<Integer> list){
        // 有序链表
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        int i;
        int bigger;
        int inserted; // 新元素是否已经插入到有序集合的状态码 0 未插入 1 已插入
        for(Integer elem:list){
            inserted = 0;
                for(i=0;i<sortedList.size();i++){
                    bigger = sortedList.get(i);
                    // 找到比 插入元素elem大的元素bigger并插入在bigger处
                    if(elem<bigger){ 
                        sortedList.add(i,elem);
                        inserted = 1; // 更新状态码
                        break; // 跳出当前循环，进行下一个元素的插入
                    }
                }
                if(inserted == 0){ // 待插入元素比有序集合中所有元素都大，插入到集合末尾
                    sortedList.add(elem);
                }  
        }
        return sortedList;
    }

    /**
     * 第二种插入排序实现方式,
     * 只用一个集合进行排序，
     * 要排序的元素从集合中拿出来，
     * 找到正确位置后再插入原集合
     * @param array
     * @return
     */
    public static int[] insertionSort2(int[] array) {
        int i, j, temp,next;
        for (i = 0; i < array.length; i++) { // 从第二个元素开始
            temp = array[i];
            for (j = 1; j < array.length; j++) {
                next = array[j];
                if (temp > next){
                    // 通过交换两个元素的位置的进行排序
                    array = ArrayUtil.exchangeArrayElement(array, i, j);
                    break; // 跳出当前循环，拿去数组的下一个元素进行排序
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] disOrderArray = { 5, 7, 7, 2, 0, 4, 6 };
        // ArrayList<Integer> disOrderList =
        // ListUtil.transferArrayToList(disOrderArray);
        // System.out.print("无序集合: "+disOrderList.toString()+"\n");
        // InsertionSort sort = new InsertionSort();
        // ArrayList<Integer> orderList = sort.insertionSort(disOrderList);
        // System.out.print("有序集合: "+orderList.toString());

        // 测试 insertionSort2 
        ArrayUtil.printArray(insertionSort2(disOrderArray));
    }
}