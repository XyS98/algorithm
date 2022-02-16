package hashtable;

/**
 * 使用链表法解决散列值冲突
 * 组成描述：
 *      散列表中每个桶/槽/格子 是一个链表
 *      散列值相同的元素添加到对应的链表末尾
 *      查找时,获取散列值然后遍历散列值对应的链表获得元素
 * @param <K> key
 * @param <V> value
 */
public class ChainingHashMap<K, V> {
    private int num; // 散列值
    private int capacity; // 散列表大小
    private ListObj<K,V>[] listObjArray; // 链表的数组对象

    //1.构造函数

    public ChainingHashMap(int capacity){
        this.capacity = capacity;
        this.listObjArray = new  ListObj[capacity];
    }

    //2. 散列函数
    public int hashFun(Object key){
        return (key.hashCode() & 0x7fffffff)%capacity;
    }

    //防值
    public void put(K key,V value){
        //计算散列值
        int hashIndex = hashFun(key);
        listObjArray[hashIndex].put(key, value);
    }

    public V get(K key){
        int hashIndex = hashFun(key);
        V value = listObjArray[hashIndex].getValue(key);
        return value;
    }
}