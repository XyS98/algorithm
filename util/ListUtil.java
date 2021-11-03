package util;

import java.util.ArrayList;

/**
 * 分割数组
 */
public class ListUtil {
    
   /**
    * 将链表按照基准值，分成小于基准值的元素集合与大于等于基准值的元素集合
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
            }else {
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
            return list; // new 的list 是否一定为空？？？？ --> yes --> new list.size=0
        }else{
            for(int elem:array){
                list.add(elem);
            }
            return list;
        }
    }
    
    /**
     * 将链表转为数组
     * @param arrayList 链表
     * @return  int[]
     */
    public static int[] transferListToArray(ArrayList<Integer> arrayList){
        int[] array = new int[arrayList.size()];
        int i ;
        for(i=0;i<arrayList.size();i++){
            array[i] = arrayList.get(i);
        }
        return array;
    }

    /**
     * 将right链表的元素依次放在left 链表末尾，实现两个链表相加
     * @param left ArrayList<Integer>  小于基准值的元素集合
     * @param base Integer 基准值
     * @param right ArrayList<Integer> 大于基准值的元素结合
     * @return AarrayList<Integer> 相加后的链表
     */
    public static ArrayList<Integer> addListsTogether(ArrayList<Integer> left,ArrayList<Integer> right){
        for(Integer e:right){
            left.add(e);
        }
        return left;
    }

    /**
     * 判断 链表中第一个元素是否是链表中最小的元素
     * @param list
     * @return
     */
    public static boolean checkIsSmallest(ArrayList<Integer> list,int target){
        for(int elem:list){
            if(target>elem){
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历链表，获取链表中的第一个非最小值
     * @param list
     * @return
     */
    public static int getMidNumber(ArrayList<Integer> list){
        int i;
        int base,next;
        for(i=0;i<list.size()-1;i++){
            base = list.get(i);
            next = list.get(i+1);
            if(next<base){
                return base;
            }
        }
        return -1; // 说明List中任意一个元素都要小于等于后一个元素，该List已经是有序状态
    }


}
