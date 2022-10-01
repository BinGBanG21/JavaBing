/*
	类型转换练习

	基本数据类型和 String 类型的转换
		基本类型转String类型语法将基本类型的值+""即可
		String类型转基本数据类型语法∶通过基本类型的包装类调用parseXX方法即可
			Tnteger.parseInt("123")
			Double.parseDouble("123.1")
			Float.parseFloat("123.45")
			Short.parseShort("12")
			Long·parseLong("12345")
			Boolean.parseBoolean("true")
			Byte.parseByte("12");
			怎么把字符串转成字符 char -> 把字符串的第一个字符得到 调用charAt(0) 得到 s5 字符串的第一个字符 '1' 
			

*/

public class Parctice02 {
	public static void main(String[] args){
		short s = 12
		s = s - 9  //报错  因为s是short类型 参与运算后变成int类型 int类型不能赋值给short类型
		byte b = 10 
		b = b + 1 //报错  int 不能赋值给 byte类型
		b = (byte)(b+11)  //可以 强制转换为byte后赋值
		char c = 'a'
		int i = 16
		float d = .314F
		double result = c + i + d //正确 float自动转换 double
		byte b = 16
		short s =14
		short t =s + b // int 不能赋值给short
		
}