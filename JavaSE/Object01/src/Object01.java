/*
* Object 类
*   equals 方法
*       ==和 equals 的对比
*           ==是一个比较运算符
                1. ==∶既可以判断基本类型，又可以判断引用类型
                2. ==∶如果判断基本类型，判断的是值是否相等。示例∶int i=10；double d=10.0
                3. ==∶如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象
                4. equals∶ 是Object类中的方法， 只能判断引用类型
                5. 默认判断的是地址是否相等， 子类中往往重写该方法， 用于判断内容是否相等。
    hashCode 方法
        1) 提高具有哈希结构的容器的效率！
        2) 两个引用，如果指向的是同一个对象，则哈希值肯定是一样的！
        3) 两个引用，如果指向的是不同对象，则哈希值是不一样的
        4) 哈希值主要根据地址号来的！， 不能完全将哈希值等价于地址。
    toString 方法
        1) 基本介绍
            默认返回：全类名+@+哈希值的十六进制，子类往往重写 toString 方法，用于返回对象的属性信息
        2) 重写 toString 方法，打印对象或拼接对象时，都会自动调用该对象的 toString 形式.
        3) 当直接输出一个对象时，toString 方法会被默认的调用, 比如 System.out.println(monster)； 就会默认调用monster.toString()
    finalize 方法
        1) 当对象被回收时，系统自动调用该对象的 finalize 方法。子类可以重写该方法，做一些释放资源的操作
        2) 什么时候被回收：当某个对象没有任何引用时，则 jvm 就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来
            销毁该对象，在销毁该对象前，会先调用 finalize 方法。
        3) 垃圾回收机制的调用，是由系统来决定(即有自己的 GC 算法), 也可以通过 System.gc() 主动触发垃圾回收机制
    断点调试(debug)
        注意：在断点调试的过程中，程序是运行状态的，是以对象的运行类型来执行的。
        断点调试是指在程序的某一行设置一个断点， 调试时， 程序运行到这一行就会停住，
        然后你可以一步一步往下调试，调试过程中可以看各个变量当前的值，出错的话，调试到出错的代码行即显示错误，停下。进行分析从而找到这个Bug
    断点调试的快捷键
        F7(跳入) F8(跳过) shift+F8(跳出) F9(resume,执行到下一个断点)
        F7：跳入方法内
        F8: 逐行执行代码. shift+F8: 跳出方法
 * */

public class Object01 {
    public static void main(String[] args) {
        Person WangBing = new Person("wangbing", 22, '1');
        Person WangBingBing = new Person("wang", 22, '1');

    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    //编写MyEquals方法 当两个对象属性值相同时 则两个对象相等
    public boolean MyEquals(Object obj) {
        //如果判断的是同一个对象 直接return true
        if (this == obj) {
            return true;
        }
        //如果传入的对象类型不是Person类 return false  如果是的话 向下转型拿到person的属性
        //为什么要向下转型呢 因为函数参数的赋值过程就是 形参 = 实参 那么编译类型就是object类型
        //向下转型之后 我们就能够拿到person的属性 进行比较恶灵
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        return false;
    }
}


