/*
	类和对象的区别和联系
		1) 类是抽象的，概念的，代表一类事物,比如人类,猫类.., 即它是数据类型. 
		2) 对象是具体的，实际的，代表一个具体事物, 即 是实例. 
		3) 类是对象的模板，对象是类的一个个体，对应一个实例
		属性/成员变量/字段
			1) 从概念或叫法上看： 成员变量 = 属性 = field(字段) （即 成员变量是用来表示属性的,统一叫 属性)
			2) 属性是类的一个组成部分，一般是基本数据类型,也可是引用类型(对象，数组)。比如我们前面定义猫类 的 int age 就 是属性
			注意事项和细节
				1) 属性的定义语法同变量，示例：访问修饰符 属性类型 属性名;
					访问修饰符： 控制属性的访问范围 有四种访问修饰符 public, protected, 默认, private 
					2) 属性的定义类型可以为任意类型，包含基本类型或引用类型 
					3) 属性如果不赋值，有默认值，规则和数组一致。
						具体说: int 0，short 0, byte 0, long 0, float 0.0,double 0.0，char \u0000， boolean false，String null
	如何创建对象
		1) 先声明再创建 
			Cat cat ; //声明对象 
			cat cat = new Cat(); //创建 
		2) 直接创建 
			Cat cat = new Cat();
	如何访问属性
		对象名.属性名
	Java 内存的结构分析 
	1) 栈： 一般存放基本数据类型(局部变量) 
	2) 堆： 存放对象(Cat cat , 数组等) 
	3) 方法区：常量池(常量，比如字符串)， 类加载信息
		Java 创建对象的流程简单分析
		Person p = new Person(); 
		p.name = “jack”; 
		p.age = 10
		1) 先加载 Person 类信息(属性和方法信息, 只会加载一次) 
		2) 在堆中分配空间, 进行默认初始化(看规则) 
		3) 把地址赋给 p , p 就指向对象
		4) 进行指定初始化， 比如 p.name =”jack” p.age = 10
	方法调用小结
		1.当程序执行到方法时，就会开辟一个独立的main栈空间（栈空间）
		2.当方法执行完毕，或者执行到return语句时，就会返回，
		3.返回到调用方法的地方out（"值="+res..）
		4.返回后，继续执行方法后面的代码5.当main方法（栈）执行完毕，整个程序退出
	成员方法的定义
		访问修饰符 返回数据类型 方法名（形参列表..） {//方法体
		 方法语句； 
		 return 返回值; 
		 }
			1) 形参列表：表示成员方法输入 cal(int n) ， getSum(int num1, int num2)
			2) 返回数据类型：表示成员方法输出, void 表示没有返回值 
			3) 方法主体：表示为了实现某一功能代码块 
			4) return 语句不是必须的。
		注意事项
			访问修饰符 (作用是控制 方法使用的范围) 如果不写默认访问，[有四种: public, protected, 默认, private]
			返回数据类型 
				1) 一个方法最多有一个返回值 [思考，如何返回多个结果 返回数组 ] 
				2) 返回类型可以为任意类型，包含基本类型或引用类型(数组，对象) 
				3) 如果方法要求有返回数据类型，则方法体中最后的执行语句必须为 return 值; 而且要求返回值类型必须和 return 的 值类型一致或兼容 
				4) 如果方法是 void，则方法体中可以没有 return 语句，或者 只写 return ;  方法名 遵循驼峰命名法，最好见名知义，表达出该功能的意思即可
		关于参数列表
			1.一个方法可以有0个参数，也可以有多个参数，中间用逗号隔开，比如 getSum（int n1，int n2）·
			2.参数类型可以为任意类型，包含基本类型或引用类型，比如printArr（int【】【】map）调用带参数的方法时，一定对应着参数列表传入相同类型或兼容类型的参数
			3.方法定义时的参数称为形式参数，简称形参；方法调用时的传入参数称为实际参数，简称实参
			4.实参和形参的类型要一致或兼容、个数、顺序必须一致
*/
public class Object  {
	public static void main (String[] args){
		Person p = new Person()
		p.name = "wangbing"
		p.age = 22
		MyTools p1 = new MyTools()
		Person p2 = p1.copyPerson(p)
	}
}
//编写一个方法 copyPerson，可以复制一个 Person 对象，返回复制的对象。克隆对象
//注意要求得到新对象和原来的 对象是两个独立的对象，只是他们的属性相同
class Person {
	String name
	int age
}
class MyTools {
	public Person copyPerson(Person p){
		Person p1 = new Person()
		p1.name = p.name
		p1.age = p.age
		return p1
	}
}