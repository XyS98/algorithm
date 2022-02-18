package hashtable;

/**
 * 使用链表法解决散列值冲突
 * 组成描述：
 *      散列表中每个桶/槽/格子 是一个链表
 *      散列值相同的元素添加到对应的链表头
 *      查找时,获取散列值然后遍历散列值对应的链表获得元素
 * 
 * 时间复杂度:
 *      假设散列函数计算出的散列值平均分布到每一个槽中
 *      槽个数 n , 元素总数 m, 每个槽中链表的预期长度则为 k = n/m
 *      使用散列函数计算散列值的时间复杂度视为 O(hashFun)=1
 *      整个散列表 插入/删除元素的时间主要花费在 遍历对应槽中的链表
 *      故总时间复杂度 O(n) = k =  n/m
 *      但考虑到实际应用中每个槽中的链表长度不会太长（相对所有元素的数量）
 *      故 插入/删除元素的时间复杂度可以视作O(n)=1 (常数级别)
 *      故 散列表 总体的时间复杂度为 O(n) = 1 
 * 
 * @param <K> key
 * @param <V> value
 */
public class ChainingHashMap<K, V> {
    private int capacity; // 散列表大小
    private ListObj<K,V>[] listObjArray; // 链表的数组对象

    /**
     * 构造函数
     * @param capacity 散列表 槽的数量
     */
    public ChainingHashMap(int capacity){
        this.capacity = capacity;
        this.listObjArray = new  ListObj[capacity];
        int i;
        for(i=0;i<capacity;i++){
            listObjArray[i] = new ListObj<K,V>();
        }
    }

    /**
     * 获取 key 的哈希值 
     * @param key 
     * @return 哈希值
     */
    public int hashFun(Object key){
        return (key.hashCode() & 0x7fffffff)%capacity;
    }

    /**
     * 存放键值对
     * @param key
     * @param value
     */
    public void put(K key,V value){
        //计算散列值
        int hashIndex = hashFun(key);
        listObjArray[hashIndex].put(key, value);
    }

    /**
     * 通过 key 取值
     * @param key
     * @return value
     */
    public V get(K key){
        int hashIndex = hashFun(key);
        V value = listObjArray[hashIndex].getValue(key);
        return value;
    }

    /**
     * 通过key  删除散列表中的key,value
     * @param key
     */
    public void remove(K key){
        int hashIndex = hashFun(key);
        listObjArray[hashIndex].remove(key);
    }

    /**
     * 将链表内的所有内容输出成字符串
     * @return [{key1:value1,key2:value2,...},
     *          {key1:value1,key2:value2,...},
     *          .
     *          .
     *          .
     *          {key1:value1,key2:value2,...}]
     */
    public String toString(){
        int slotIndex; // hashmap 槽的索引
        String content = "[";
        for(slotIndex=0;slotIndex<listObjArray.length;slotIndex++){
            if(slotIndex>0){
                content +=" ";
            }
            content += slotIndex+" "+listObjArray[slotIndex].toString()+","+"\n";
        }
        content = content.substring(0,content.length()-2) + "]";
        return content;
    }
    
}