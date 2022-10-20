/*
	在做非空判断时 把基本类型改成包装类型 例如：boolean 改成 Boolean 
	这样可以在出错的时候返回null  
	然后我们在调用的时候 根据返回值进行判断即可
*/


public class Practice01 {
	public static void main (String[] args){
		A01 a1 = new A01()
		double[] arr = { 1.1 ,2.4, 7.8}
		Double result  = A01.max(arr)
		if (result != null) {
			System.out.println("数组中的最大值为"+ result)
		} else {
			System.out.println("输入的数组有误")
		}
	}
}


//编写类A01，定义方法max，实现求某个double数组的最大值，并返回
class A01 {
	public Double max(double[] doubleArr){
		if (doubleArr!= null && doubleArr.length > 0) {
			for (int i = 0;i < doubleArr.length ; i++ ) {
			double ifMax = doubleArr[i]
			if (doubleArr[i] > ifMax) {
				ifMax = doubleArr[i]
				}
			}
			return ifMax
		} else {
			return null 
		}
	}
}


//编写类A02，定义方法find，实现查找某字符串是否在字符串数组中，并返回索引如果找不到，返回-1
class A02 {
	public int find(String[] strArr, String targerStr){
		for (int i = 0; i < strArr.length; i++ ) {
			if (strArr[i].equals(targerStr)) {
				return i
			}
		}
		return -1 
	}
}


//编写类Book，定义方法updatePrice，实现更改某本书的价格，具体∶如果价格>150，则更改为150，如果价格>100，更改为100，否则不变
 class Book {
 	String name 
 	int price 
 	public Book(String name , int price){
 		this.name = name 
 		this.price = price
 	}
 	public void updatePrice(String name , int price){
 		if (this.price > 150) {
 			this.price = 150
 		} else if (this.price > 100 ) {
 			this.price = 100
 		} 
 	}
 }


//编写类A03，实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
 class A04 {
 	public double[] copyArr(double[] arr){
 		double[] newArr = new double[arr.length]
 		for (int i = 0; i < arr.length ; i++ ) {
 			newArr[i] = arr[i]
 		}
 		return newArr
 	}
 }


 //定义一个圆类Circle，定义属性∶半径，提供显示圆周长功能的方法，提供显示圆面积的方法
 class Circle{
 	double radius;
 	public Circle (double radius){
 		this.radius = radius
 	}
 	public double perimeter (double radius){
 		return 2 * this.radius * Math.PI
 	} 
 	public double area (double radius){
 		return this.radius * this.radius * Math.PI
 	} 
 }

 //在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的定义形式，调用语句为∶System.out.println（method（method（method（10.0 , 20.0），100）））
 //主要注意的是 method可以连续调用 int 100 又能自动转化为double 所以得出该函数的返回值为double类型
 class M {
 	public double method(double d1 , double d2) {
 	}
 }


//创建一个Employee类， 属性有（名字， 性别， 年龄， 职位， 薪水）， 提供3个构造方法，可以初始化
//（1）（名字，性别，年龄，职位，薪水），（2）（名字，性别，年龄）（3）（职位，薪水），要求充分复用构造器
class Employee {
	String name 
	char gender
	int age
	String job
	double sal
	//因为要求充分复用构造器 所以要先从属性少的写起
	public Employee( String job , double sal ){
		this.job = job
		this.sal = sal
	}
	public Employee(String name , char gender ,int age  ){
		this.name = name 
		this.gender = gender
		this.age = age
	}
	public Employee (String job , double sal, String name , int age , double sal){
		this(name, gender,age )
		this.job =job
		this.sal = sal 
	}
}