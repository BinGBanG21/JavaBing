
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    反射(reflection)
        反射机制
            1.反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息（比如成员变量，构造器，成员方法等等）
              并能操作对象的属性及方法。反射在设计模式和框架底层都会用到
            2.加载完类之后，在堆中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象包含了类的完整结构信息。
              通过这个对象得到类的结构。这个Class对象就像一面镜子，透过这个镜子看到类的结构，所以，形象的称之为反射
        Java 反射机制可以完成
            1.在运行时判断任意一个对象所属的类
            2.在运行时构造任意一个类的对象
            3.在运行时得到任意一个类所具有的成员变量和方法
            4.在运行时调用任意一个对象的成员变量和方法
            5.生成动态代理
        反射相关的主要类
            1.java.lang.Class∶代表一个类，Class对象表示某个类加载后在堆中的对象
            2.java.lang.reflect.Method∶代表类的方法，Method对象表示某个类的方法
            3.java.lang.reflect.Field∶代表类的成员变量，Field对象表示某个类的成员变量
            4.java.lang.reflect.Constructor∶代表类的构造方法，Constructor对象表示
构造器
* */
@SuppressWarnings({"all"})
public class Reflection_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //根据配置文件 re.properties 指定信息, 创建 Cat 对象并调用方法 hi
        //传统的方式 new 对象 -》 调用方法
        // Cat cat = new Cat();
        // cat.hi(); ===> cat.cry() 修改源码. //我们尝试做一做 -> 明白反射
        //1. 使用 Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        //"com.wangbing.Cat"
        String methodName = properties.get("method").toString();//"hi"
        // System.out.println("classfullpath=" + classfullpath);
        //System.out.println("method=" + methodName);
        //2. 创建对象 , 传统的方法，行不通 =》 反射机制
        //new classfullpath();
        //3. 使用反射机制解决
        //(1) 加载类, 返回 Class 类型的对象 cls
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.wangbing.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o 的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 com.wangbing.Cat 的 methodName"hi" 的方法对象
        // 即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过 method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)
    }
}
