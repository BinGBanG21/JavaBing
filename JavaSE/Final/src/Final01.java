/*
* final 关键字
*   final意为∶最后的，最终的.
*   final可以修饰类、属性、方法和局部变量.
*   在某些情况下，可能有以下需求，就会使用到final∶
*       1）当不希望类被继承时，可以用final修饰.
*       2）当不希望父类的某个方法被子类覆盖/重写（override）时，可以用final关键字.
*       3）当不希望类的的某个属性的值被修改，可以用final修饰.
*       4）当不希望某个局部变量被修改，可以使用final修饰.
*   final 使用注意事项和细节讨论
*       1）final修饰的属性又叫常量，一般用 XX_XX_XX 来命名
*       2）final修饰的属性在定义时，必须赋初值，并且以后不能再修改，赋值可以在如下位置之一∶
            ① 定义时∶如public final double TAX_RATE = 0.08；
            ② 在构造器中
            ③ 在代码块中。
        3）如果final修饰的属性是静态的，则初始化的位置只能是①定义时 ②在静态代码块 不能在构造器中赋值。
        4）final类不能继承，但是可以实例化对象。
        5）如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承。
        6）一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法
           因为final用在方法上就是不希望被重写 但是现在都没法继承 所以是不会被重写的
        7）final不能修饰构造方法（即构造器）
        8）final和static往往搭配使用，效率更高，不会导致类加载.底层编译器做了优化处理。
        9）包装类（Integer，Double，Float，Boolean等都是final），String也是final类。
* */

public class Final01 {
    public static void main(String[] args) {

    }
}

//请编写一个程序，能够计算圆形的面积。要求圆周率为3.14.赋值的位置3个方式都写一下。
class Circle {
    private double radius;
    private final double PI = 3.14;

//    {
//        PI = 3.14;
//    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
        //PI = 3.14
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return radius * radius * PI;
    }
}