import java.security.InvalidParameterException;

public class CopyRangeOfArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] newArray = copyArrayInRange(array, 2, 3);
        System.out.println(PrintArrayInString.printArray(newArray));

    }

    /**
     * 截取数组 范围:[left,right]
     * @param array 原数组
     * @param left 截取范围左下标
     * @param right 截取范围右下标
     * @return 截取后的数组
     */
    public static int[] copyArrayInRange(int[] array,int left,int right){
        int length = array.length;
        if(left<0||left>right){
            throw new InvalidParameterException("left index must >= 0 and <= right index");
        }
        if(right>length||right<left){
            throw new InvalidParameterException("rigth index must >= left index and <= array's max index");
        }
        int newLength = right - left + 1;
        int[] newArray = new int[newLength]; 
        int i;
        for(i=0;i<newLength;i++){
            newArray[i] = array[left+i];
        }
        return newArray;
    }
}