package recursion.util;
public class PrintArrayInString {

    /**
     * 遍历数组内容,拼接成字符串返回
     * @param array 数组
     * @return String 格式的数组内容
     */
    public static String printArray(int[] array){
        int i;
        String result = "Array:";
        for(i=0;i<array.length;i++){
            result += " ["+ i+"]" + array[i] +","; 
        }
        result = result.substring(0,result.lastIndexOf(","));
        return result;
    }
}