import java.util.ArrayList;

/**
 * 分割数组
 */
public class SplitArray {
    
   /**
    * 将原数组按照基准值，分成小于基准值的元素集合与大于基准值的元素集合
    * @param array 原数组
    * @param target 基准值
    * @return 
    */
    public static ArrayList<ArrayList<Integer>> splitArrayInOrder(int[] array,int target){
        // 将数组转化为链表
        ArrayList<Integer> list = transferArrayToList(array);
        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> bigger = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>(); 
        for(int elem:array){
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
     * 
     * @param array
     * @return
     */
    public static ArrayList transferArrayToList(int[] array){
        ArrayList list = new ArrayList<Integer>();
        if(array.length<1){
            return list; // new 的list 是否一定为空？？？？
        }else{
            for(int elem:array){
                list.add(elem);
            }
            return list;
        }
    }
}
