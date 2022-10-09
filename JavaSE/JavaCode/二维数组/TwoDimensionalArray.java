/*
	二维数组的使用
	请用二维数组输出如下图形 
	0 0 0 0 0 0
	0 0 1 0 0 0 
	0 2 0 3 0 0 
	0 0 0 0 0 0		
	二维数组的语法
		1) 语法: 类型[][] 数组名=new 类型[大小][大小] 
		2) 比如: int a[][]=new int[2][3]

*/




public class TwoDimensionalArray {
	public static void main (String[] args) {
		//什么是二维数组
		//1. 从定义形式上看 int[][] 
		//2. 可以这样理解，原来的一维数组的每个元素是一维数组, 就构成二维数组 
		int[][] arr = { {0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, 
								{0,2, 0, 3, 0, 0}, {0, 0, 0, 0, 0, 0} };

		//输出二维数组
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j =0 ; j < arr[i].length ; j++ ) {
				System.out.print(arr[i][j]+"\t")
			}
			System.out.println("")
		}
		// 动态给二维数组开空间
		// i = 0: 1 
		// i = 1: 2 2 
		// i = 2: 3 3 3
		for(int i = 0; i < arr.length; i++) {
			int[][] arr = new int[3][];
			//遍历 arr 每个一维数组 
			//给每个一维数组开空间 new 
			//如果没有给一维数组 new ,那么 arr[i]就是 null 
			arr[i] = new int[i + 1]; 
			//遍历一维数组，并给一维数组的每个元素赋值 
			for(int j = 0; j < arr[i].length; j++) { 
				arr[i][j] = i + 1;//赋值
			}
		}
	}
}