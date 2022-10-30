/*
* java 的动态绑定机制
*   Java 重要特性: 动态绑定机制
*       1) 当调用对象的方法的时候，该方法会和该对象的内存地址/运行类型绑定
*       2) 当调用对象属性时，没有动态绑定机制，哪里声明，就在哪里使用
* 多态的应用
*       1) 多态数组
*           数组的定义类型为父类类型，里面保存的实际元素类型为子类类型
*       2) 多态参数
*           方法定义的形参类型为父类类型，实参类型允许为子类类型
* */
public class DynamicBinding {
    public static void main(String[] args) {

    }
}
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //得到年工资的方法
    public double getAnnual(){
        return this.salary * 12;
    }
}

class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }
    public String work(){
        return "员工"+this.getName()+"is working";
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}