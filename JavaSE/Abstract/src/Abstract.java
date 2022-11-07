/*
*   抽象类的使用场景
*       总结一句：父类方法的不确定性
*       当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法，那么这个类就是抽象类
*       当一个类中存在抽象方法时，需要将该类声明为 abstract 类
*       一般来说，抽象类会被继承，有其子类来实现抽象方法
*   抽象类
*       1）用abstract关键字来修饰一个类时，这个类就叫抽象类
            访问修饰符  abstract  类名 {
            }
*       2）用abstract关键字来修饰一个方法时，这个方法就是抽象方法
            访问修饰符 abstract 返回类型 方法名（参数列表）；//没有方法体
*       3）抽象类的价值更多作用是在于设计，是设计者设计好后，让子类继承并实现抽象类
*   抽象类使用注意和细节
*       1）抽象类不能被实例化
*       2）抽象类不一定要包含abstract方法。也就是说，抽象类可以没有abstract方法
*       3）一旦类包含了abstract方法，则这个类必须声明为abstract
*       4）abstract只能修饰类和方法，不能修饰属性和其它的
*       5）抽象类可以有任意成员【抽象类本质还是类】，比如∶非抽象方法、构造器、静态属性等等
*       6）抽象方法不能有主体，即不能实现
*       7）如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类
*       8）抽象方法不能使用private、final和static来修饰，因为这些关键字都是和重写相违背的
*   抽象类最佳实践-模板设计模式
*       抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造
*       但子类总体上会保留抽象类的行为方式。
*   模板设计模式能解决的问题
*       1）当功能内部一部分实现是确定，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
*       2）编写一个抽象父类，父类提供了多个子类的通用方法，并把一个或多个方法留给其子类实现，就是一种模板模式.
*
* */
public class Abstract {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 28, 20000);
        jack.setBonus(10000);
        jack.work();
        CommonEmployee tom = new CommonEmployee("tom", 22, 10000);
        tom.work();
    }
}

/*
 * 编写一个Employee类，声明为抽象类，包含如下三个属性∶name，id，salary。提供必要的构造器和抽象方法work（）
 * 对于Manager类来说，他既是员工，还具有奖金（bonus）的属性。
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问，实现work（）
 * 提示“经理/普通员工名字工作中…" OOP的继承+抽象类
 * */
abstract class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //抽象的work方法
    abstract public void work();

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理" + getName() + "正在工作中...");
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work() {
        System.out.println("员工" + getName() + "正在工作中...");
    }
}

/*
* 抽象类应用示例——最佳实践
*   设计一个抽象类（Template）完成如下功能
*       1)编写方法calculateTime(),可以计算某段代码的耗时时间
*       2)编写抽象方法job()
*       3)编写一个子类Sub,继承抽象类Template，并实现job方法。
*      abstract class Template{ //抽象类
*           public abstract void job);//抽象方法
*           public void caleTimes { //统计耗时多久是确定
*               //统计当前时间距离1970-1-1 0:0:0的时间差,单位ms
*               long start = System.currentTimeMillis();
*               job();
*               long end = System.currentTimeMillis();
*               System.out.println(“耗时:"+(end-start));
*   总结：子类首先重写job方法 然后继承父类 使用时 子类.caleTimers 调用父类的方法
*        因为调用方法时存在动态绑定机制 job方法就为子类的job方法
* */
