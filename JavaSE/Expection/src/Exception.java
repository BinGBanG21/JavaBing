/*
    基本概念
        Java语言中，将程序执行中发生的不正常情况称为“异常”。（开发过程中的语法错误和逻辑错误不是异常）
    执行过程中所发生的异常事件可分为两大类
        1）Error（错误）∶Java虚拟机无法解决的严重问题。如∶JVM系统内部错误、资源耗尽等严重情况。
           比如StackOverflowError【栈溢出】和OOM（out of memory），Error是严重错误，程序会崩溃。
        2）Exception∶其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针
           对性的代码进行处理。例如空指针访问，试图读取不存在的文件，网络连接中断等等
           Exception分为两大类∶运行时异常【程序运行时，发生的异常】和编译时异常【编程时，编译器检查出的异常】
    异常的分类：
        1.异常分为两大类，运行时异常和编译时异常.
        2.运行时异常，编译器检查不出来。一般是指编程时的逻辑错误，是程序员应该
          避免其出现的异常。java.lang.RuntimeException类及它的子类都是运行时异常
        3.对于运行时异常，可以不作处理，因为这类异常很普遍，若全处理可能会对程序的可读性和运行效率产生影响
        4.编译时异常，是编译器要求必须处置的异常。
    常见的运行时异常
        1) NullPointerException 空指针异常
            当应用程序试图在需要对象的地方使用 null 时，抛出该异常
        2) ArithmeticException 数学运算异常
            当出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例
        3) ArrayIndexOutOfBoundsException 数组下标越界异常
            用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引
        4) ClassCastException 类型转换异常
            当试图将对象强制转换为不是实例的子类时，抛出该异常
        5) NumberFormatException 数字格式不正确异常[]
            当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常 => 使用异常我们
            可以确保输入是满足条件数字.
    编译异常
        编译异常是指在编译期间，就必须处理的异常，否则代码不能通过编译。
    常见的编译异常
        √ SQLException//操作数据库时，查询表可能发生异常
        √ IOException//操作文件时，发生的异常
        √ FileNotFoundException//当操作一个不存在的文件时，发生异常
        √ ClassNotFoundException//加载类，而该类不存在时，异常
        √ EOFException//操作文件，到文件末尾，发生异常
        √ illegalArgumentException//参数异常
    异常处理的方式
        1)try-catch-finally
            程序员在代码中捕获发生的异常，自行处理
        2)throws
            将发生的异常抛出，交给调用者（方法）来处理，最顶级的处理者就是JVM
    try-catch-finally处理机制示
        程序示意
        try {
            代码/可能有异常
        } catch(Exception e){
            //捕获到异常
            //1.当异常发生时
            //2.系统将异常封装成Exception对象e，传递给catch
            //3得到异常对象后，程序员，自己处理
            //4.如果没有发生异常catch代码块不执行
        }finally{
            //1.不管try代码块是否有异常发生，始终要执行finally
            //2.所以，通常将释放资源的代码，放在finally
        }

* */

public class Exception {
    public static void main(String[] args) {

    }
}
