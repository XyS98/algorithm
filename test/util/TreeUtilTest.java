package test.util;

import org.junit.Test;

import sort.select.HeapSort;
import util.ArrayUtil;
import util.TreeUtil;

public class TreeUtilTest {

    /**
     * 测试 计算完全二叉树的深度
     */
    @Test
    public void testGetDepthofCBTree(){
        int[] originHeap = { 1, 4, 3, 6, 5, 0, 2, 16, 21, 8 };
        int sumNode = originHeap.length;
        int depth = TreeUtil.getDepthofCBTree(sumNode);
        System.out.println("节点总数:"+ sumNode+" ,完全二叉树深度:" + depth);
    }

    @Test
    public void testGetLastFatherNodeId(){
        int[] originHeap = { 1, 4, 3, 6, 5, 0, 2, 16, 21, 8 };
        int lastFatherNodeId = TreeUtil.getLastFatherNodeId(originHeap.length);
        System.out.println("最后一个有孩子节点的父节点的编号:"  +  lastFatherNodeId);
    }

    /**
     * 测试 构建最大/最小堆 
     */
    @Test
    public void testBulidHeap(){ 
        int[] originHeap = { 1, 4, 3, 6, 5, 0, 2, 16, 21, 8 };
        int type = 1; //修改此处值 1 生成最大堆 ; 0 最小堆
        int indexRange = originHeap.length-1; // 数组中参与堆排序的索引范围
        int[] sortedHeap = TreeUtil.buildHeapFromTop(originHeap,indexRange,type);
        if(type == 1){
            System.out.println("最大堆为:"+"\n"+ArrayUtil.printArray(sortedHeap));
        }
        if(type == 0){
            System.out.println("最小堆为:"+"\n"+ArrayUtil.printArray(sortedHeap));
        }
    }

    @Test
    public void testHeapSort(){
        int[] originHeap = { 1, 4, 3, 6, 5, 0, 2, 16, 21, 8 };
        originHeap = HeapSort.heapSort(originHeap, 0); // 通过构建最大堆，实现升序排序
        System.out.println(ArrayUtil.printArray(originHeap));
    }
}