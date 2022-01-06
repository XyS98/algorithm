package test;

import org.junit.Test;
import hashtable.LinearProbingHashMap;

public class HashMapTest{
    
    /**
     * 验证动态扩容前后，同一个key 通过散列函数计算出的散列值是否改变
     * @param key
     */
    @Test
    public void hashTest(){
        Object key = "AAAA1";
        int capacity = 11;
        int index1 = (key.hashCode() &  0x7fffffff)%capacity; // 散列函数
        int index2 = (key.hashCode() &  0x7fffffff)%(capacity*2); // 动态扩容,散列表大小增大
        //int index2 = (key.hashCode() &  0x7fffffff)%(capacity*11);
        if(index1 == index2){
            System.out.println("动态扩容后,key的散列值不变,均是:"+ index1);
        }else{
            System.out.println("动态扩容后,key的散列值改变,扩容前:"+index1+" 扩容后:"+index2);
        }
    }

    @Test
    public void operationLinerProbingHashMap(){
        LinearProbingHashMap<String,String> linerProHashMap = new LinearProbingHashMap<String,String>(8);
        // 测试存放 键-值
        linerProHashMap.put("苹果", "5￥/斤"); //1
        linerProHashMap.put("香梨", "6.3￥/斤");//2
        linerProHashMap.put("新疆哈密瓜", "13.5￥/斤");//3

        String appplePrice1= linerProHashMap.getKey("苹果");
        System.out.println("扩容前苹果的价格:"+ appplePrice1);


        linerProHashMap.put("水蜜桃", "7.4￥/斤"); //4
        linerProHashMap.put("红心火龙果", "10￥/斤");//5
        linerProHashMap.put("荔枝", "14￥/斤"); //6  装载因子警戒点 8*0.75 = 6,下一次存放值前将会进行扩容
        linerProHashMap.put("草莓", "24￥/斤");//7 
        //测试扩容前后 key value 是否会被改变
        String appplePrice2 = linerProHashMap.getKey("苹果");
        System.out.println("扩容后苹果的价格:"+ appplePrice2);
        linerProHashMap.put("西瓜", "4￥/斤");

        // 测试删除 key,value
        System.out.println(linerProHashMap.toString());
        linerProHashMap.delete("苹果");
        System.out.println(linerProHashMap.toString());
    }
}