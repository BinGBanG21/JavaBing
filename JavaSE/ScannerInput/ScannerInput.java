import java.util.Scanner;

public class ScannerInput{
	public static void main(String[] args){
		////Scanner 类 表示 简单文本扫描器，在 java.util 包 
		//1. 引入/导入 Scanner 类所在的包 
		//2. 创建 Scanner 对象 , new 创建一个对象,体会 
		// myScanner 就是 Scanner 类的对象 Scanner myScanner = new Scanner(System.in); 
		//3. 接收用户输入了， 使用 相关的方法 System.out.println("请输入名字");
		Scanner myScanner = new Scanner(System.in)
		System.out.println("请输入姓名")
		String name  = myScanner.next()
		System.out.println("请输入年龄")
		Int age  = myScanner.nextInt()
		System.out.println("请输入薪水")
		Double sal  = myScanner.nextDouble()
	}
}