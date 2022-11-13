/*
    String 类
        1.String对象用于保存字符串，也就是一组字符序列
        2.字符串常量对象是用双引号括起的字符序列。例如“你好”、“12.97”、“boy”等
        3.字符串的字符使用Unicode字符编码，一个字符（不区分字母还是汉字）占两个字节
        4.String类较常用构造器∶
            · String s1 = new StringO;
            · String s2=new String(String original);
            · String s3= new String(char[] a);
            · String s4= new String(char[] a,int startIndex,int count)
        5. String 类实现了
            接口 Serializable【String 可以串行化:可以在网络传输】
            接口 Comparable [String 对象可以比较大小]
        6. String 是 final 类，不能被其他的类继承
        7. String 有属性 private final char value[]; 用于存放字符串内容
        8. 一定要注意：value 是一个 final 类型，不可以修改：即 value 不能指向新的地址，但是单个字符内容是可以变化
   创建 String 对象的两种方式及区别
        1）方式一∶直接赋值Strings="WangBing"；
        2）方式二∶调用构造器Strings=new String（"WangBing"）；
        区别：
            1. 方式一先从常量池查看是否有“WangBing”数据空间，如果有，直接指向；如果没有则重新创建， 然后指向。s最终指向的是常量池的空间地址
            2. 方式二∶ 先在堆中创建空间， 里面维护了value属性， 指向常量池的WangBing空间。
               如果常量池没有"WangBing"，重新创建，如果有，直接通过value指向。最终指向的是堆中的空间地址。
   字符串的特性
        1）String是一个final类，代表不可变的字符序列
        2）字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的.
   String 类的常见方法
        String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低
        因此java设计者还提供了StringBuilder和StringBuffer来增强String的功能
        · equals//区分大小写，判断内容是否相等
        · equalsIgnoreCase//忽略大小写的判断内容是否相等
        · length//获取字符的个数，字符串的长度
        . indexOf//获取字符在字符串中第1次出现的索引，索引从0开始，如果找不到，返回-1
        · lastIndexOf//获取字符在字符串中最后1次出现的索引，索引从0开始，如找不到，返回-1
        · substring//截取指定范围的子串·trim//去前后空格
        · charAt∶获取某索引处的字符，注意不能使用Str【index】这种方式.
        · toUpperCase
        · toLowerCase
        · concat
        · replace替换字符串中的字符
        · split 分割字符串，对于某些分割字符，我们需要转义比如|\\等
            案例String poem = "锄禾日当午，汗滴禾下土，谁知盘中餐，粒粒皆辛苦"；和文件路径.
        · compareTo //比较两个字符串的大小toCharArray//转换成字符数组
        · format //格式字符串，%s字符串%c字符串%c.字符%d整型%.2f浮点型案例，将一个人的信息格式化输出.
* */

public class String01 {
    public static void main(String[] args) {

        String a = "hello" + "abc";
        //创建了几个对象只有1个对象?
        //String a="hello"+"abc"；
        //==>优化等价String a="helloabc"；
        //1.编译器会做一个优化，判断创建的常量池对象，是否有引用指向
        //2.String a="hello"+"abc";=> String a="helloabc";


    }
}

class String02 {
    String a = "hello";
    String b = "abc";
    //创建a对象String
    //创建 b对象
    String c = a + b;
    //创建了几个对象?
    //关键就是要分析Stringc=a+b；到底是如何执行的
    //一共有3对象，如图。
    //底层是 StringBuilder sb=new StringBuilder（）；
    //sb.append（a）；
    //sb.append（b）；
    //sb是在堆中，并且append是在原来字符串的基础上追加的
    //重要规则:
    //    String c1="ab"+"cd"；常量相加，看的是池。
    //    String c1=a+b；变量相加，是在堆中
}