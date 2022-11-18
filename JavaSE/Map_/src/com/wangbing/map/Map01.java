package com.wangbing.map;/*
 * @author WangBing
 * @version 1.0
    Map 接口和常用方法
        Map 接口实现类的特点
            1）Map与Collection并列存在。用于保存具有映射关系的数据∶Key-Value
            2）Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
            3）Map 中的key不允许重复，原因和HashSet一样，前面分析过源码.
            4）Map中的value可以重复
            5）Map的key可以为null，value也可以为null，注意key为null，只能有一个,value为null，可以多个.
            6）常用String类作为Map的key
            7）key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
    Map 接口实现类-HashMap小结
        1）Map接口的常用实现类∶HashMap、Hashtable和Properties。
        2）HashMap是Map接口使用频率最高的实现类。
        3）HashMap是以key-val对的方式来存储数据（HashMap$Node类型）
        4）key不能重复，但是值可以重复，允许使用null键和null值。
        5）如果添加相同的key，则会覆盖原来的key-val，等同于修改（key不会替换，val会替换）
        6）与HashSet一样，不保证映射的顺序，因为底层是以hash表的方式来存储的，（jdk8的hashMap底层数组+链表+红黑树）
        7）HashMap没有实现同步，因此是线程不安全的，方法没有做同步互斥的操作，没有synchronized
    HashMap 底层机制及源码
        扩容机制【和HashSet相同】
            1）HashMap底层维护了Node类型的数组table，默认为null
            2）当创建对象时，将加载因子（loadfactor）初始化为0.75.
            3）当添加key-val时，通过key的哈希值得到在table的索引。
               然后判断该索引处是否有元素，如果没有元素直接添加。
               如果该索引处有元素，继续判断该元素的key和准备加入的key相是否等，
               如果相等，则直接替换val；
               如果不相等需要判断是树结构还是链表结构，做出相应处理。
               如果添加时发现容量不够，则需要扩容。
            4）第1次添加，则需要扩容table容量为16，临界值（threshold）为12（16*0.75）
            5）以后再扩客，则需要扩容table容量为原来的2倍（32），临界值为原来的2倍，即24，依次类推
            6）在Java8中，如果一条链表的元素个数超过TREEIFY THRESHOLD（默认是8），并且table的大小>=MIN_TREEIFY_CAPACITY（默认64），
            就会进行树化（红黑树）

    开发中如何选择集合实现类
        在开发中，选择什么集合实现类，主要取决于业务操作特点，然后根据集合实现类特性进行选择，分析如下∶
            1）先判断存储的类型（一组对象【单列或一组键值对【双列）
            2）一组对象【单列】Collection接口
               允许重复List
                   增删多LinkedList底层维护了一个双向链表
                   改查多ArrayList底层维护Object类型的可变数组
               不允许重复Set
                   无序HashSet 【底层是HashMap，维护了一个哈希表即（数组+链表+红黑树）】
                   排序TreeSet
               插入和取出顺序一致LinkedHashSet，维护数组+双向链表
            3）一组键值对【双列】∶Map
               键无序HashMap 【底层是哈希表 jdk7数组+链表，jdk8∶数组+链表+红黑树】
               键排序∶TreeMap
               键插入和取出顺序一致LinkedHashMap
               读取文件PropertiesII
 **/

import java.util.HashMap;
import java.util.Map;

public class Map01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //Map 接口实现类的特点, 使用实现类 HashMap
        //1. Map 与 Collection 并列存在。用于保存具有映射关系的数据:Key-Value(双列元素)
        //2. Map 中的 key 和 value 可以是任何引用类型的数据，会封装到 HashMap$Node 对象中
        //3. Map 中的 key 不允许重复，原因和 HashSet 一样.
        //4. Map 中的 value 可以重复
        //5. Map 的 key 可以为 null, value 也可以为 null ，注意 key 为 null,只能有一个，value 为 null ,可以多个
        //6. 常用 String 类作为 Map 的 key
        //7. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
        Map map = new HashMap();
        map.put("no1", "白眉鹰王");//k-v
        map.put("no2", "张无忌");//k-v
        map.put("no1", "张三丰");//当有相同的 k , 就等价于替换. map.put("no3", "张三丰");//k-v
        map.put(null, null); //k-v
        map.put(null, "abc"); //等价替换
        map.put("no4", null); //k-v
        map.put("no5", null); //k-v
        map.put(1, "赵敏");//k-v
        map.put(new Object(), "金毛狮王");//k-v
        // 通过 get 方法，传入 key ,会返回对应的 value
        System.out.println(map.get("no2"));//张无忌
        System.out.println("map=" + map);
    }
}
