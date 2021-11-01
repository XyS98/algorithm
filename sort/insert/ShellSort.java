package sort.insert;

/**
 * 希尔排序 1。思路: 1.1 按照一定间隔（增量:length/2）将集合中的元素分为多个子集合。
 * 希尔增量一般是取自该序列（希尔增量序列）{n*(1/2),n*(1/2)*(1/2),n*(1/2)*(1/2)（1/2）......},
 * 最优为增量序列为 Hibbard 1.2 对子数组分别进行插入排序 1.3 缩小希尔增量n*(1/2)*(1/2),再次对集合进行分组、插入排序 1.4
 * 当希尔增量==1 时，整个集合大部分元素已经有序，只要对个别元素进行微调即可。
 */
public class ShellSort {
    
    public int[] shellSort(int[] array){
        int gap = array.length/2;  //初始增量  
        int i,j; //数组下标  
        for(i=0;i<gap;i++){
             
        }
        return null;
    }
}