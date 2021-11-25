package sort.select;

/**
 * 使用二叉堆进行排序
 *      主要思路
 *          输入: 一个包含无序元素的数组A
 *          堆排序：1.创建堆 ： 用数组的形式将元素重新排序，形成最大堆/最小堆
 *                 2.调整堆 ： 调整过程需要保证堆序性质：在一个二叉堆中任意父节点大于其子节点
 *                 3.堆排序 ： 取出位于堆顶的第一个数据（最大堆则为最大数，最小堆则为最小数），放入输出数组B 中，再将剩下的对作调整堆的迭代/重复运算直至输入数组 A中只剩下最后一个元素
 *          输出：输出包含A中所有元素但已排好序的数组B，
 */
public class HeapSort {

        /**
         * 将输入的无序数组进行堆排序,然后输出有序数组
         * @param array
         * @return
         */
        public int[]  heapSort(int[] array){

            return null;
        }

        /**
         * 创建堆,初步排序形成最大堆
         * @param array
         * @return
         */
        public int[] createBiggestHeap(int[] array){
            
            return null;
        }

        /**
         * 创建堆,初步排序形成最小堆
         * @param array
         * @return
         */
        public int[] createSmallestHeap(int[] array){
            return null;
        }
        
        /**
         * 调整最大堆
         * @param array
         * @return
         */
        public int[] adjustBiggestHeap(int[] array){
            return null;
        }

        /**
         * 调整最大堆
         * @param array
         * @return
         */
        public int[] adjustSmallestHeap(int[] array){
            return null;
        }
        
        public int[] sortHeap(int[] array){
            return null;
        }
}