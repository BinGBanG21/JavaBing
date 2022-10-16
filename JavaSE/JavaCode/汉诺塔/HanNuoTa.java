public class HanNuoTa {
	public static void main(String[] args){
		
	}
}
class Tower {
	//规则 汉诺塔：汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，
	//在一根柱子上从下往上按照大小顺序摞着 64 片圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一
	//根柱子上。并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
	//total 想要移动的层数  a  b  c 表示三个塔 3个塔 一个初始状态 一个结束状态 两两移动 每次做移动的时候 用第三个塔做过渡
	//递归的思路 找到两个盘子是如何摆放的就好 
	//思路总结：每次经过过渡 拿到最底下的 也就是剩余盘子最大的 放到C塔上面
	public void move ( int total , char a , char b, char c) {
		//一个盘子的时候 直接移动到最右边的塔
		if ( total == 1) {
			System.out.println(a + "->" + c)
		} else { //两个或者多个盘子的时候 把上面的所有盘子看成一个整体 
			//2个盘子的思路就是让上面的盘子先到过渡塔
			move ( total - 1, a, c, b )
			System.out.println(a + "->" + b)
			//然后再把b塔的盘子移动到c塔
			move ( total -1, b, a, c)
		}
	}
}