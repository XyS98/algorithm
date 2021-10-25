import java.awt.List;
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
    public static ArrayList splitArrayInOrder(int[] array,int target){
        // 将数组转化为链表
        List list = transferArrayToList(array);
        
    }

    /**
     * 
     * @param array
     * @return
     */
    public static ArrayList transferArrayToList(int[] array){
        List list = new ArrayList<>();
        System.out.println("list结果"+ list.toString());
        list.removeAll(); // 初始化链表
        if(array.length=0){
            return list.add(null); // new 的list 是否一定为空？？？？
        }else{
            for(int elem:array){
                list.add(elem);
            }
            return list;
        }
    }
}
