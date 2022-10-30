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


