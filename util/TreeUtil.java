package util;

/**
 * 构建、操作树有关的工具类
 */
public  class TreeUtil {

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ],
     * 返回节点在数组中的索引
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static  int  getBinaryTreeIndex(int nodeId){
        return nodeId-1;  
    }

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ],
     * 返回{父节点}在数组中的索引
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static  int getBinaryTreeParentIndex(int nodeId){
        int parentIndex =0;
        //判断该节点是左子节点还是右子节点
        if(nodeId%2==0){ // 左子节点
            parentIndex = nodeId/2-1;
        }else{  // 右子节点
            parentIndex = (nodeId-1)/2-1;
        }
        return parentIndex;
    }

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ],
     * 返回{左孩子节点}在数组中的索引
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static  int getBinaryTreeLeftChildIndex(int nodeId){
        return nodeId*2-1;
    }

    /**
     * 输入完全二叉树[数组构成]某个节点的编号[编号从1(根节点)开始 ],
     * 返回{右孩子节点}在数组中的索引
     * @param nodeId 节点编号
     * @return 数组构成的完全二叉树的索引
     */
    public static  int getBinaryTreeRightChildIndex(int nodeId){
        return nodeId*2;
    }   

    public  static void main(String[] args) {
        int[] binaryTree = {1,4,3,6,5,0,2,9,8};
        //test 1 返回某个节点的值
        int nodeId = 3;
        int nodeValue = binaryTree[TreeUtil.getBinaryTreeIndex(nodeId)];
        System.out.println("节点"+nodeId+"的值: "+nodeValue+"\n");
        //test 2 返回该节点的父节点 的索引
        int parentIndex = TreeUtil.getBinaryTreeParentIndex(nodeId);
        System.out.println("节点"+nodeId+"的父节点的索引: " + parentIndex+"\n");
        int praentValue = binaryTree[parentIndex];
        //test 3 返回该节点的父节点 的值
        System.out.println("节点"+nodeId+"的父节点的值: " + praentValue+"\n");
        //test 4 返回该节点左子节点的索引和值
        int leftChildIndex = TreeUtil.getBinaryTreeLeftChildIndex(nodeId);
        int leftChildValue = binaryTree[leftChildIndex];
        System.out.println("节点"+nodeId+"的左子节点的索引: "+leftChildIndex +" 值: "+leftChildValue+"\n");
        //test 4 返回该节点左子节点的索引和值
        int rightChildIndex = TreeUtil.getBinaryTreeRightChildIndex(nodeId);
        int rightChildValue = binaryTree[rightChildIndex];
        System.out.println("节点"+nodeId+"的左子节点的索引: "+rightChildIndex +" 值: "+rightChildValue+"\n");
    }
}