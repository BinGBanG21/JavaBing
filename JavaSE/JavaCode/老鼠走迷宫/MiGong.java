public class MiGong {
	public static void main(String[] args){
		//思路：首先使用二维数组 确定迷宫的整体大小
		int[][] map = new int[8][7]
		//我们规定0为可以走的路 1为障碍物 初始化二维数组的时候 默认值就是0 所以我们只需要画出1 障碍物的位置即可
		//首先迷宫第一行和最后一行都是1 注意的是 循环变量i表示列上的每一个元素
		for (int i =0; i < 7 ; i++ ) {
			int[0][i] = 1
			int[7][i] = 1
		}
		//其次 迷宫的左右两列都是1 注意的是 循环变量i表示行数
		for (int i = 0; i < 8 ; i++ ) {
			int[i][0] = 1
			int[i][6] = 1
		}
		//最后 迷宫第4列的第2、3个元素为障碍物 这样就完成了迷宫
		int[3][1] = 1
		int[3][2] = 1
	}
}
class Find {
	public boolean FindWay(int[][] map ,int i, int j){}
}