package com.wangbing.set;/*
 * @author WangBing
 * @version 1.0
    Set 接口和常用方法
        1) 无序（添加和取出的顺序不一致），没有索引
        2）不允许重复元素，所以最多包含一个null
    Set 接口的常用方法
        和 List 接口一样, Set 接口也是 Collection 的子接口，因此，常用方法和 Collection 接口一样
    Set 接口的遍历方式
        同Collection的遍历方式一样，因为Set接口是Collection接口的子接口。
        1.可以使用迭代器
        2.增强for
        3.不能使用索引的方式来获取
    HashSet 底层机制
        1.HashSet底层是HashMap
        2.添加一个元素时，先得到hash值-会转成->索引值
        3.找到存储数据表table，看这个索引位置是否已经存放的有元素
        4.如果没有，直接加入
        5.如果有，调用equals比较，如果相同，就放弃添加，如果不相同，则添加到最后
        6.在Java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD（默认是8），并且table的大小>=MIN TREEIFY CAPACITY（默认64），
          就会进行树化（红黑树）

 **/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class set01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //Set总结
        //1. 以 Set 接口的实现类 HashSet 来讲解 Set 接口的方法
        //2. set 接口的实现类的对象(Set 接口对象), 不能存放重复的元素, 可以添加一个 null
        //3. set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
        //4. 注意：取出的顺序的顺序虽然不是添加的顺序，但是他的固定.

        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");//重复
        set.add("jack");
        set.add("WangBing");
        set.add("mary");
        set.add(null);//
        set.add(null);//再次添加 null
        for (int i = 0; i < 10; i++) {
            System.out.println("set=" + set);
        }
        //遍历
        //方式 1： 使用迭代器
        System.out.println("=====使用迭代器====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }
        set.remove(null);
        //方式 2: 增强 for
        System.out.println("=====增强 for====");
        for (Object o : set) {
            System.out.println("o=" + o);
        }
        //set 接口对象，不能通过索引来获取

    }
}
