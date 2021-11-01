package sort.insertsort;

import java.util.ArrayList;

import recursion.util.ArrayAndListUtil;

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

    public static void main(String[] args) {
        int[] disOrderArray = { 5, 7, 7, 2, 0, 4, 6 };
        ArrayList<Integer> disOrderList = ArrayAndListUtil.transferArrayToList(disOrderArray);
        System.out.print("无序集合: "+disOrderList.toString()+"\n");
        InsertionSort sort = new InsertionSort();
        ArrayList<Integer> orderList = sort.insertionSort(disOrderList);
        System.out.print("有序集合: "+orderList.toString());
    }
}