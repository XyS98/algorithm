package util;

import java.security.InvalidParameterException;

public class ArrayUtil {
    /**
     * 交换数组中两个元素的位置
     * @param array 原数组
     * @param a 元素A的下标
     * @param b 元素B的下标
     */
    public static int[] exchangeArrayElement(int[] array,int a,int b){
        array[a] = array[a]+array[b]; 
        array[b] = array[a] - array[b]; 
        array[a] = array[a] - array[b]; 
        return array;
    }

    /**
     * 截取数组 范围:[left,right)
     * @param array 原数组
     * @param left 截取范围左下标
     * @param right 截取范围右下标
     * @return 截取后的数组
     */
    public static int[] copyArrayInRange(int[] array,int left,int right){
        int length = array.length;
        if(left<0||left>right){
            throw new InvalidParameterException("left index:"+left +" must >= 0 and <= right");
        }
        if(right>length||right<left){
            throw new InvalidParameterException("rigth index:"+right +"  must >= left index:"+left +" and <= array's max index:"+right);
        }
        int newLength = right - left;
        int[] newArray = new int[newLength]; 
        int i;
        for(i=0;i<newLength;i++){
            newArray[i] = array[left+i];
        }
        return newArray;
    }

    /**
     * 遍历数组内容,拼接成字符串返回
     * @param array 数组
     * @return String 格式的数组内容
     */
    public static String printArray(int[] array){
        int i;
        String result = "Array:";
        for(i=0;i<array.length;i++){
            result += i + ":" + "["+ array[i]+"]" +", "; 
        }
        result = result.substring(0,result.lastIndexOf(","));
        return result;
    }
    
}