package sort;

/**
 * 选择排序
 * 思路:
 *      1.从待排序的集合中，找出最小值
 *      2.如果最小值不是待排序的集合第一个，则将第一个元素和最小值交换位置
 *      3.重复 1、2 步骤,直至集合中所有元素完成排序
 */ 
public class selectSort {


    public int[] simpleSelectSort(int[] array){
        int i,j;
        int current;// 排序中选取的元素
        int next; //  下一个被比较的元素
        for(i=0;i<array.length;i++){
            current = array[i];
            for(j=i+1;j<array.length;j++){ // 用当前元素和后续元素一一比较，找出最小值
                next = array[j];
                if(current>next){
                    current = next; // 用更小的值替换
                }
            }
           // if()
        }
    }
}