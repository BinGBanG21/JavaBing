/*
面向对象编程三大特征
    面向对象编程有三大特征：封装、继承和多态。
封装
    封装（encapsulation）就是把抽象出的数据【属性】和对数据的操作【方法】封装在一起，数据被保护在内部
    程序的其它部分只有通过被授权的操作【方法】，才能对数据进行操作。
封装的理解和好处
    1）隐藏实现细节∶方法（连接数据库）<--调用（传入参数..）
    2）可以对数据进行验证，保证安全合理
封装的实现步骤
    1）将属性进行私有化private【不能直接修改属性】
    2）提供一个公共的（public）set方法，用于对属性判断并赋值
    public void setXxx（类型 参数名）</Xxx 表示某个属性
    //加入数据验证的业务逻辑属性=参数名；
    3）提供一个公共的（public）get方法，用于获取属性的值
    public 数据类型 getXxx（）{//权限判断，Xxx 某个属性
    return xx;
* */
//不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。
//年龄合理就设置，否则给默认年龄，必须在1-120
//年龄，工资不能直接查看 name的长度在2-6字符之间

public class Encapsulation {
    public static void main(String[] args) {
        Practice practice = new Practice();
        practice.setName("wangbing");
        practice.setAge(20);
        practice.setSalary(1000.0);
        System.out.println();
    }
}

class Practice {
    public String name;
    private int age;
    private double salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("输入的用户名有误 长度在2-6之间");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("设置的年龄不对 要在合理的年龄范围内");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void info() {
        System.out.println("姓名：" + name + "，年龄：" + age + ",薪水：" + salary);
    }

}