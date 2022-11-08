/*
*   接口的基本介绍
*       生活中的接口
*           usb插槽就是现实中的接口。
            你可以把手机，相机，u盘都插在usb插槽上，而不用担心那个插槽是专门插哪个的
            原因是做usb插槽的厂家和做各种设备的厂家都遵守了统一的规定包括尺寸，排线等等
*       接口就是给出一些没有实现的方法，封装到一起，到某个类要使用的时候，在根据具体情况把这些方法写出来。语法∶
*           interface 接口名（
*               //属性
*               //抽象方法
*           }
*           class类名 implements 接口{
                自己属性
                自己方法
                必须实现的接口的抽象方法
            }
*
*       小结接口是更加抽象的抽象的类，抽象类里的方法可以有方法体，接口里的所有方法都没有方法体【jdk7.0】
*       接口体现了程序设计的多态和高内聚低偶合的设计思想。
*       特别说明：Jdk8.0后接口类可以有静态方法，默认方法，也就是说接口中可以有方法的具体实现
*   接口的注意和实现细节
*       1）接口不能被实例化
*       2）接口中所有的方法是public方法，接口中抽象方法，可以不用abstract修饰（默认就是抽象方法）
*       3）一个普通类实现接口，就必须将该接口的所有方法都实现
*       4）抽象类实现接口，可以不用实现接口的方法
*       5）一个类同时可以实现多个接口
*       6）接口中的属性，只能是final的，而且是public static final修饰符。
*          比如∶ int a=1；实际上是public static final int a=1
*       7）接口中属性的访问形式∶接口名.属性名
*       8）接口不能继承其它的类，但是可以继承多个别的接口
*       9）接口的修饰符只能是public和默认，这点和类的修饰符是一样的
*   接口和继承类的区别
*       接口和继承解决的问题不同
*           继承的价值主要在于：解决代码的复用性和可维护性。
            接口的价值主要在于：设计，设计好各种规范（方法），让其它类去实现这些方法。即更加的灵活..
        接口比继承更加灵活
            接口比继承更加灵活，继承是满足is·a的关系，而接口只需满足like·a的关系。
        接口在一定程度上实现代码解耦 【即∶接口规范性+动态绑定机制】
        个人理解：一句话 interface是对java单继承机制的一种补充
                继承是天生就会的 出生就自带的 interface是后天学习的
                当我们发现继承过来的类的方法不满足我们的需求 可以同过implements继续拓展
* */
public class Interface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}
class Monkey {
    private String name;
    public Monkey(String name) {
        this.name = name;
    }
    public void climbing() {
        System.out.println(name + " 会爬树...");
    }
    public String getName() {
        return name;
    }
}

//接口
interface Fishable {
    void swimming();
}
interface Birdable {
    void flying();
}

//继承
//小结: 当子类继承了父类，就自动的拥有父类的功能
//如果子类需要扩展功能，可以通过实现接口的方式扩展.
//可以理解 实现接口 是 对 java 单继承机制的一种补充.

class LittleMonkey extends Monkey implements Fishable,Birdable {
    public LittleMonkey(String name) {
        super(name);
    }
    @Override
    public void swimming() {
        System.out.println(getName() + " 通过学习，可以像鱼儿一样游泳...");
    }
    @Override
    public void flying() {
        System.out.println(getName() + " 通过学习，可以像鸟儿一样飞翔...");
    }
}