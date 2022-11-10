/*
  枚举类
     为什么需要枚举类？
        假设我们想创建一个Season对象 只想让使用者传入”春夏秋冬“四个季节 这时候就需要枚举类
        Season对象的特点
        1) 季节的值是有限的几个值(spring, summer, autumn, winter)
        2) 只读，不需要修改。
     什么是枚举呢
        1) 枚举对应英文(enumeration, 简写 enum)
        2) 枚举是一组常量的集合。
        3) 可以这里理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象。
     枚举的二种实现方式
        1) 自定义类实现枚举
        2) 使用 enum 关键字实现枚举
     枚举的使用
        1.不需要提供setXxx方法，因为枚举对象值通常为只读.
        2.对枚举对象/属性使用final+static共同修饰，实现底层优化.
        3.枚举对象名通常使用全部大写，常量的命名规范.
        4.枚举对象根据需要，也可以有多个属性
     enum 关键字实现枚举的细节
        1) 当我们使用 enum 关键字开发一个枚举类时，默认会继承 Enum 类, 而且是一个 final 类
        2) 传统的 public static final Season2 SPRING = new Season2("春天", "温暖"); 简化成 SPRING("春天", "温暖")，
           这里必须知道，它调用的是哪个构造器.
        3) 如果使用无参构造器 创建 枚举对象，则实参列表和小括号都可以省略
        4) 当有多个枚举对象时，使用,间隔，最后有一个分号结尾
        5) 枚举对象必须放在枚举类的行首.
     enum 常用方法
        因为我们继承的是enum类 所以可以用类上面的一些常用方法
        1) toString:Enum 类已经重写过了，返回的是当前对象名,子类可以重写该方法，用于返回对象的属性信息
        2) name：返回当前对象名（常量名），子类中不能重写
        3) ordinal：返回当前对象的位置号，默认从 0 开始
        4) values：返回当前枚举类中所有的常量
        5) valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常！
        6) compareTo：比较两个枚举常量，比较的就是编号！
     enum 实现接口
        1) 使用 enum 关键字后，就不能再继承其它类了，因为 enum 会隐式继承 Enum，而 Java 是单继承机制。
        2) 枚举类和普通类一样，可以实现接口
*/

public class EnumAndAnnotation {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week week : weeks ) {
            System.out.println(week);
        }
    }
}

enum Season2 {
    //定义了四个对象, 固定. // public static final Season SPRING = new Season("春天", "温暖");
    // public static final Season WINTER = new Season("冬天", "寒冷");
    // public static final Season AUTUMN = new Season("秋天", "凉爽");
    // public static final Season SUMMER = new Season("夏天", "炎热");
    //如果使用了 enum 来实现枚举类
    //1. 使用关键字 enum 替代 class
    //2. public static final Season SPRING = new Season("春天", "温暖") 直接使用
    // SPRING("春天", "温暖") 解读 常量名(实参列表)
    //3. 如果有多个常量(对象)， 使用 ,号间隔即可
    //4. 如果使用 enum 来实现枚举，要求将定义常量对象，写在前面
    //5. 如果我们使用的是无参构造器，创建常量对象，则可以省略 ()
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"),
    AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热")/*, What()*/;
    private String name;
    private String desc;//描述
    private Season2() {//无参构造器
    }
    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

//声明 Week 枚举类，其中包含星期一至星期日的定义；
//MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
//使用 values 返回所有的枚举数组, 并遍历输出

enum  Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"),
    THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");
    private String name ;

    Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}