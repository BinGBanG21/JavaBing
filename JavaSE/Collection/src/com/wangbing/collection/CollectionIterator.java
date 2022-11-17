package com.wangbing.collection;/*
 * @author WangBing
 * @version 1.0

    Collection 接口遍历元素方式 1-使用 Iterator(迭代器)
        1）Iterator对象称为迭代器， 主要用于遍历Collection 集合中的元素。
        2）所有实现了Collection接口的集合类都有一个iterator（）方法，用以返回
           一个实现了Iterator接口的对象，即可以返回一个迭代器。
        3）Iterator的结构.
        4）Iterator仅用于遍历集合，Iterator本身并不存放对象。
        迭代器的执行原理iterator.next()
            Iterator iterator = coll.iterator（）；//得到一个集合的迭代器new Date()
            //hasNext（）∶判断是否还有下一个元素while(iterator.hasNext()[
            //next（）作用1.下移2.将下移以后集合位置上的元素返回
            System.out.println(iterator.next0);
            注意：
                在调用iterator.next（）方法之前必须要调用iterator.hasNext（）进行检测。
                若不调用，且下一条记录无效，直接调用it.next（）会抛出NoSuchElementException异常。
   Collection 接口遍历对象方式 2-for 循环增强
        增强for循环，可以代替iterator迭代器
        特点∶增强for就是简化版的iterator，本质一样。只能用于遍历集合或数组。
        基本语法:
        for（元素类型元素名∶集合名或数组名）（
            访问元素
        }
 **/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        //System.out.println("col=" + col);
        //现在希望能够遍历 col 集合
        //1. 先得到 col 对应的 迭代器
        Iterator iterator = col.iterator();
        //2. 使用 while 循环遍历
        // while (iterator.hasNext()) {//判断是否还有数据
        // //返回下一个元素，类型是 Object
        // Object obj = iterator.next();
        // System.out.println("obj=" + obj);
        // }
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }
        //3. 当退出 while 循环后 , 这时 iterator 迭代器，指向最后的元素
        // iterator.next();//NoSuchElementException
        //4. 如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();
        System.out.println("===第二次遍历===");
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}