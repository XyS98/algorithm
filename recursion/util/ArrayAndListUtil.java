package recursion.util;

import java.util.ArrayList;

/**
 * 分割数组
 */
public class ArrayAndListUtil {
    
   /**
    * 将链表按照基准值，分成小于基准值的元素集合与大于基准值的元素集合
    * @param array{Integer[]} 原链表
    * @param target{Integer} 基准值
    * @return ArrayList<ArrayList<Integer>> index:0 small ArrayList,index:1 big ArrayList
    */
    public static ArrayList<ArrayList<Integer>> splitListInOrder(ArrayList<Integer> list,int target){
        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> bigger = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>(); 
        for(int elem:list){
            if(elem<target){
                smaller.add(elem);
            }else{
                bigger.add(elem);
            }
        }
        collection.add(0, smaller);
        collection.add(1,bigger);
        return collection;
    }

    /**
     * 将数组转化为链表
     * @param array{Intger[]}
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> transferArrayToList(int[] array){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array.length<1){
            return list; // new 的list 是否一定为空？？？？
        }else{
            for(int elem:array){
                list.add(elem);
            }
            return list;
        }
    }

    /**
     * 将right链表的元素依次放在left 链表末尾，实现两个链表相加
     * @param left{ArrayList<Integer>}
     * @param right{ArrayList<Integer>}
     * @return AarrayList<Integer> 相加后的链表
     */
    public static ArrayList<Integer> addListsTogether(ArrayList<Integer> left,ArrayList<Integer> right){
        for(Integer e:right){
            left.add(e);
        }
        return left;
    }
}
