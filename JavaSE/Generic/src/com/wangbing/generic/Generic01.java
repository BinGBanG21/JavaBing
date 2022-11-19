package com.wangbing.generic;/*
 * @author WangBing
 * @version 1.0
    泛型的理解和好处
        为什么需要泛型
            1）不能对加入到集合ArrayList中的数据类型进行约束（不安全）
            2）遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响
        泛型的好处
            1）编译时，检查添加元素的类型，提高了安全性
            2）减少了类型转换的次数，提高效率
            3）不再提示编译警告
        泛型介绍
            泛（广泛）型（类型）=>Integer，String，Dog
            1）泛型又称参数化类型，是Jdk5.0出现的新特性，解决数据类型的安全性问题
            2）在类声明或实例化时只要指定好需要的具体的类型即可。
            3）Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮
            4）泛型的作用是可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。
 **/

import java.util.ArrayList;

public class Generic01 {
    public static void main(String[] args) {
        //1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是 Dog 类型
        //2. 如果编译器发现添加的类型，不满足要求，就会报错
        //3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        //4. public class ArrayList<E> {} E 称为泛型,那么 Dog->E
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        //假如我不小心，添加了一只猫 在编译阶段就会报错
        //arrayList.add(new Cat("招财猫", 8));
        System.out.println("===使用泛型====");
        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat { //Cat 类
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}