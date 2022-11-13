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
            案例String poem = "锄禾日当午，汗滴禾下土，谁知盘中餐，粒粒皆辛苦" ；和文件路径.
        · compareTo //比较两个字符串的大小toCharArray//转换成字符数组
        · format //格式字符串，%s字符串%c字符串%c.字符%d整型%.2f浮点型案例，将一个人的信息格式化输出.
   StringBuffer类
        · StringBuffer代表可变的字符序列，可以对字符串内容进行增删。
        · 很多方法与String相同，但StringBuffer是可变长度的。
        · StringBuffer是一个容器。
        解读：
            1. StringBuffer 的直接父类 是 AbstractStringBuilder
            2. StringBuffer 实现了 Serializable, 即 StringBuffer 的对象可以串行化
            3. 在父类中 AbstractStringBuilder 有属性 char[] value,不是 final
               该 value 数组存放 字符串内容，引出存放在堆中的
            4. StringBuffer 是一个 final 类，不能被继承
            5. 因为 StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
               不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String
    String VS StringBuffer
        1）String保存的是字符串常量，里面的值不能更改，每次String类的更新实际
           上就是更改地址， 效率较低 //private final char value【】；
        2）StringBuffer保存的是字符串变量，里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，不用每次更新地址，效率较高
           char【】value；//这个放在堆.
    StringBuffer 类常用方法

* */

public class String01 {
    public static void main(String[] args) {

        String a = "hello" + "abc";
        //创建了几个对象只有1个对象?
        //String a="hello"+"abc"；
        //==>优化等价String a="helloabc"；
        //1.编译器会做一个优化，判断创建的常量池对象，是否有引用指向
        //2.String a="hello"+"abc";=> String a="helloabc";


        //String——>StringBuffer
        String str = "hello tom";
        //方式 1 使用构造器
        //注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式 2 使用的是 append 方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);
        //看看 StringBuffer ->String
        StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
        //方式 1 使用 StringBuffer 提供的 toString 方法
        String s = stringBuffer3.toString();
        //方式 2: 使用构造器来搞定
        String s1 = new String(stringBuffer3);


        //StringBuffer常见方法
        StringBuffer s8 = new StringBuffer("hello");
        //增
        s8.append(',');// "hello,"
        s8.append("张三丰");//"hello,张三丰"
        s8.append("赵敏").append(100).append(true).append(10.5);//"hello,张三丰赵敏 100true10.5" System.out.println(s);//"hello,张三丰赵敏 100true10.5"
        //删
        /*
         * 删除索引为>=start && <end 处的字符
         * 解读: 删除 11~14 的字符 [11, 14)
         */
        s8.delete(11, 14);
        System.out.println(s8);//"hello,张三丰赵敏 true10.5"
        //改
        //老韩解读，使用 周芷若 替换 索引 9-11 的字符 [9,11)
        s8.replace(9, 11, "周芷若");
        System.out.println(s8);//"hello,张三丰周芷若 true10.5"
        //查找指定的子串在字符串第一次出现的索引，如果找不到返回-1
        int indexOf = s8.indexOf("张三丰");
        System.out.println(indexOf);//6
        //插

        //在索引为 9 的位置插入 "赵敏",原来索引为 9 的内容自动后移
        s8.insert(9, "赵敏");
        System.out.println(s8);//"hello,张三丰赵敏周芷若 true10.5"
        //长度
        System.out.println(s8.length());//22
        System.out.println(s8);
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