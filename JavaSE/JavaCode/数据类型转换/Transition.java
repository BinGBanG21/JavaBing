/*
	当java程序在进行赋值或者运算时，精度（容量）小的类型自动转换为精度大的数据类型 这个就是自动类型转换。
	char--int--long--float--double
	byte--short--int--long--float--double
	顺序不重要 重要的是精度小转大
	
	例如：int a = 'c' // 可以
	转换规则：
		1. 有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算
		2. 当我们把精度(容量)大的数据类型赋值给精度(容量)小的数据类型时,就会报错，反之就会进行自动类型转换
		3.（byte，short）和char之间不会相互自动转换
		4. byte，short，char 他们三者可以计算 在计算时首先转换为int类型
		5. boolean不参与转换
		6. 自动提升原则∶ 表达式结果的类型自动提升为操作数中最大的类型
*/
public class Transition {
	public static void main(){
		int a1 = 10 
		float a2 = a1 + 1.1 //编译报错 因为会自动转换成精度最大的类型（不是参与运算的两者最大 而是数据类型中最大的）
		double a3 = a1 + 1.1  // (1) 修改左侧类型为double类型
		float a4 = a1 + 1.1F // 更改浮点数的默认类型为float  消除数据类型转换
		int a5 = 1.1 // 报错  double类型不能赋值给int类型
		//细节：(byte, short) 和 char 之间不会相互自动转换
		//当把具体数赋给 byte 时
			//(1)先判断该数是否在 byte 范围内，如果是就可以 
		byte b1 = 10; //对 , -128-127 
		int n2 = 1; //n2 是 int 
		byte b2 = n2; //错误，原因： 如果是变量赋值，判断类型 
		char c1 = b1; //错误， 原因 byte 不能自动转成 char
	}
}