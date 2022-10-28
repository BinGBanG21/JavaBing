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
			1) 一维数组的声明方式有: int[] x 或者 int x[] 
			2) 二维数组的声明方式有: int[][] y 或者 int[] y[] 或者 int y[][] 
			3) 二维数组实际上是由多个一维数组组成的，它的各个一维数组的长度可以相同，也可以不相同。
			比如： map[][] 是 一个二维数组 int map [][] = {{1,2},{3,4,5}} 
			由 map[0] 是一个含有两个元素的一维数组 
			map[1] 是一个含有三个元素的一维数组构成，我们也称为列数不等 的二维数组
	注意语法：int[] x,y[]   表示x是int类型的一维数组 y是int类型的二维数组
		以下选项允许通过编译的是（b e）
			a）x【0】=y；//错误int【】->int 
			b）y【0】=x；//正确int【】->int【】
			c）y【0】【0】=x；//错误int【】->int 
			d）x【0】【0】=y；//错误x【0】【0】是错误
			e）y【0】【0】=x【0】；//正确int->int f）x=y；//错误int【】->int【】
			c）y【0】【0】=x；//错误int【】->int
			d）x【0】【0】=y；//错误x【0】【0】是错误
			f）x=y；//错误int【】->int【】

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

		//打印杨辉三角
		/*
			1 2 1 
			1 3 3 1 
			1 4 6 4 1 
			1 5 10 10 5 1
		*/
		int[][] yhArr = new int[10][]
		for (int i = 0 ; i < yhArr.length ; i++ ) {
			int[] yhArr[i] = new int[i+1]
			for (int j = 0; i < yhArr[i].length ; j++ ) {
				if ( i = 0 || i = yhArr[i].length - 1) {
					yhArr[i][j] = 1
				} else {
					yhArr[i][j] = yhArr[i-1][j] + yhArr[i-1][j-1] 
				}
			}
		}

		//已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序
		//比如∶【10，12，45，90】，添加23后，数组为【10，12，23，45，90】
		int[] arr1 =  [ 10, 12, 45, 90 ]
		int[] arr2 = new int[arr1.length + 1]
		int num = 23
		int index = -1
		//找到index
		for (int i =0;i < arr1.length ;i++ ) {
			if (arr1[i] >= num) {
				index = i
				break
			}
		}
		if (index == -1) {
			index = arr1.length
		}
		//找到index后 给数组扩容 然后放入 分3个阶段
		//这是自己的想法 但是感觉还是双指针代码简介 是一个新思路 学到了
		//原理就是用 条件判断里j++ 当条件不满足 双指针就异步了 则满足本题需要
		// for (int i=0;i<arr2.length ; i++ ) {
		// 	if (i<index) {
		// 		arr2[i] = arr1[i]
		// 	}else if (index == i) {
		// 		arr2[i] = num
		// 	}else{
		// 		arr2[i+1] = arr1[i]
		// 	}
		// }
		// i指的是新数组  j指向原数组
		for (int i =0 ,j= 0; i < arr2.length; i++ ) {
			if (index != i) {
				arr2[i] = arr1[j]
				j++
			} else{
				arr2[i] = num
			}
		}
	}
}