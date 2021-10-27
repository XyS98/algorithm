package search.binary;
import java.util.NoSuchElementException;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {1,3,5,7,9};
        int target = 2;
        int index = binarySearch(input,target);
        System.out.print(index);
    }

    /**
     * 二分查找
     * @param {int[]}input 查找范围
     * @param {int}target  查找目标
     * @return index 查找目标的数组下标
     */
    public static int binarySearch(int[] input,int target) throws NoSuchElementException{
        // 获取中间的下标
        int mid = 0;
        int nextMid=0;
        // 获取元素
        int data = 0;
        int low=0;
        int high = input.length-1;
        //对比目标值与所选值大小
        while(low<=high){
            nextMid = (low+high)/2;
            if(mid ==nextMid ){ // 下一个mid 的index 和 当前 mid 的index 一样，说明陷入了死循环
                String errorMsg = "target:" + target +" is not in the array";
                throw new NoSuchElementException(errorMsg);
            }else{  
                mid = nextMid; 
                data = input[mid];
                if(data == target){ // 相等
                    return  mid;
                }
                else if(target<data){ //小于 
                    high = mid;
                }else{  // 大于
                    low = mid;
                }
            }

        }
        // 如果target 不在输入的数组input中，则返回目标值在数组中插入的索引值
        return -1;
    }

}

