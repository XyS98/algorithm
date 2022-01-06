package  hashtable;

/**
 * 线性探测散列表（哈希表）
 * 线性探测 是 散列表解决散列函数计算出的散列地址冲突的解决策略，属于开放寻址法
 * Relationship:
 * 1. 散列地址冲突: 对于一个key B,散列函数计算出的散列地址已经被key A使用，就发生了"散列冲突"
 * 2. 开放寻址法:思想核心是 将散列冲突的Key B,在散列表中按照一个固定策略，找一个空位置存放,来解决冲突。
 *    策略有：线性探测、二次探测、双重散列
 * 3. 线性探测策略
 *    从当前冲突的位置向后遍历,找到第一个空位存放新key,遍历至末尾无果,即从散列表头开始，继续遍历寻找空位。
 * @param <K>
 * @param <V>
 */
public class LinearProbingHashMap<K,V>{
    private int num=0; //散列表中键值对数量
    private int originalCapacity=0; // 散列表的初始大小
    private int capacity; // 散列表当前大小
    private int capCoefficient=2; // 自动扩容的倍数
    private K[] keys; // 键列表
    private V[] values; // 值列表
    private double loadCoefficient = 1; // 装载因子警戒系数 
    /**
     * 构造方法
     * @param capacity 设置散列表初始大小
     */
    public LinearProbingHashMap(int capacity){
        this.keys = (K[])new Object[capacity];
        this.values = (V[])new Object[capacity];
        this.capacity = capacity;
        if(originalCapacity==0){
            this.originalCapacity = capacity;
        }
    }

    /**
     * 散列函数 计算key的散列值 
     * 将 keys 的 哈希值与 最大整数进行 位运算，再与散列表初始大小进行 模运算
    */ 
    public int hash(K key){
        return (key.hashCode() &  0x7fffffff)%originalCapacity; 
    }    
    
    // 存放值
    public void put(K key,V value){
        // 在存放value之前先验证是否需要扩容,散列值是否冲突 验证
        if(num>=loadCoefficient*capacity){ // 散列表中的key,value对 数量超过警戒值,为避免散列冲突概率增加，扩容
            resize(capacity*capCoefficient);// 默认扩容倍数为2
        }
        //使用 线性探测 策略排获取不冲突的散列值
        int index = linearProbing(key);
        // 存放值
        keys[index]=key;
        values[index]=value;
        ++num; //存放的键值对数量+1
    }

    // 通过Key取值
    public V getKey(K  key){
       //使用 线性探测 策略排获取不冲突的散列值
        int index = linearProbing(key);       
        return values[index];
    }

    /**
     * 对散列表进行动态扩容
     * @param newCapacity 散列表的新大小
     */
    public void resize(int newCapacity){
        LinearProbingHashMap<K,V> hashMap = new LinearProbingHashMap<K,V>(newCapacity);
        //将散列表中的key,value取出,放到新散列表中
        int i;
        for(i=0;i<keys.length;i++){
            hashMap.keys[i] = keys[i];
            hashMap.values[i] = values[i];
        }
        //将增大后并装载好值的 keys[]、values[]、散列表大小
        //赋值给当前正在使用的HashMap,完成对当前HashMap的扩容
        keys = hashMap.keys;
        values = hashMap.values;
        capacity = newCapacity;
    }

    /**
     * 通过key 删除散列表中 的key value
     */
    public void delete(K key){
        //使用 线性探测 策略排获取不冲突的散列值
        int index = linearProbing(key);
        keys[index]=null;
        values[index] = null;
    }

    /**
     * 线性探测策略
     * 作用：校验计算出的散列值是否冲突,解决冲突
     * @param key 输入的键
     * @return index 无冲突的散列值
     */
    public int linearProbing(K key){
        int index =hash(key);
        while(keys[index]!=null&&!keys[index].equals(key)){ // 考虑冲突的情况
            index++;
            if(index>capacity-1){ // 到达散列表末尾
                index = 0; //从头开始找
            }
        }
        return index; 
    }

    /**
     * 将散列表中 非空的key,value 以字符串的格式输出
     * @return  keysAndValues String格式的 key value
     */
    public String toString() {
        int i;
        String keysAndValues="{";
        for(i=0;i<capacity;i++){
            if(keys[i]!=null&&values[i]!=null){
                keysAndValues += keys[i] +"==" + values[i]+",";
            }
        }
        // 剔除最后的多余逗号
        keysAndValues =  keysAndValues.substring(0,keysAndValues.length()-1);
        return keysAndValues + "}";
    }
}