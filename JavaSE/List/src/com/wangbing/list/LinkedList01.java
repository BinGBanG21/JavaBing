package com.wangbing.list;/*
 * @author WangBing
 * @version 1.0
    LinkedList
        1）LinkedList底层实现了双向链表和双端队列特点
        2）可以添加任意元素（元素可以重复），包括null
        3）线程不安全，没有实现同步
    LinkedList 的底层操作机制
        1）LinkedList底层维护了一个双向链表.
        2）LinkedList中维护了两个属性first和last分别指向首节点和尾节点
        3）每个节点（Node对象），里面又维护了prev、next、item三个属性，其中通过
           prev指向前一个，通过next指向后一个节点。最终实现双向链表.
        4）所以LinkedList的元素的添加和删除，不是通过数组完成的，相对来说效率较高。

 **/

public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node WangBing = new Node("wang");
        //连接三个结点，形成双向链表
        //jack -> tom -> WangBing
        jack.next = tom;
        tom.next = WangBing;
        //WangBing -> tom -> jack
        WangBing.pre = tom;
        tom.pre = jack;
        Node first = jack;//让 first 引用指向 jack,就是双向链表的头结点
        Node last = WangBing; //让 last 引用指向 WangBing,就是双向链表的尾结点
        //演示，从头到尾进行遍历
        System.out.println("===从头到尾进行遍历===");
        while (first != null) {
            //输出 first 信息
            System.out.println(first);
            first = first.next;
        }
        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (last != null) {
            //输出 last 信息
            System.out.println(last);
            last = last.pre;
        }
        //演示链表的添加对象/数据，是多么的方便
        //要求，是在 tom --------- 老韩直接，插入一个对象 smith
        //1. 先创建一个 Node 结点，name 就是 smith
        Node smith = new Node("smith");
        //下面就把 smith 加入到双向链表了
        smith.next = WangBing;
        smith.pre = tom;
        WangBing.pre = smith;
        tom.next = smith;
        //让 first 再次指向 jack
        first = jack;//让 first 引用指向 jack,就是双向链表的头结点
        System.out.println("===从头到尾进行遍历===");
        while (first != null) {
            //输出 first 信息
            System.out.println(first);
            first = first.next;
        }
        last = WangBing; //让 last 重新指向最后一个结点
        //演示，从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (last != null) {
            //输出 last 信息
            System.out.println(last);
            last = last.pre;
        }
    }
}

//定义一个 Node 类，Node 对象 表示双向链表的一个结点
class Node {
    public Object item; //真正存放数据
    public Node next; //指向后一个结点
    public Node pre; //指向前一个结点

    public Node(Object name) {
        this.item = name;
    }

    public String toString() {
        return "Node name=" + item;
    }
}