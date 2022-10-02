/**
	运算符是一种特殊的符号 用以表示数据的运算 赋值和比较等。
	1) 算术运算符 
	2) 赋值运算符 
	3) 关系运算符 [比较运算符] 
		关系运算符(比较运算符) 
		1) 关系运算符的结果都是 boolean 型，也就是要么是 true，要么是 false 
		2) 关系表达式 经常用在 if 结构的条件中或循环结构的条件中
	4) 逻辑运算符 
		1) 短路与 && ， 短路或 ||，取反 ! 
		2) 逻辑与 &，逻辑或 |，^ 逻辑异或
		注：对于&&短路与而言，如果第一个条件为 false ,后面的条件不再判断 
			对于&逻辑与而言，如果第一个条件为 false ,后面的条件仍然会判断
	5) 位运算符 [需要二进制基础] 
	6) 三元运算符


*/


public class Operation{
	public static void main (String[] args){

		System.out.println(10 / 4); //从数学来看是 2.5, java 中 2 因为两个都是int类型
		System.out.println(10.0 / 4); //java 是 2.5 因为10.0是double类型的  
		double d = 10 / 4;//java 中 10 / 4 = 2, 2=>2.0 
		System.out.println(d);// 是 2.0
		// % 取模 ,取余 // 在 % 的本质 看一个公式!!!! a % b = a - a / b * b 
		// -10 % 3 => -10 - (-10) / 3 * 3 = -10 + 9 = -1 
		// 10 % -3 = 10 - 10 / (-3) * (-3) = 10 - 9 = 1 
		// -10 % -3 = (-10) - (-10) / (-3) * (-3) = -10 + 9 = -1
		System.out.println(10 % 3); // 1
		System.out.println(-10 % 3); // -1
		System.out.println(10 % -3);  // 1
		System.out.println(-10 % -3); // -1
		//++的使用 
		int i = 10; // 独立使用 没有任何区别
		 i++; //自增 等价于 i = i + 1; => i = 11 
		 ++i;//自增 等价于 i = i + 1; => i = 12 
		System.out.println("i=" + i);//12
		//作为表达式使用 前++：++i 先自增后赋值 后++：i++先赋值后自增
		int j = 8; 
		//int k = ++j; //等价 j=j+1;k=j; 
		int k = j++; // 等价 k =j;j=j+1; 
		System.out.println("k=" + k + "j=" + j);//8 9

		// int i = 1; //i->1 
		// i = i++; //规则使用临时变量: (1) temp=i;(2) i=i+1;(3)i=temp; // System.out.println(i); 1

		// int i=1; // i=++i; //规则使用临时变量: (1) i=i+1;(2) temp=i;(3)i=temp; // System.out.println(i); 2

		//定义一个变量保存华氏温度，华氏温度转换摄氏温度的公式为 
		//：5/9*(华氏温度-100),请求出华氏温度对应的摄氏温度 //
		//思路分析 //(1) 先定义一个 double huaShi 变量保存 华氏温度 
		//(2) 根据给出的公式，进行计算即可 5/9*(华氏温度-100) 
			// 考虑数学公式和 java 语言的特性 
		//(3) 将得到的结果保存到 double sheShi  
		double huaShi = 1234.6; 
		double sheShi = 5.0 / 9 * (huaShi - 100); // 5 / 9 = 0
		System.out.println("华氏温度" + huaShi + " 对应的摄氏温度=" + sheShi);
	}
}