/*
    通过反射获取类的结构信息
        第一组: java.lang.Class 类
            1.getName∶获取全类名
            2.getSimpleName∶获取简单类名
            3.getFields∶获取所有public修饰的属性，包含本类以及父类的
            4.getDeclaredFields∶获取本类中所有属性
            5.getMethods∶获取所有public修饰的方法，包含本类以及父类的
            6.getDeclaredMethods∶获取本类中所有方法
            7.getConstructors∶获取本类所有public修饰的构造器
            8.getDeclaredConstructors∶获取本类中所有构造器
            9.getPackage∶以Package形式返回包信息1
            0.getSuperClass∶以Class形式返回父类信息
            11.getInterfaces∶以Class【】形式返回接口信息
            12.getAnnotations∶以Annotation【】形式返回注解信息
        第二组: java.lang.reflect.Field 类
            1.getModifiers∶以int形式返回修饰符
             【说明∶默认修饰符是0，public是1，private是2，protected是4，static是8， final是16】
              public（1）+static（8）=9
            2.getType∶以Class形式返回类型
            3.getName∶返回属性名
        第三组: java.lang.reflect.Method 类
            1.getModifiers∶以int形式返回修饰符
             【说明∶默认修饰符是0，public 是1，private是2，protected是4，static是8，final是16】
            2.getReturnType∶以Class形式获取返回类型3.getName∶返回方法名
            4.getParameterTypes∶以Class【】返回参数类型数组
        第四组: java.lang.reflect.Constructor 类
            1.getModifiers∶以int形式返回修饰符
            2.getName∶返回构造器名（全类名）
            3.getParameterTypes∶以Class【】返回参数类型数组
* */

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApi {
    public static void main(String[] args) {

    }

    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException {
        //得到 Class 对象
        Class<?> personCls = Class.forName("Person");
        //getDeclaredFields:获取本类中所有属性
        //规定 说明: 默认修饰符 是 0 ， public 是 1 ，private 是 2 ，protected 是 4 , static 是 8 ，final 是 16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName()
                    + " 该属性的修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }
        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型" + declaredMethod.getReturnType());
            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }
        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("====================");
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }
    }

    //第一组方法 API
    @Test
    public void api_01() throws ClassNotFoundException, NoSuchMethodException {
        //得到 Class 对象
        Class<?> personCls = Class.forName("Person");
        //getName:获取全类名
        System.out.println(personCls.getName());//Person
        //getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());//Person
        //getFields:获取所有 public 修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {//增强 for
            System.out.println("本类以及父类的属性=" + field.getName());
        }
        //getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName());
        }
        //getMethods:获取所有 public 修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法=" + method.getName());
        }
        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName());
        }
        //getConstructors: 获取所有 public 修饰的构造器，包含本类
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器=" + constructor.getName());
        }
        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());
        }
        //getPackage:以 Package 形式返回 包信息
        System.out.println(personCls.getPackage());//Person
        //getSuperClass:以 Class 形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的 class 对象=" + superclass);//
        //getInterfaces:以 Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息=" + anInterface);
        }
        //getAnnotations:以 Annotation[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);//注解
        }
    }
}

class A {
    public String hobby;

    public void hi() {
    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {
}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    //私有的
    private Person(String name, int age) {
    }

    //方法
    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return null;
    }

    void m3() {
    }

    private void m4() {
    }
}
