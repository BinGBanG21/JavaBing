/*
	this 的注意事项和使用细节
		1) this 关键字可以用来访问本类的属性、方法、构造器
		2) this 用于区分当前类的属性和局部变量
		3) 访问成员方法的语法：this.方法名(参数列表);
		4) 访问构造器语法：this(参数列表); 注意只能在构造器中使用(即只能在构造器中访问另外一个构造器, 必须放在第一条语句)
		5) this 不能在类定义的外部使用，只能在类定义的方法中使用。
*/

public class This01 {
    public static void main(String[] args) {
        Person p1 = new Person("wangbing", 25);
        Person p2 = new Person("wangbingbing", 26);
        System.out.println(p1.compareTo(p2));
    }
}

class Dog {
    public String name;
    public int age;

    public Dog(String name, int age) {
        //如果改成name=name 那么就会遵循作用域的就近原则
        //也就是行参name自己给自己赋值 就不会去找我们外面声明的变量了
        // name=dName;
        // age=dAge;
        this.name = name;
        this.age = age;
        public void info () {
            System.out.println(name + "It" + age + "It");
            //问题∶构造方法的输入参数名不是非常的好，如果能够将dName 改成 name 就好了，但是我们会发现按照变量的作用域原则，name的值就是null，怎么解决->this
            //简单的说 那个对象调用 this就代表哪个对象
        }
    }
}
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person p) {
        // if (this.name.equals(p.name) && (this.age == p.age)) {
        // 	return true
        // } else {
        // 	return false
        // }
        return this.name.equals(p.name) && this.age == p.age;
    }
}