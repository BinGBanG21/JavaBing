package com.wangbing.arraymethod;
/*
 * @author WangBing
 * @version 1.0
 **/


import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        /*
        自定义 Book 类，里面包含 name 和 price，按 price 排序(从大到小)。
        要求使用两种方式排序 , 有一个 Book[] books = 4 本书对象. 使用前面学习过的传递 实现 Comparator 接口匿名内部类，也称为定制排序。
        可以按照 price (1)从大到小 (2)从小到大 (3) 按照书名长度从大到小
        */
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);

        //按照price排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //因为还没讲到泛型 所以这里先类型转换一下
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                //这里不能强转 因为强转相当于取整 如果差值0.几 就会为0
                //排序结果和gap的值有关
                //如果是书名的话  就getName 然后 .length()方法
                double gap = book1.getPrice() - book2.getPrice();
                if (gap > 0) {
                    return -1;
                } else if (gap < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", price=" + price +
                '}';
    }
}