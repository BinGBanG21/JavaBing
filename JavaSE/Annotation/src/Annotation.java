/*
    注解(Annotation) 作用是帮助编译 检查代码
        1) 注解(Annotation)也被称为元数据(Metadata)，用于修饰解释 包、类、方法、属性、构造器、局部变量等数据信息。
        2) 和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息。
        3) 在 JavaSE 中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在 JavaEE 中注解占据了更重要的角
        色，例如用来配置应用程序的任何切面，代替 java EE 旧版中所遗留的繁冗代码和 XML 配置等。
    基本的 Annotation 介绍
        使用 Annotation 时要在其前面增加 @ 符号, 并把该 Annotation 当成一个修饰符使用。用于修饰它支持的程序元素
        三个基本的 Annotation:
            1) @Override: 限定某个方法，是重写父类方法, 该注解只能用于方法
            2) @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
            3) @SuppressWarnings: 抑制编译器警告
    >Override使用说明
        1.@Override表示指定重写父类的方法（从编译层面验证），如果父类没有fly方法，则会报错
        2.如果不写@Override注解，而父类仍有public void fly（）{}，仍然构成重写3.@Override只能修饰方法，不能修饰其它类，包，属性等等
        4.查看@Override注解源码为@Target（ElementType.METHOD），说明只能修饰方法
        5.@Target是修饰注解的注解，称为元注解
    >Deprecated的说明
        1.用于表示某个程序元素（类，方法等）已过时2.可以修饰方法，类，字段，包，参数等等
        3.@Target(value={CONSTRUCTOR,FIELD,LOCAL VARIABLE,METHOD.PACKAGE,PARAMETER,TYPE})
        4.@Deprecated的作用可以做到新旧版本的兼容和过渡
    >SuppressWarnings: 抑制编译器警告
        1. 当我们不希望看到这些警告的时候，可以使用 SuppressWarnings 注解来抑制警告信息
        2. 在{""} 中，可以写入你希望抑制(不显示)警告信息
        3. 可以指定的警告类型有
            all，抑制所有警告
            boxing，抑制与封装/拆装作业相关的警告
            cast，抑制与强制转型作业相关的警告
            dep-ann，抑制与淘汰注释相关的警告
            deprecation，抑制与淘汰的相关警告
            fallthrough，抑制与 switch 陈述式中遗漏 break 相关的警告
            finally，抑制与未传回 finally 区块相关的警告
            hiding，抑制与隐藏变数的区域变数相关的警告
            incomplete-switch，抑制与 switch 陈述式(enum case)中遗漏项目相关的警告
            javadoc，抑制与 javadoc 相关的警告
            nls，抑制与非 nls 字串文字相关的警告
            null，抑制与空值分析相关的警告
            raw types，抑制与使用 raw 类型相关的警告
            resource，抑制与使用 Closeable 类型的资源相关的警告
            restriction，抑制与使用不建议或禁止参照相关的警告
            serial，抑制与可序列化的类别遗漏 serialVersionUID 栏位相关的警告
            static-access，抑制与静态存取不正确相关的警告
            static-method，抑制与可能宣告为 static 的方法相关的警告
            super，抑制与置换方法相关但不含 super 呼叫的警告
            synthetic-access，抑制与内部类别的存取未最佳化相关的警告
            sync-override，抑制因为置换同步方法而遗漏同步化的警告
            unchecked，抑制与未检查的作业相关的警告
            unqualified-field-access，抑制与栏位存取不合格相关的警告
            unused，抑制与未用的程式码及停用的程式码相关的警告
         4. 关于 SuppressWarnings 作用范围是和你放置的位置相关
            比如 @SuppressWarnings 放置在 main 方法，那么抑制警告的范围就是 main
            通常我们可以放置具体的语句, 方法, 类.
         5. 看看 @SuppressWarnings 源码
            (1) 放置的位置就是 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
            (2) 该注解类有数组 String[] values() 设置一个数组比如 {"raw types", "unchecked", "unused"}
      >JDK的元注解
        JDK 的元 Annotation 用于修饰其他 Annotation
            1) Retention //指定注解的作用范围，三种 SOURCE,CLASS,RUNTIME
                只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 可以保留多长时间, @Retention 包含一个 RetentionPolicy
                类型的成员变量, 使用 @Retention 时必须为该 value 成员变量指定值:
                @Retention 的三种值
                    1) RetentionPolicy.SOURCE: 编译器使用后，直接丢弃这种策略的注释
                    2) RetentionPolicy.CLASS: 编译器将把注解记录在 class 文件中.
                          当运行 Java 程序时, JVM 不会保留注解。 这是默认值
                    3) RetentionPolicy.RUNTIME:编译器将把注解记录在 class 文件中.
                          当运行 Java 程序时, JVM 会保留注解. 程序可以通过反射获取该注解
            2) Target // 指定注解可以在哪些地方使用
            3) Documented //指定该注解是否会在 javadoc 体现
            4) Inherited //子类会继承父类注解
* */
public class Annotation {
    public static void main(String[] args) {

    }
}
