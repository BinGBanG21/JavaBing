//常见错误 ： 找不到文件（文件名写错 路径不对等 报错很清楚了） 文件名与主类名方法不一致 缺少分号




//转义字符
public class ChangeChar{
	public static void main(String[] args){
		//制表符 \t  tab
		System.out.println("守望2\t永劫无间\t英雄联盟");
		//换行符 \n  next
		System.out.println("守望\n守望2");
		// \n  next
		System.out.println("守望\n守望2");
		//一个\  两个\\  
		System.out.println("守望\\守望2\\\\LOL");
		//单双引号 \' \" 
		System.out.println("守望\"守望2\"");
		// /r 回车  注意  这里面的数字好像占据半个字符位置 有点奇怪
		// 如果想另起一行不替换  那就\r\n
		System.out.println("永劫无间\r守望");

		System.out.println("游戏名\t价格\t销量\t游戏时长\r\n守望2\t免费\t100\t400h源氏");

	}
}