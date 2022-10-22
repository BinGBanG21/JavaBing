/*
命名规则
    只能包含数字、字母、下划线、小圆点、但不能用数字开头，不能是关键字或保留字
    * demo.class.exec1   //错误class是关键字
    * demo.12a           //错误12a是数字开头
    * demo.ab12.oa       //对
命名规范
    一般是小写字母+小圆点一般是com.公司名.项目名.业务模块名
    比如∶ com.WangBing.oa.model； com.WangBing.oa.controller；举例
    com.sina.crm.user//用户模块com.sina.crm.order//订单模块com.sina.crm.utils//工具类
常用的包
    一个包下,包含很多的类,java 中常用的包有:
    1) java.lang.* //lang 包是基本包，默认引入，不需要再引入. 2) java.util.* //util 包，系统提供的工具包, 工具类，使用 Scanner
    3) java.net.* //网络包，网络开发
    4) java.awt.* //是做 java 的界面开发，GUI
导入规则
    我们需要使用到哪个类，就导入哪个类即可，不建议使用 *导入
    import java.util.Scanner; //表示只会引入 java.util 包下的 Scanner
    import java.util.*;//表示将 java.util 包下的所有类都引入(导入)
注意事项和使用细节
    1. package的作用是声明当前类所在的包， 需要放在类的最上面， 一个类中最多只有一句package
    2. import指令 位置放在package的下面，在类定义前面，可以有多句且没有顺序要求。
* */
