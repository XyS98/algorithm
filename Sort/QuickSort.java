package sort;
import java.util.ArrayList;

import recursion.util.ArrayAndListUtil;

/**
 * 快速排序
 * 思路
 * (1) 选择基准值。（链表的第一个值为基准值）
 * (2) 将链表分成两个子链表：小于基准值的元素和大于基准值的元素。
 * (3) 对这两个子链表分别递归调用快速排序,重复步骤(1)、(2)。当本次分出的子链表只包含3个及以下的元素时，下一次递归调用快速排序，即可对子链表实现排序
 * (4) 将排序后的子链表和基准值合并，形成排序后链表。
 * 问题: 1. 如何选择合适的
 */

 public class QuickSort{

    public ArrayList<Integer> quickSort(ArrayList<Integer> arrayList){
        // 递归条件
        if(arrayList.size()<2){
            return arrayList; // 当子链表只有0个，或1个元素时，便已经完成了排序
        }
        // 基线条件
        //1 选取基准值
        int base = arrayList.get(0);
        //2 将链表分为小于基准值的子链表 smaller 和 大于等于基准值的子链表 bigger
        ArrayList<ArrayList<Integer>> collection = ArrayAndListUtil.splitListInOrder(arrayList, base);
        ArrayList<Integer> small = collection.get(0); // 小于基准值的元素集合
        ArrayList<Integer> bigger = collection.get(1); // 大于基准值的元素集合
        //3 递归调用quickSort，并将排序后的
        return ArrayAndListUtil.addListsTogether(quickSort(small),base,quickSort(bigger));
    }

    public static void main(String[] args) {
        int[] randomArray = {1,8,8,3,5,0,7};
        ArrayList<Integer> randomList = ArrayAndListUtil.transferArrayToList(randomArray);
        QuickSort sort = new QuickSort();
        ArrayList<Integer> orderList = sort.quickSort(randomList);
        System.out.println(orderList.toString());
    }
}