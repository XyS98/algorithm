package sort.select;

import util.TreeUtil;

/**
 * 使用二叉堆进行排序
 *      主要思路
 *          输入: 一个包含无序元素的数组A
 *          堆排序：1.创建堆 ： 用数组的形式将元素重新排序，形成最大堆/最小堆（任意父节点大于/小于其子节点）
 *                 2.堆排序 ： 将堆顶的根节点与最后一个节点互换,并在剩余元素中重新构建最大/最小堆,
 *                            从而获得次最大/小值，将次最大/小值和新堆的最后一个节点互换。
 *                            重复步骤2，直至所有元素形成有序序列。
 *                            
 *          输出:被排好序的数组A
 * 
 * 选择排序与堆排序的思想总结：
 *       1.选择排序的思想，就是在一个集合中无序的部分里依次拿出最值,放到有序的部分里。依次拿出的最值都和上一个最值有大小关系。
 *         进行重复,直至所有元素都被放到有序部分的里，实现排序。
 *       2.堆排序的关键就是利用二叉堆的特点,在无序的部分中找到最大/小值：在完成最大/小堆的构建后,当前堆的最大/小值总会出现在堆顶部。
 */
public class HeapSort {

    public static int[] heapSort(int[] originHeap,int type){
       //1. 构建最大/最小堆  
        int indexRange; // 控制每次参与最大/最小堆的元素的个数
        int pointer  = TreeUtil.getLastFatherNodeId(originHeap.length); // 从最后一个非叶子节点开始
        int root ; // 堆的根节点
        for(indexRange=originHeap.length-1;indexRange>0;indexRange--){
            // 1. 构建最大/最小堆
            if(type==1){
                originHeap = TreeUtil.buildMaxHeap(originHeap, indexRange, pointer);
            }else if(type==0){
                originHeap = TreeUtil.buildMinHeap(originHeap, indexRange, pointer);
            }else{
                new Exception("type 只能是 0 或 1");
            }
            //2. 构建完成后,将堆顶的节点和最后一个节点交换值,将最大/小值放到堆最后一个节点。
            root = originHeap[0];
            originHeap[0] = originHeap[indexRange]; // 当前堆中的最后一个节点
            originHeap[indexRange] = root;
            //3.存放最大/小值的节点不再参与下次最大/小堆的构建
            //--indexRange;
        }
        return originHeap;
    }
}