package sort;
import java.util.ArrayList;

import recursion.util.ArrayAndListUtil;

/**
 * 快速排序
 * 思路
 * (1) 选择基准值。（数组的第一个值为基准值）
 * (2) 将数组分成两个子数组：小于基准值的元素和大于基准值的元素。
 * (3) 对这两个子数组分别递归调用快速排序,重复步骤(1)、(2)。当本次分出的子数组只包含3个及以下的元素时，下一次递归调用快速排序，即可对子数组实现排序
 * (4) 将排序后的子数组和基准值合并，形成排序后数组。
 * 问题: 1. 如何选择合适的数组
 */

 public class QuickSort{

    public ArrayList<Integer> quickSort(ArrayList<Integer> arrayList){
        // 递归条件
        if(arrayList.size()<2){
            return arrayList; // 当子数组只有0个，或1个元素时，便已经完成了排序
        }
        // 基线条件
        //1 选取基准值
        int base = arrayList.get(0);
        //2 将数组分为小于基准值的子数组 smaller 和 大于等于基准值的子数组 bigger
        ArrayList<ArrayList<Integer>> collection = ArrayAndListUtil.splitListInOrder(arrayList, base);
        ArrayList<Integer> small = collection.get(0); // 小于基准值的元素集合
        ArrayList<Integer> bigger = collection.get(1); // 大于基准值的元素集合
        //3 递归调用quickSort，并将排序后的
        return ArrayAndListUtil.addListsTogether(quickSort(small), quickSort(bigger));
    }

    public static void main(String[] args) {
        int[] randomArray = {1,8,4,5};
        ArrayList<Integer> randomList = ArrayAndListUtil.transferArrayToList(randomArray);
        QuickSort sort = new QuickSort();
        sort.quickSort(randomList);
    }
}