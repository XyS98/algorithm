package test.hashtable;

import org.junit.Test;

import hashtable.ChainingHashMap;

public class ChainingHashMapTest {
    int[] keys={1,2,3,4,5,6,7,8,4,10};
    String[] values={"aaa","bbb","ccc","d","e","f","g","h","J","K"};
    private ChainingHashMap hasMap ;

    @Test
    /**
     * 测试:添加值
     */
    public void chainPutValue(){ 
        this.hasMap = new ChainingHashMap<Integer,String>(6);
        int i;
        for(i=0;i<keys.length;i++){
            hasMap.put(keys[i], values[i]);
        }
    }

    @Test
    /**
     * 测试: 取值
     */
    public void chainGetValue(){
        this.chainPutValue();
        String v1 = (String)this.hasMap.get(keys[0]);
        System.out.println("key1:"+ keys[0] +"  value1:" + v1);
        String v2 = (String)this.hasMap.get(keys[1]);
        System.out.println("key2:"+ keys[1] +"  value1:" + v2);
        String v4 = (String)this.hasMap.get(keys[3]);
        System.out.println("key3:"+ keys[3] +"  value3:" + v4);
    }

    @Test
    /**
     * 测试: 以字符串的格式输出链表
     */
    public void chainToString(){
        this.chainPutValue();
        System.out.println(hasMap.toString());
    }

    @Test
    /**
     * 测试: 删除散列表中的key和value
     */
    public void chainRemoveNode(){
        this.chainPutValue();
        System.out.print(hasMap.toString()+"\n");
        hasMap.remove(keys[2]);
        System.out.println(hasMap.toString());
    }
}