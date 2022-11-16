package com.wangbing.collection;/*
 * @author WangBing
 * @version 1.0
    集合的理解和好处
        前面我们保存多个数据使用的是数组，那么数组有不足的地方呢？
            1）长度开始时必须指定，而且一旦指定，不能更改
            2）保存的必须为同一类型的元素
            3）使用数组进行增加/删除元素的示意代码-比较麻烦
        集合
            1）可以动态保存任意多个对象，使用比较方便!
            2）提供了一系列方便的操作对象的方法∶ add、remove、set、get等
            3）使用集合添加，删除新元素代码更简洁
        Collection 接口实现类的特点
            1）collection实现子类可以存放多个元素，每个元素可以是Object
            2）有些Collection的实现类，可以存放重复的元素，有些不可以
            3）有些Collection的实现类，有些是有序的（List），有些不是有序（Set）
            4）Collection接口没有直接的实现子类，是通过它的子接口Set和List 来实现的

 **/

import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
    public static void main(String[] args) {
        @SuppressWarnings({"all"})
        //1. 集合主要是两组(单列集合-值 , 双列集合-键值对)
        //2. Collection 接口有两个重要的子接口 List Set , 他们的实现子类都是单列集合
        //3. Map 接口的实现子类 是双列集合，存放的 K-V
        //4. 把老师梳理的两张图记住
        //Collection
        //Map
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");
        HashMap hashMap = new HashMap();
        hashMap.put("NO1", "北京");
        hashMap.put("NO2", "上海");


    }
}
