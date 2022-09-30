/*数据类型
	每一种数据都定义了明确的数据类型，在内存中分配了不同大小的内存空间（字节）
	1.基本数据类型 
		数值型
			整数类型：[byte(1) , short(2) , int(4) , long(8) ]
			浮点数类型： [float(4) ,double(8)]
		字符型
			char[2] 存放单字符 "a" "王"
		布尔型
			boolean[1] 存放true false
		注意：String是类 不是数据类型
	2.引用数据类型
		类
		接口
		数组
	

	整数类型
	Java 的整数类型就是用于存放整数值的，比如 12 , 30, 3456 等等
	byte n1 = 10; short n2 = 10;
	int n3 = 10;//4 个字节 long n4 = 10; //8 个字节

	类 型   				占用存储空间   			范围
	byte【字节】 			1字节         			 -128～127
	short【短整型】  		2字节					-32768~32767
	int 【整型】			4字节					-2147483648-2147483647
	long【长整型】			8字节					-2的63方～263-1
	
		
	1. Java各整数类型有固定的范围和字段长度，不受具体OS【操作系统】的影响，以保证java程序的可移植性。
	2. Java的整型常量（具体值）默认为int 型， 声明long型常量须后加 "T 或 'L 
	3.java程序中变量常声明为int型，除非不足以表示大数，才使用long 
	4. bit∶计算机中的最小存储单位。byte∶计算机中基本存储单元，1byte=8bit。

	byte n1 = 3    在内存中存在的形式  00000011 
	short n2 = 3   在内存中存在的形式	  0000000000000011

	浮点类型 
	Java 的浮点类型可以表示一个小数，比如 123.4 ，7.8 ，0.12 等等
	
	类 型   				占用存储空间   			范围
	单精度float 			4字节        			-3.403E38～3.403E38
	双精度double 		8字节					-1.798E308～1.798E308

	(1)关于浮点数在机器中存放形式的简单说明，浮点数=符号位+指数位+尾数位
	(2)尾数部分可能丢失，造成精度损失（小数都是近似值）

	1. 与整数类型类似，Java浮点类型也有固定的范围和字段长度，不受具体OS的
	影响。【float 4个字节 double是8个字节】
	2.Java的浮点型常量（具体值）默认为double型，声明float型常量，须后加'f'或'F'
	3.浮点型常量有两种表示形式
	十进制数形式∶如∶ 5.12   512.0f   .512 （必须有小数点）
	科学计数法形式∶如∶ 5.12e2【5.12*10的2次方】 5.12E-2 【5.12/10的2次方】
	4. 通常情况下， 应该使用double型， 因为它比float型更精确
	5.浮点数使用陷阱2.7和8.1/3比较
	if(Math.abs(num7-num8)<0.00001)[
	System.out.println（"相等~~")

	API查询方法
	按照 包->类->方法
	直接索引 ：显示->索引->Math

	字符类型(char)
	注意！！！！！！！：
	字符类型要用''  ""是字符串不是字符
	字符类型可以表示单个字符,字符类型是 char，char 是两个字节(可以存放汉字)，多个字符我们用字符串 String
	1.字符常量是用单引号（'）括起来的单个字符。例如∶charc1='a'；charc2='中'；charc3='9'；Java中还允许使用转义字符 V来将其后的字符转变为
	2.特殊字符型常量。例如charc3=*\n’//’\n’表示换行符
	3.在java中，char的本质是一个整数，在输出时，是unicode码对应的字符。
	4.http://tool.chinaz.com/Tools/Unicode.aspx 可以直接给char赋一个整数，然后输出时，会按照对应的unicode字符输出【97->a】
	5. char类型是可以进行运算的，相当于一个整数， 因为它都对应有Unicode码.


*/
public class DataType {
	public static void main (String[] args){
		int a = 1
		int b = 1L //报错  long类型不能赋值给int类型 （不兼容的类型）
		long c = 1L 
		float num1 = 1.1; //错误 
		float num2 = 1.1F; //对的 
		double num3 = 1.1; //对 
		double num4 = 1.1f; //对

		//浮点数使用陷阱: 2.7 和 8.1 / 3 比较
		double num11 = 2.7
		double num12 = 8.1 / 3 //接近2.7的一个小数 
		//得到一个重要的使用点: 当我们对运算结果是小数的进行相等判断是，要小心 
		//拿到结果不要直接比较 要abs差值去比较
		//应该是以两个数的差值的绝对值，在某个精度范围类判断 
		//赋值或者查询到的小数可以直接比较  运算得到的不可以
		if ( num11 == num12) { 
			System.out.println("num11 == num12 相等"); 
		}
		//正确的写法
		if ( Math.abs(num11 - num12) < 0.000001 ) { 
			System.out.println("差值非常小，到我的规定精度，认为相等...");

		//在 java 中，char 的本质是一个整数，在默认输出时，是 unicode 码对应的字符 
		//要输出对应的数字，可以(int)字符 
		char c1 = 97; 
		System.out.println(c1); // a

		char c2 = 'a'; //输出'a' 对应的 数字 
		System.out.println((int)c2)

		char c3 = '王';
		System.out.println((int)c3);//29579 
		char c4 = 29579; System.out.println(c4);//王

		//char 类型是可以进行运算的，相当于一个整数，因为它都对应有 Unicode 码. 
		System.out.println('a' + 10);//107
}