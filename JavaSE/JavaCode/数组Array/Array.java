/*
	数组介绍 
		数组可以存放多个同一类型的数据。
		数组也是一种数据类型，是引用类型。 即：数(数据)组(一组)就是一组数据

	数组的定义
	数据类型[] 数组名=new 数据类型[大小]
	int[] a = new int[5]  // 创建了一个数组 名字a  存放5个int
	数组的引用（使用/访问/获取数组元素）数组名[下标/索引/index] 下标从0开始
	数组的使用注意事项
		1) 数组是多个相同类型数据的组合，实现对这些数据的统一管理 
		2) 数组中的元素可以是任何数据类型，包括基本类型和引用类型，但是不能混用。 
		3) 数组创建后，如果没有赋值，有默认值 int 0，short 0, byte 0, long 0, float 0.0,double 0.0，char \u0000，boolean false，String null 
		4) 使用数组的步骤 
			1. 声明数组并开辟空间 
			2 给数组各个元素赋值 
			3 使用数组 
		5) 数组的下标是从 0 开始的。 
		6) 数组下标必须在指定范围内使用，否则报：下标越界异常

*/

public class Array {
	public static void main (String[] args) {
		//创建A-Z的数组 并打印
		char[] letterArr = new char[26]
		for (int i = 0 ; i < letterArr.length ; i++) {
			letterArr[i] = (char)('A' + i)
		}
	}
}