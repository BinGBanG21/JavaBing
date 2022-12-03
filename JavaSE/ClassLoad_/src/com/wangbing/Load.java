package com.wangbing;/*
 * @author WangBing
 * @version 1.0
    类加载
        反射机制是java实现动态语言的关键，也就是通过反射实现类动态加载。
           1.静态加载∶编译时加载相关的类，如果没有则报错，依赖性太强
           2.动态加载运行时加载需要的类，如果运行时不用该类，即使不存在该类，则不报错，降低了依赖性
    类加载时机
        1.当创建对象时（new）                   //静态加载
        2.当子类被加载时，父类也加载              //静态加载
        3.调用类中的静态成员时                   //静态加载
        4.通过反射                             //动态加载Class.forName("com.test.Cat");
    类加载各阶段完成任务
        加载阶段
            JVM在该阶段的主要目的是将字节码从不同的数据源（可能是class 文件、也可能是jar包，甚至网络）转化为二进制字节流加载到内存中
            并生成一个代表该类的java.lang.Class对象
        连接阶段-验证
            1.目的是为了确保Class 文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
            2.包括∶ 文件格式验证（是否以魔数 oxcafebabe开头）、元数据验证、字节码验证和符号引用验证
            3.可以考虑使用-Xverify∶none参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间。
        连接阶段-准备
            JVM会在该阶段对静态变量，分配内存并默认初始化（对应数据类型的默认初始值，如0、0L、null、false等）。
            这些变量所使用的内存都将在方法区中进行分配
        连接阶段-解析
            虚拟机将常量池内的符号引用替换为直接引用的过程。
        Initialization（初始化)
            1.到初始化阶段，才真正开始执行类中定义的Java程序代码，此阶段是执行<clinit>0方法的过程。
            2.<clinit>（）方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有
              静态变量的赋值动作和静态代码块中的语句，并进行合并。【举例说明ClassLoad03.javal
            3.虚拟机会保证一个类的<clinit>（）方法在多线程环境中被正确地加锁、同步，如果
              多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>（）方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>（）方法完毕
        通过反射获取类的结构信息
            
 **/

public class Load {
    public static void main(String[] args) {
        //1. 加载 B 类，并生成 B 的 class 对象
        //2. 链接 num = 0
        //3. 初始化阶段
        // 依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并合并
        /*
        clinit() {
        System.out.println("B 静态代码块被执行");
        //num = 300;
        num = 100;
        }
        合并: num = 100
        */
        //new B();//类加载
        //System.out.println(B.num);//100, 如果直接使用类的静态属性，也会导致类的加载
        //看看加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
        //正因为有这个机制，才能保证某个类在内存中, 只有一份 Class 对象
        synchronized (getClassLoadingLock(name)) {
        //.... }
        }

        B b = new B();
        */

    }
}

class A {
    //属性-成员变量-字段
    //尝试分析类加载的链接阶段-准备 属性是如何处理、
    //1. n1 是实例属性, 不是静态变量，因此在准备阶段，是不会分配内存
    //2. n2 是静态变量，分配内存 n2 是默认初始化 0 ,而不是 20
    //3. n3 是 static final 是常量, 他和静态变量不一样, 因为一旦赋值就不变 n3 = 30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {//构造器
        System.out.println("B() 构造器被执行");
    }
}