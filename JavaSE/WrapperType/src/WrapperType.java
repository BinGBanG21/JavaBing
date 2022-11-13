/*
    包装类
        1) 针对八种基本数据类型相应的引用类型—包装类
        2) 有了类的特点，就可以调用类中的方法
    包装类和基本数据的转换
        1）jdk5前的手动装箱和拆箱方式，装箱∶基本类型->包装类型，反之，拆箱
        2）jdk5以后（含jdk5）的自动装箱和拆箱方式
        3）自动装箱底层调用的是valueOf方法，比如Integer.valueOf（）
        4）其它包装类的用法类似
    包装类型和 String 类型的相互转换


*
* */


public class WrapperType {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100;//自动装箱
        //方式 1
        String str1 = i + "";
        //方式 2
        String str2 = i.toString();
        //方式 3
        String str3 = String.valueOf(i);
        //String -> 包装类(Integer)
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        Integer i3 = new Integer(str4);//构造器
        System.out.println("ok~~");
    }
}
