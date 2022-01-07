package hashtable;

/**
 * 链表对象
 * 
 * @param <k> key
 * @param <V> value
 */
public class ChainingObj<k, v> {

    private Node node; // 节点对象

    class Node {
        private k key; // 键
        private v value; // 值
        private Node next; // 下一个节点

        public void node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next; //????
        }
    }

}
