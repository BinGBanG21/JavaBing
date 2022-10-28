/*
方法重写/覆盖(override)
    简单的说方法覆盖（重写）就是子类有一个方法，和父类的某个方法的名称、返回类型、参数一样
    那么我们就说子类的这个方法覆盖了父类的方法
注意事项和使用细节
    方法重写也叫方法覆盖，需要满足下面的条件
        1.子类的方法的形参列表，方法名称，要和父类方法的形参列表，方法名称完全一样。
        2.子类方法的返回类型和父类方法返回类型一样，或者是父类返回类型的子类
            比如父类返回类型是Object，子类方法返回类型是String
                public String getInfo(){}
                public Object getInfo(){}
        3. 子类方法不能缩小父类方法的访问权限 public > protected > 默认>private
                void say(){}
                public void say(){}
方法重载与重写
    名称              发生范围              形参列表                返回类型                          修饰符
    重载（overload）    本类                必须一样                 无要求                           无要求
    重写（override）    父子类                相同            子类重写的方法，返回的类型      子类方法不能缩小父类方法的访问范围.
                                                        和父类返回的类型一致，或者是其子类
* */
// 1) 编写一个 Person 类，包括属性/private（name、age），构造器、方法 say(返回自我介绍的字符串）。
// 2) 编写一个 Student 类，继承 Person 类，增加 id、score 属性/private，以及构造器，定义 say 方法(返回自我介绍的信息)。
// 3) 在 main 中,分别创建 Person 和 Student 对象，调用 say 方法输出自我介绍
public class Override {
    public static void main(String[] args) {
        Person person = new Person("wangbing", 25);
        Student student = new Student("xiaobing", 15, "0x11", 98.75);
        System.out.println(person.say());
        System.out.println(student.say());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say() {
        return "名字是：" + this.name + ",年龄为：" + this.age;
    }

}

class Student extends Person {
    private String id;
    private double score;

    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        return super.say() + " ID 为：" + this.id + ",分数为：" + this.score;
    }
}

















