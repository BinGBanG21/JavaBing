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


*/
public class OverLoad {
	public static void main(String[] args){
		System.out.println("wangbing")
		System.out.println(1)
		System.out.println(true)
		System.out.println(1.1)
		System.out.println('a')
	}
}
