package hashtable;

/**
 * 使用链表法解决散列值冲突
 * 
 * @param <K> key
 * @param <V> value
 */
public class ChainingHashMap<K, V> {
    private int num; // 散列值
    private int capacity; // 散列表大小
    private ChainingObj<k,v>[] chainObj; // 链表的数组对象
}