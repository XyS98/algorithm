
/**
 * 使用递归，求数组的和
 */
public class SumArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,7};
        int sum = sumArrayByRecursion(array);
        System.out.println(sum);
    }

    public static int  sumArrayByRecursion(int[] array){

        // 1. 找出基线条件
            
        // 2. 找出递归条件
        
        // 2. 将问题规模分解，直至符合基线条件
        if(array.length==1){
            return array[array.length-1];
        }else{
            return array[array.length-1] +=sumArrayByRecursion(CopyRangeOfArray.copyArrayInRange(array,0,array.length-1));
        }
    }  
}

