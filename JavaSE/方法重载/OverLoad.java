/*
	方法重载(OverLoad)
		java 中允许同一个类中，多个同名方法的存在，但要求 形参列表不一致！
		比如：System.out.println(); out 是 PrintStream 类型
	重载的好处
		1) 减轻了起名的麻烦
		2) 减轻了记名的麻烦
	注意事项和使用细节
		1）方法名必须相同
		2）形参列表∶必须不同（形参类型或个数或顺序，至少有一样不同，参数名无要求）
		3）返回类型∶无要求
	可变参数
		java 允许将同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法。
		就可以通过可变参数实现
	基本语法
		访问修饰符 返回类型 方法名(数据类型... 形参名) { // ...很重要
	注意事项和使用细节
		1）可变参数的实参可以为0个或任意多个
		2）可变参数的实参可以为数组
		3）可变参数的本质就是数组
		4）可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
		5）一个形参列表中只能出现一个可变参数

*/
public class OverLoad {
	public static void main(String[] args){
		System.out.println("wangbing")
		System.out.println(1)
		System.out.println(true)
		System.out.println(1.1)
		System.out.println('a')
		Methods myMethods = new Methods()
		myMethods.max(2,3)
		myMethods.max(2.1,3.6)
		myMethods.max(2,3,4)
	}
}
class Methods {
	// 定义三个重载方法 max()，第一个方法，返回两个 int 值中的最大值，
	// 第二个方法，返回两个 double 值中的最大值，第三个方法，
	public int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}
	public double max(double n1, double n2) {
		return n1 > n2 ? n1 : n2;
	}
	public double max(double n1, double n2, double n3) {
		double max1 = n1 > n2 ? n1 : n2;
		return max1 > n3 ? max1 : n3; 
	}
	wangbing.1011
}
class VarParameters {
	//1. int... 表示接受的是可变参数，类型是 int ,即可以接收多个 int(0-多)
	//2. 使用可变参数时，可以当做数组来使用 即 nums 可以当做数组
	//3. 遍历 nums 求和即可
	public int varPar(int... nums){
		int res = 0
		for (int i = 0; i< nums.length;i++ ) {
			res+= nums[i]
		}
		return res
	}
	public String showScore(String name , double... subjects){
		double totalScore = 0
		for (int i=0; i < subjects.length ; i++ ) {
			totalScore += subjects[i]
		}
		return "姓名："+name+",总成绩为"+totalScore
	}
}