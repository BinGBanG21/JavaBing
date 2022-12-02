package com.wangbing;/*
 * @author WangBing
 * @version 1.0
     Class 类
        1.Class也是类，因此也继承Object类
        2.Class类对象不是new出来的，而是系统创建的
        3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        4.每个类的实例都会记得自己是由哪个Class实例所生成
        5.通过Class对象可以完整地得到一个类的完整结构，通过一系列API
        6.Class对象是存放在堆的
        7.类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等等）
     常用方法
         方法名                                                  功能说明
         static Class forName(String name)                      返回指定类名 name 的 Class 对象
         Object newInstance()                                   调用缺省构造函数，返回该Class对象的一个实例
         getName()                                              返回此Class对象所表示的实体（类、接口、数组类、基本类型等）名称
         Class[] getInterfaces()                                获取当前Class对象的接口
         ClassLoader getClassLoader()                           返回该类的类加载器
         Class getSuperclass()                                  返回表示此Class所表示的实体的超类的Class
         Constructor[]getConstructors()                         返回一个包含某些Constructor对象的数
         Field[] getDeclaredFields()                            返回Field对象的一个数组
         Method getMethod                                       返回一个Method对象，此对象的形参类型为paramType
         (String name.Class …paramTypes)
     如何获取 Class 类对象
        1. 前提已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName（）获取，
           可能抛出ClassNotFoundException
           实例∶Class cls1=Class.forName("java.lang.Cat");
           应用场景：多用于配置文件，读取类全路径，加载类.
        2.前提若已知具体的类，通过类的class 获取，该方式最为安全可靠，程序性能最高
          实例：Class cls2=Cat.class；
          应用场景：多用于参数传递，比如通过反射得到对应构造器对象.
        3. 前提已知某个类的实例，调用该实例的getClass（）方法获取Class对象，
           实例∶Class clazz=对象.getClass（）//运行类型应用场景∶通过创建好的对象，获取Class对象.
        4. 其他方式
           ClassLoader cl=对象.getClass（）.getClassLoader（）；
           Class clazz4=cl.loadClass（“类的全类名”）；
        5. 基本数据（int，char，boolean，float，double，byte，long，short）按如下方式得到Class类对象
           Class cls = 基本数据类型.class
        6. 基本数据类型对应的包装类，可以通过.TYPE得到Class类对象
           Class cls = 包装类.TYPE
 **/

import java.lang.reflect.Field;

public class class_ {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //class常用方法
        String classAllPath = "com.wangbing.Car";
        //1 . 获取到 Car 类 对应的 Class 对象
        //<?> 表示不确定的 Java 类型
        Class<?> cls = Class.forName(classAllPath);
        //2. 输出 cls
        System.out.println(cls); //显示 cls 对象, 是哪个类的 Class 对象 com.wangbing.Car
        System.out.println(cls.getClass());//输出 cls 运行类型 java.lang.Class
        //3. 得到包名
        System.out.println(cls.getPackage().getName());//包名
        //4. 得到全类名
        System.out.println(cls.getName());
        //5. 通过 cls 创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString()
        //6. 通过反射获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//宝马
        //7. 通过反射给属性赋值
        brand.set(car, "奔驰AMG");
        System.out.println(brand.get(car));//奔驰
        //8 我希望大家可以得到所有的属性(字段)
        System.out.println("=======所有的字段属性====");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());//名称
        }
    }
}
