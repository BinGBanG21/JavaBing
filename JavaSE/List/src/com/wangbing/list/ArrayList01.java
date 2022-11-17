package com.wangbing.list;/*
 * @author WangBing
 * @version 1.0
    1 ArrayList 底层结构和源码分析
        ArrayList 的注意事项
            1）ArrayList可以放所有的元素 甚至null元素 可以放入多个 (permits all elements， including null)
            2）ArrayList是由数组来实现数据存储的【后面老师解读源码】
            3）ArrayList 基本等同于Vector，除了ArrayList是线程不安全（执行效率高）在多线程情况下，不建议使用ArrayList
    2 ArrayList 的底层操作机制
        1）ArrayList中维护了一个Object类型的数组elementData.
           transient Object【】 elementData；//transient 表示瞬间，短暂的，表示该属性不会被序列号
        2）当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0，
           第1次添加，则扩容elementData为10，如需要再次扩容，则扩容elementData为1.5倍。
        3） 如果使用的是指定大小的构造器， 则初始elementData容量为指定大小， 如果需要扩容，则直接扩容elementData为1.5倍。

 **/

import java.util.ArrayList;

public class ArrayList01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //Idea 默认情况下，Debug 显示的数据是简化后的，如果希望看到完整的数据
        //需要做设置
        //使用无参构造器创建 ArrayList 对象
        //ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        //使用 for 给 list 集合添加 1-10 数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用 for 给 list 集合添加 11-15 数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}
