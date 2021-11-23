package sort.select;

import java.util.ArrayList;
/**
 * 选择排序
 * 思路:
 *      1.从待排序的集合中，找出最小值
 *      2.将最小值放到集合首部,在剩余未排序的集合序列中找出其中的最小值，放到已排序的元素后
 *      3.重复 1、2 步骤,直至集合中所有元素完成排序
 * 时间复杂度:
 *      比较操作、交换操作、赋值操作
 *      1.最好情况：O(n) = n^2
 *      2.最坏情况：O(n) = n^2
 *      3.一般情况：O(n) = n^2
 */ 
public class SelectSort {

    public static ArrayList<Integer> simpleSelectSort(ArrayList<Integer> list){
        int i,j;
        int current;// 排序中选取的元素
        int next; //  下一个被比较的元素
        int mixElemIndex=0; // 集合中未排序元素中的最小元素的索引
        for(i=0;i<list.size();i++){
            current = list.get(i);
            for(j=i+1;j<list.size();j++){ // 用当前元素和后续元素一一比较，找出最小值
                next = list.get(j);
                if(current>next){
                    current = next; // 用更小的值替换,寻找最小值
                    mixElemIndex = j;
                }
            }
           // 将最小值取出集合最前面
            list.remove(mixElemIndex);
            list.add(i,current);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(0);
        list.add(8);
        list.add(7);
        list = simpleSelectSort(list);
        System.out.println(list.toString());
    }
}