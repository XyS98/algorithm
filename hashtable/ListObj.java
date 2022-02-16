package hashtable;

/**
 * 链表对象
 * 
 * @param <k> key
 * @param <V> value
 */
public class ListObj<K, V> {

    private Node first; // 链表的第一个节点

    //内部类
    class Node {
        private K key; // 键
        private V value; // 值
        private Node next; // 下一个节点

        public  Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next; //下一个元素
        }
    }

    /**
     * 
     * @param key 键值对中的键
     * @return  节点的值
     */
    public V getValue(K key){
        Node node;
        for(node = first; node!= null;node = node.next ){
            if(key.equals(node.key)){
                return node.value;
            }
        }
        return null;
    }

    /**
     * 存放键,值
     */
    public void put(K key,V value){
        //先查找key是否存在
        Node node;
        for(node = first;node !=null;node = node.next){
            if(key.equals(node.key)){ // key 已经存在,用新Value 覆盖旧Value
                node.value = value;
            }
        }
        // key 不存在,就直接插入链表头(插入链表尾部还要遍历,更耗时)
        new Node(key,value,first); //原先的firt node 关联到新node 的后面
    }
}
