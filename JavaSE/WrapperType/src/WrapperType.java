/*
    包装类
        1) 针对八种基本数据类型相应的引用类型—包装类
        2) 有了类的特点，就可以调用类中的方法
    包装类和基本数据的转换
        1）jdk5前的手动装箱和拆箱方式，装箱∶基本类型->包装类型，反之，拆箱
        2）jdk5以后（含jdk5）的自动装箱和拆箱方式
        3）自动装箱底层调用的是valueOf方法，比如Integer.valueOf（）
        4）其它包装类的用法类似
*
* */


public class WrapperType {
    public static void main(String[] args) {
        //包装类型和 String 类型的相互转换
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

        //Integer 类和 Character 类的常用方法
        System.out.println(Integer.MIN_VALUE); //返回最小值
        System.out.println(Integer.MAX_VALUE);//返回最大值
        System.out.println(Character.isDigit('a'));//判断是不是数字
        System.out.println(Character.isLetter('a'));//判断是不是字母
        System.out.println(Character.isUpperCase('a'));//判断是不是大写
        System.out.println(Character.isLowerCase('a'));//判断是不是小写
        System.out.println(Character.isWhitespace('a'));//判断是不是空格
        System.out.println(Character.toUpperCase('a'));//转成大写
        System.out.println(Character.toLowerCase('A'));//转成小写

        Integer i1 = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i1 == j); //Falses


        //所以，这里主要是看范围 -128 ~ 127 就是直接返回
        /*
        //1. 如果 i 在 IntegerCache.low(-128)~IntegerCache.high(127),就直接从数组返回
        //2. 如果不在 -128~127,就直接 new Integer(i)
        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
        }
        */
        Integer m = 1; //底层 Integer.valueOf(1); -> 阅读源码
        Integer n = 1;//底层 Integer.valueOf(1);
        System.out.println(m == n); //T
        //所以，这里主要是看范围 -128 ~ 127 就是直接返回
        //，否则，就 new Integer(xx);
        Integer x = 128;//底层 Integer.valueOf(1);
        Integer y = 128;//底层 Integer.valueOf(1);
        System.out.println(x == y);//False
    }
}
