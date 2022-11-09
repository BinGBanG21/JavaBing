/*
*   类的五大成员:【属性、方法、构造器、代码块、内部类】
*   内部类
*       一个类的内部又完整的嵌套了另一个类结构。被嵌套的类称为内部类（inner class），嵌套其他类的类称为外部类（outer class）。
*       如果定义类在局部位置(方法中/代码块) :(1) 局部内部类 (2) 匿名内部类
        定义在成员位置 (1) 成员内部类 (2) 静态内部类
    内部类的分类
        定义在外部类局部位置上（比如方法内）
            1）局部内部类（有类名）
            2）匿名内部类（没有类名，重点!）
        定义在外部类的成员位置上∶
            1）成员内部类（没用static修饰）
            2）静态内部类（使用static修饰）
    局部内部类的使用细节
        说明：局部内部类是定义在外部类的局部位置，比如方法中，并且有类名。
            1.可以直接访问外部类的所有成员，包含私有的
            2.不能添加访问修饰符，因为它的地位就是一个局部变量。局部变量是不能使用
            修饰符的。但是可以使用final修饰，因为局部变量也可以使用final
            3.作用域仅仅在定义它的方法或代码块中。
            4.局部内部类---访问--->外部类的成员【访问方式∶直接访问】
            5.外部类---访问---->局部内部类的成员
                访问方式∶创建对象，再访问（注意∶必须在作用域内）记住∶
                （1）局部内部类定义在方法中/代码块
                （2）作用域在方法体或者代码块中
                （3）本质仍然是一个类
            6.外部其他类---不能访问--->局部内部类（因为局部内部类地位是一个局部变量）
            7.如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
    匿名内部类的使用
        （1）本质是类
        （2）内部类
        （3）该类没有名字
        （4）同时还是一个对象
         说明:匿名内部类是定义在外部类的局部位置，比如方法中，并且没有类名
    匿名内部类的细节
         1.匿名内部类的语法比较奇特，因为匿名内部类既是一个类的定义，同时它本身也是一个对象
           因此从语法上看，它既有定义类的特征，也有创建对象的特正，对前面代码分析可以看出这个特点，因此可以调用匿名内部类方法。
           个人理解: 主要目的就是为了简化开发 可以不实现接口就重写接口的方法 不继承类重写类的方法
         2.可以直接访问外部类的所有成员，包含私有的
         3.不能添加访问修饰符，因为它的地位就是一个局部变量
         4.作用域仅仅在定义它的方法或代码块中
         5.匿名内部类---访问--->外部类成员【访问方式∶直接访问】
         6.外部其他类---不能访问--->匿名内部类（因为匿名内部类地位是一个局部变量）
         7.如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，默认遵循就近原则，如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
    匿名内部类的最佳实践
        当做实参直接传递，简洁高效。
* */


public class InnerClass {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        Bell bell = new Bell() {
            @Override
            public void ring() {

                System.out.println("懒猪起床了");
            }
        };
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

class LocalInnerClass {//

    public static void main(String[] args) {
//演示一遍
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02 的 hashcode=" + outer02);
    }
}

class Outer02 {//外部类
    private int n1 = 100;

    private void m2() { //私有方法
        System.out.println("Outer02 m2()");
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void m1() {//方法
        //1.局部内部类是定义在外部类的局部位置,通常在方法
        //3.不能添加访问修饰符,但是可以使用 final 修饰
        //4.作用域 : 仅仅在定义它的方法或代码块中
        final class Inner02 {//局部内部类(本质仍然是一个类)
            //2.可以直接访问外部类的所有成员，包含私有的
            private int n1 = 800;

            public int getN1() {
                return n1;
            }

            public void setN1(int n1) {
                this.n1 = n1;
            }

            public void f1() {
                //5. 局部内部类可以直接访问外部类的成员，比如下面 外部类 n1 和 m2()
                //7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，
                // 使用 外部类名.this.成员）去访问
                // Outer02.this 本质就是外部类的对象, 即哪个对象调用了 m1, Outer02.this 就是哪个对象
                System.out.println("n1=" + n1 + " 外部类的 n1=" + Outer02.this.n1);
                System.out.println("Outer02.this hashcode=" + Outer02.this);
                m2();
            }
        }
        //6. 外部类在方法中，可以创建 Inner02 对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}

/*
1.有一个铃声接口 Bell，里面有个 ring 方法。
2.有一个手机类 Cellphone，具有闹钟功能 alarmClock，参数是 Bell 类型
3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印：懒猪起床了
4.再传入另一个匿名内部类(对象)，打印：小伙伴上课了
*/
interface Bell { //接口
    void ring();//方法
}

class CellPhone {//类

    public void alarmClock(Bell bell) {//形参是 Bell 接口类型
        System.out.println(bell.getClass());
        bell.ring();//动态绑定
    }
}