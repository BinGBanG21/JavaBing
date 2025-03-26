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
	数组赋值机制
		1) 基本数据类型赋值，这个值就是具体的数据，而且相互不影响。
		2) 数组在默认情况下是引用传递，赋的值是地址。
*/
import java.util.Scanner
public class Array {
	public static void main (String[] args) {
		//创建A-Z的数组 并打印
		char[] letterArr = new char[26]
		for (int i = 0 ; i < letterArr.length ; i++) {
			letterArr[i] = (char)('A' + i)
		}
		//请求出一个数组 int[]的最大值 {4,-1,9, 10,23}，并得到对应的下标
		double max = 0
		int[] arr = { 4,-1,9,10,23 }
		int maxIndex = 0
		for (int i = 0; i < arr.length; i++ ) {
			 if (arr[i] > max) {
			 	max = arr[i]
			 	maxIndex = i
			 }
		}
		//数组拷贝
		int[] arr1 = { 1,2,3,4,5 }
		int[] arr2 = new int[arr1.length]
		for (int i =0 ; i<arr1.length ; i++ ) {
			arr2[i] = arr1[i]
		}
		//数组反转
		int[] arr3 =new int[arr1.length]
		int index = arr1.length - 1
		for ( int i = 0; i<arr1.length ; i++ ) {
			arr3[index] = arr[i]
			index -- 
		}
		//如果反转不返回新数组
		// int[] arr2 = new int[arr.length];
		// for(int i = arr.length - 1, j = 0; i >= 0; i--, j++) { arr2[j] = arr[i]; }
		int temp = 0 
		int len = arr1.length / 2 
		for (int i = 0 ; i < len; i++ ) {
			double temp = 0
			temp = arr1[i]
			arr1[i] = arr[len-i]
			arr1[len-i] = temp
		}
		//动态给数组添加元素
		//思路分析 
			//1. 定义初始数组 int[] arr = {1,2,3}//下标 0-2 
			// 2. 定义一个新的数组 int[] arrNew = new int[arr.length+1]; 
			// 3. 遍历 arr 数组，依次将 arr 的元素拷贝到 arrNew 数组 
			// 4. 将 4 赋给 arrNew[arrNew.length - 1] = 4;把 4 赋给 arrNew 最后一个元素 
			// 5. 让 arr 指向 arrNew ; arr = arrNew; 那么 原来 arr 数组就被销毁 
			// 6. 创建一个 Scanner 可以接受用户输入 
			// 7. 因为用户什么时候退出，不确定，使用 do-while + break 来控制
		Scanner myScanner = new Scanner(System.in)
		int[] array1 = {1,2,3,}
		do{
			int[] newArr = int [newArr.length+1]
			for ( int i = 0 ; i < array1.length; i++ ) {
				newArr[i] = array1[i]
			}
			System.out.println("请输入你要添加的元素")
			int addNum = myScanner.nextInt()
 			newArr[newArr.length -1] = addNum
			array1 = newArr
			System.out.println("是否继续添加? y/n")
			boolean isOver = myScanner.next().charAt(0) == 'y' ? true : false
		}while( isOver )
}