/*
	程序流程控制
		在程序中，程序运行的流程控制决定程序是如何执行的，是我们必须掌握的
		主要有三大流程控制语句。 
		1) 顺序控制
			程序从上到下逐行地执行，中间没有任何判断和跳转
			java中定义变量时采用合法的前向引用原则
		2) 分支控制
			让程序有选择的的执行,分支控制有三种 
			1) 单分支 if 
			2) 双分支 if-else 
			3) 多分支 if-else if -....-else
			switch case分支 
			switch（表达式）中表达式的返回值必须是∶（byte，short，int，char，enum【枚举】，String
			1.switch关键字，表示swtich分支
			2.表达式对应一个值
			3.case常量1∶当表达式的值等于常量1，就执行语句块1
			4.break∶表示退出swtich
			5.如果和case常量1匹配，就执行语句块1，如果没有匹配，就继续匹配case常量2
			6.如果一个都没有匹配上，执行default
			注意：
				1.表达式数据类型，应和case后的常量类型一致，或者是可以自动转成可以相互比较的
				2.switch（表达式）中表达式的返回值必须是∶（byte，short，int，char，enum【枚举】，String）
				3.case子句中的值必须是常量，而不能是变量
				4.default子句是可选的，当没有匹配的case时，执行default
				5.eak语句用来在执行完一个case分支后使程序跳出switch语句块；如果没有写break，程序会顺序执行到switch结尾，除非遇到break（穿透现象 多个case执行同一逻辑  或者一个case执行多个逻辑）
			switch 和 if 的比较
			1) 如果判断的具体数值不多，而且符合 byte、 short 、int、 char, enum[枚举], String 这 6 种类型。虽然两个语句都可 以使用，建议使用 swtich 语句
			2) 其他情况：对区间判断，对结果为 boolean 类型判断，使用 if，if 的使用范围更广
		3) 循环控制
			for循环
				1. for 关键字，表示循环控制 
				2. for 有四要素: (1)循环变量初始化(2)循环条件(3)循环操作(4)循环变量迭代 
				3. 循环操作 , 这里可以有多条语句，也就是我们要循环执行的代码 
				4. 如果 循环操作(语句) 只有一条语句，可以省略 {}, 建议不要省略
				注意事项和细节
					1) 循环条件是返回一个布尔值的表达式 
					2) for(;循环判断条件;) 中的初始化和变量迭代可以写到其它地方，但是两边的分号不能省略。
					3) 循环初始值可以有多条初始化语句，但要求类型一样，并且中间用逗号隔开，循环变量迭代也可以有多条变量迭代 语句，中间用逗号隔开
			while循环
				1) 循环条件是返回一个布尔值的表达式 
				2) while 循环是先判断再执行语句
			do while循环
				1. do while 是关键字 也有循环四要素, 只是位置不一样 
				2. 先执行，再判断，也就是说，一定会至少执行一次 
				3. 最后 有一个 分号 
				4. while 和 do..while 区别举例:
					while 一直做某事 直到xxxx
					do while 先做一次某事 然后判断是否继续做
				注意事项
					1) 循环条件是返回一个布尔值的表达式 
					2) do..while 循环是先执行，再判断， 因此它至少执行一次
			多重循环控制
				1) 将一个循环放在另一个循环体内，就形成了嵌套循环。其中，for ,while ,do…while 均可以作为外层循环和内层循环。 【建议一般使用两层，最多不要超过 3 层, 否则，代码的可读性很差】 
				2) 实质上，嵌套循环就是把内层循环当成外层循环的循环体。当只有内层循环的循环条件为 false 时，才会完全跳出内 层循环，才可结束外层的当次循环，开始下一次的循环[听不懂，走案例]。 
				3) 设外层循环次数为 m 次，内层为 n 次，则内层循环体实际上需要执行 m*n 次。
			break语句
				break 语句用于终止某个语句块的执行，一般使用在 switch 或者循环[for , while , do-while]中
				注意
					（1）break语句可以指定退出哪层输出什么并分析原因
					（2）label1是标签，名字由自己指定
					（3）break后指定到哪个label就退出到哪里
					（4）在实际的开发中，尽量不要使用标签
					（5）如果没有指定break，默认退出最近的循环体

			countinue
				1) continue 语句用于结束本次循环，继续执行下一次循环。 
				2) continue 语句出现在多层嵌套的循环语句体中时，可以通过标签指明要跳过的是哪一层循环 , 这个和前面的标签的 使用的规则一样.

			break:推出本个循环 可以指定label 不指定默认推出最近的循环 continue:结束本次循环  进入下一次循环

			跳转控制语句-return
				return 使用在方法，表示跳出所在的方法
				上面的都是跳出跳过循环 return直接跳出方法
*/


public class LoopControl {
	public static void main(String[] args){
		int total = 0
		int count = 0
		for( i = 1;i <= 100; i++){
			if (i % 9 == 0) {
				conut ++
				total += i
			}
		}
		System.out.println("个数为"+i",和为"+total)

		//统计 3 个班成绩情况，每个班有 5 名同学， 
		//求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。 
		//统计三个班及格人数，每个班有 5 名同学。
		Scanner myScanner = new Scanner(System.in); 
		double totalScore = 0; 
		//累积所有学生的成绩 
		int passNum = 0;
		//累积 及格人数 
		int classNum = 3; 
		//班级个数 
		int stuNum = 5;
		//学生个数 
		for( int i = 1; i <= classNum; i++) {//i 表示班级 
		double sum = 0; 
		//一个班级的总分 
		for( int j = 1; j <= stuNum; j++) {//j 表示学生 
			System.out.println("请数第"+i+"个班的第"+j+"个学生的成绩"); 
			double score = myScanner.nextDouble();
			//当有一个学生成绩>=60, passNum++ 
			if(score >= 60) {
			 	passNum++; 
			 }
			 	sum += score; 
			 	//累积 
				 System.out.println("成绩为" + score); 
			 }
			 	//因为 sum 是 5 个学生的总成绩 
				 System.out.println("sum=" + sum + " 平均分=" + (sum / stuNum)); 
			 	//把 sum 累积到 totalScore 
				 totalScore += sum;
			 }
				 System.out.println("三个班总分="+ totalScore + " 平均分=" + totalScore / (classNum*stuNum));
				 System.out.println("及格人数=" + passNum); 
			}
		
		//九九乘法表 
			for(int i=0;i<=9;i++){
    			 for (int j=1;j<=i;j++){
       				 System.out.print(i+"*"+j+"="+i*j+" ");
     		 }
 				System.out.println();
			}
		//打印空心金字塔
			/*     * 
				 *   * 
				*      * 
			   **********
			*/

			int totalLevel = 20; //层数 
			for(int i = 1; i <= totalLevel; i++) { //i 表示层数 //在输出*之前，还有输出 对应空格 = 总层数-当前层 
				for(int k = 1; k <= totalLevel - i; k++ ) { 
					System.out.print(" "); 
			}
			//控制打印每层的*个数
			for(int j = 1;j <= 2 * i - 1;j++) { //当前行的第一个位置是*,最后一个位置也是*, 最后一层全部 * 
				if(j == 1 || j == 2 * i - 1 || i == totalLevel) { 
					System.out.print("*"); 
				} else { //其他情况输出空格 
						System.out.print(" "); } 
				}
				//每打印完一层的*后，就换行 println 本身会换行 
				System.out.println(""); 
		} 

}