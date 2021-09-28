
/**
 * 使用递归，求数组的和
 */
public class SumArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int sum = sumArrayByRecursion(array,0);
        System.out.println(sum);
    }

    public static int  sumArrayByRecursion(int[] array,int index){

        // 1. 找出基线条件
            
        // 2. 找出递归条件
        
        // 2. 将问题规模分解，直至符合基线条件
        ++index;
        if(index<=array.length){
           return array[0] +=sumArrayByRecursion(CopyRangeOfArray.copyArrayInRange(array,index,array.length-1),index);
        }else{
            return -1;
        }
    }  
}

