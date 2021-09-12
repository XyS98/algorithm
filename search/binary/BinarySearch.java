public class BinarySearch{
    public static void main(String[] args) {
    
    }

    /**
     * 二分查找
     * @param {int[]}input 查找范围
     * @param {int}target  查找目标
     * @return index 查找目标的数组下标
     */
    public int  binarySearch(int[] input,int target){
        int index=0;
        int maxLen = input.length;
        int leftIndex=0;
        int rightIndex=maxLen;
        
    }

    public int compare(int leftIndex,int rightIndex,int[] input,int target,int index){
        // 获取中间的下标
        int midIndex = leftIndex+getMid(rightIndex-leftIndex);
        // 获取元素
        int data = input[midIndex];
        //对比目标值与所选值大小
        if(data == target){ // 相等
            return index = midIndex;
        }
        else if(target<data){ //小于 
            rightIndex = midIndex;
            compare(leftIndex,rightIndex,input,target,index);
        }else{  // 大于
            leftIndex = midIndex;
        }
    }

    /**
     * 获取中间值
     * @param len 长度
     * @return 该长度的中间值
     */
    public int getMid(int len){
        int mid = 0;
        if(len%2==0){
            mid = len/2;
        }else{
            mid = (len+1)/2;
        }
        return mid;
    }
}

