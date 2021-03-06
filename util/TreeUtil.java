package util;


/**
 * 构建、操作树有关的工具类
 */
public class TreeUtil {

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ], 返回节点在数组中的索引
     * 
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static int getBinaryTreeIndex(int nodeId) {
        return nodeId - 1;
    }

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ], 返回{父节点}在数组中的索引
     * 
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static int getBinaryTreeParentIndex(int nodeId) {
        int parentIndex = 0;
        // 判断该节点是左子节点还是右子节点
        if (nodeId % 2 == 0) { // 左子节点
            parentIndex = nodeId / 2 - 1;
        } else { // 右子节点
            parentIndex = (nodeId - 1) / 2 - 1;
        }
        return parentIndex;
    }

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ], 返回{左孩子节点}在数组中的索引
     * 
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static int getBinaryTreeLeftChildIndex(int nodeId) {
        return nodeId * 2 - 1;
    }

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ], 返回{右孩子节点}在数组中的索引
     * 
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static int getBinaryTreeRightChildIndex(int nodeId) {
        return nodeId * 2;
    }

    /**
     * 计算当前节点在树中的深度
     * 
     * @param nodeId
     * @return
     */
    public static int getDepthOfNode(int nodeId) {

        return 0;
    }

    /**
     * 返回完全二叉树中的某一个节点所在深度 根节点编号为1,深度为1
     * 
     * @param nodeSum 完全二叉树节点总数
     * @param nodeNum 节点编号
     * @return 节点的所在深度
     */
    public static int countDepthofNode(int nodeSum, int nodeId) {
        if (nodeId > nodeSum) {
            new ArrayIndexOutOfBoundsException("节点编号:" + nodeId + " 超出完全二叉树范围:" + nodeSum);
        }
        int depth = (int) Math.sqrt(nodeId); // 将double 强转为 int
        return depth;
    }

    /**
     * 查找完全二叉树最后一个(有孩子节点的)父节点的编号
     * 根节点编号1,依次递增
     * @param nodeSum
     * @return
     */
    public static int getLastFatherNodeId(int nodeSum) {
        int lastFatherId = 0;
        if(nodeSum%2==1){ // 最后一个节点是其父节点的右孩子节点
            lastFatherId =  (nodeSum-1)/2;
        }else if(nodeSum%2==0){  // 最后一个节点是其父节点的左孩子节点
            lastFatherId  = nodeSum/2;
        }
        return lastFatherId;
    }

    /**
     * 返回完全二叉树的深度
     * depth = (log2^sum) 1
     * log2^sum = loge^sum / loge^2
     * @param nodeSum 完全二叉树节点总数
     * @return
     */
    public static int getDepthofCBTree(int nodeSum) {
        return (int)(Math.log(nodeSum)/Math.log(2)) +1;
    }

    /**
     * 自上（最地城）而下（根节点）构建 最大堆，最小堆 
     * @param originHeap 初始无序数组
     * @param indexRange 参与构建堆的数组中元素的索引范围
     * @param type  0: 最小堆 1 最大堆 
     * @return
     */
    public static int[] buildHeapFromTop(int[] originHeap,int indexRange, int type) {
        // 1. 从最后一个非叶子节点 
        int pointerId = getLastFatherNodeId(originHeap.length);
        if (type == 1) { // 构建最大堆
            originHeap = buildMaxHeap(originHeap,indexRange,pointerId-1);
        } else if (type == 0) {
            originHeap = buildMinHeap(originHeap,indexRange,pointerId-1);
        } else {
            new Exception("当前入参type" + type + "错误," + "只能是0(最小堆)或1(最大堆)");
        }
        return originHeap;
    }

    /**
     * 将一棵二叉树构建成最大堆
     * @param originHeap 无序数组
     * @param indexRange 参与堆排序的节点的数组下标范围
     * @param pointer    指针,正在处理的节点(二叉树中的父节点)的数组下标
     * @return 最大堆
     */
    // 1.初始下标 得是最后一个父节点
    public static int[] buildMaxHeap(int[] originHeap,int indexRange, int pointer) {
        if (pointer < 0 || indexRange<0) { // 整个堆已经遍历完，返回结果
            return originHeap;
        }
       // int indexRange = originHeap.length - 1;
        int leftChildIndex = 2 * pointer + 1;
        int rightChildIndex = 2 * pointer + 2;

        int root = originHeap[pointer]; // 父节点
        int leftChildNode; // 左孩子节点
        int rightChildNode; // 右孩子节点
        if (leftChildIndex <= indexRange) { // 左孩子节点存在
            leftChildNode = originHeap[leftChildIndex]; // 取出左孩子节点的值
            if (root < leftChildNode) { // 交换值
                originHeap[leftChildIndex] = root;
                originHeap[pointer] = leftChildNode;
                root = leftChildNode;
            }
        }
        if (rightChildIndex <= indexRange) { 
            rightChildNode = originHeap[rightChildIndex];
            if (root < rightChildNode) {
                originHeap[rightChildIndex] = root;
                originHeap[pointer] = rightChildNode;
            }
        }
        // 2. 递归调用 构建最大堆
        return buildMaxHeap(originHeap,indexRange,pointer - 1); // 向前遍历所有父节点,到根节为止
    }

    /**
     * 将一棵二叉树构建成最小堆
     * @param originHeap 无序数组
     * @param indexRange 参与堆排序的节点范围
     * @param pointer    指针,正在处理的节点(二叉树中的父节点)的数组下标
     * @return 最大堆
     */
    // 1.初始下标 得是最后一个父节点
    public static int[] buildMinHeap(int[] originHeap,int indexRange,int pointer) {
        if (pointer < 0) { // 整个堆已经遍历完，返回结果
            return originHeap;
        }
        int leftChildIndex = 2 * pointer + 1;
        int rightChildIndex = 2 * pointer + 2;

        int root = originHeap[pointer]; // 父节点
        int leftChildNode; // 左孩子节点
        int rightChildNode; // 右孩子节点
        if (leftChildIndex <= indexRange) { // 左孩子节点存在
            leftChildNode = originHeap[leftChildIndex]; // 取出左孩子节点的值
            if (root > leftChildNode) { // 交换值
                originHeap[leftChildIndex] = root;
                originHeap[pointer] = leftChildNode;
                root = leftChildNode;
            }
        }
        if (rightChildIndex <= indexRange) { 
            rightChildNode = originHeap[rightChildIndex];
            if (root > rightChildNode) {
                originHeap[rightChildIndex] = root;
                 originHeap[pointer] = rightChildNode;
            }
        }
        // 2. 递归调用 构建最小堆
        return buildMinHeap(originHeap,indexRange,pointer - 1); // 向前遍历所有父节点,到根节为止
    }
}