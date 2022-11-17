package com.wangbing.list;/*
 * @author WangBing
 * @version 1.0
    List接口是Collection接口的子接口
        1）List集合类中元素有序（即添加顺序和取出顺序一致）、且可重复【
        2）List集合中的每个元素都有其对应的顺序索引，即支持索引。
        3）List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
    List 接口的常用方法 ListMethod.java
    List 的三种遍历方式 [ArrayList, LinkedList,Vector]
        方式一∶使用iterator
        Iterator iter = col.iterator();
        while(iter.hasNext()){
            Object o = iter.next()
        }
        2）方式二∶使用增强for for(Object o:col)
        3）方式三∶使用普通for
        for (int i=0;i<list.size();i++){
                Object object = list.get(i);
                System.out.println(object);
            }
        使用LinkedList完成使用方式和ArrayList一样
 **/

import java.util.ArrayList;
import java.util.List;

public class List01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1. List 集合类中元素有序(即添加顺序和取出顺序一致)、且可重复 [案例]
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("wangbing");
        list.add("tom");
        System.out.println("list=" + list);
        //2. List 集合中的每个元素都有其对应的顺序索引，即支持索引
        // 索引是从 0 开始的
        System.out.println(list.get(3));//hsp
        //3.
    }
}
