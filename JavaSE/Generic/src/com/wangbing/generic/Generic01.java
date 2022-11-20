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
        泛型的语法
            interface接口 <T> 和 class类<K，V> //比如∶List，ArrayList
                1）其中，T，K，V不代表值，而是表示类型。
                2）任意字母都可以。常用T表示，是Type的缩写
        泛型的实例化
            要在类名后面指定类型参数的值（类型）。如∶
                1）List<String>strList=newArrayList<String>0；
                2) Iterator<Customer> iterator= customers.iterator();
        泛型使用的注意事项和细节
            1. interface List<T>{}，public class HashSet<E>{}..等等
            说明：T，E只能是引用类型看看下面语句是否正确
                List<Integer>list=newArrayList<Integer>();//OK
                List<int>list2=newArrayList<int>0∶//错误
            2.在给泛型指定具体类型后，可以传入该类型或者其子类类型
            3. 泛型使用形式
                List<Integer>list1=newArrayList<Integer>();
                List<Integer>list2=newArrayList<>()；
            3.如果我们这样写 List list3= new ArrayList()；默认给它的 泛型是【<E> E就是 Object】
        自定义泛型类
            >基本语法
                class类名<T，R…>{//…表示可以有多个泛型成员
                注意细节
                1）普通成员可以使用泛型（属性、方法）
                2）使用泛型的数组，不能初始化
                3）静态方法中不能使用类的泛型
                4）泛型类的类型， 是在创建对象时确定的（因为创建对象时， 需要指定确定类型）
                5）如果在创建对象时，没有指定类型，默认为Object
 **/

import java.util.ArrayList;
import java.util.Arrays;

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

        //T=Double, R=String, M=Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是 Object 子类
        System.out.println("g2=" + g2);

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

//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个. //4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger<T, R, M> {
    String name;
    R r; //属性使用到泛型
    M m;
    T t;
    //因为数组在 new 不能确定 T 的类型，就无法在内存开空间
    T[] ts;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(R r, M m, T t) {//构造器使用泛型
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public Tiger(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    //因为静态是和类相关的，在类加载时，对象还没有创建
//所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化
// static R r2;
// public static void m1(M m) {
//
// }
//方法使用泛型
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {//方法使用到泛型
        this.r = r;
    }

    public M getM() {//返回类型可以使用泛型.
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
