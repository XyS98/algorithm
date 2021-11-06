package sort.insert;

import java.util.ArrayList;
import java.util.Date;

import util.ListUtil;
import util.TimeUtil;

/**
 * 希尔排序 1。思路: 1.1 按照一定间隔（增量:length/2）将集合中的元素分为多个子集合。
 * 希尔增量一般是取自该序列（希尔增量序列）{n*(1/2),n*(1/2)*(1/2),n*(1/2)*(1/2)（1/2）......},
 * 最优为增量序列为 Hibbard 1.2 对子数组分别进行插入排序 1.3 缩小希尔增量n*(1/2)*(1/2),再次对集合进行分组、插入排序 1.4
 * 当希尔增量==1 时，整个集合大部分元素已经有序，只要对个别元素进行微调即可。
 */
public class ShellSort {
    
    public static ArrayList<Integer> shellSort(ArrayList<Integer> list){
        int gap = list.size()/2;  //数组长度
        int i; //数组下标 
        int current; // 当前进行排序的元素
        int next; //与 current 间隔 gap 的元素 
        while(gap>1){
            for(i=0;i+gap<list.size();i++){
                current = list.get(i);
                next = list.get(i+gap);
                if(current>next){ // 将较小的next元素插入到current前
                    list.remove(i+gap);
                    list.add(i,next);
                }
            }   
            // 当前增量的排序完成后，缩小增量再次排序
            gap = gap/2;
            // if(gap<=1){ // 当增量缩减为 1或者0 时，集合中的极大部分元素已经变成有序状态
            //     // 最后使用一次简单插入排序,对集合进行微调,完成排序
            //     InsertionSort.insertionSort2(list);
            // }    
        }
        return list;
    }

    public static void main(String[] args) {
        //int[] array = {2,5,4,8,0,4,6,7,1};
        int i;
        int sumTime =0;
        for(i=0;i<10;i++){
            ArrayList<Integer> list = ListUtil.getRandomList(200000);
            System.out.print("随机生成的List长度: " +list.size() + "\n");
            // 1. 希尔排序运行记时
            Date startDateShell = new Date();
            long startTimeShell = startDateShell.getTime();
            //list = InsertionSort.insertionSort(list); // 简单插入排序
            list = shellSort(list);
            //shellSort(list); // 希尔排序
            Date endDateShell = new Date();
            long endTimeShell = endDateShell.getTime();
            long costTimeShell = endTimeShell-startTimeShell; 
            String realTimeShell = TimeUtil.getFormateSecond(costTimeShell);   
            sumTime += Integer.parseInt(realTimeShell);               
            System.out.print("shellSort排序运行花费时间:" +realTimeShell + "\n");
        }
            System.out.print("shellSort排序10次运行花费总时间:" +sumTime + "\n");
            System.out.println("shellSort排序10次运行花费平均时间:" + sumTime/10 + "\n");

        // 简单插入排序记录时
        /**
        Date startDateInsert = new Date();
        long startTimeInsert = startDateInsert.getTime();
        Date endDateInsert = new Date();
        long endTimeInsert = endDateInsert.getTime();
        long costTimeInsert = endTimeInsert-startTimeInsert; 
        String realTimeInsert = TimeUtil.getFormateSecond(costTimeInsert);                  
        System.out.print("简单插入运行花费时间:" +realTimeInsert +"\n");
         */
    }   
}