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
		System.out.println("永劫无间\r守望");


	}
}