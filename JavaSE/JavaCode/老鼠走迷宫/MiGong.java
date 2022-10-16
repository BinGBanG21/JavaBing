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
	/*
		思路：
			1.关于参数 map是一个8*7的二维数组 i j 可以看成是坐标一样的 
			2.规定几种状态  0为路  1为障碍物 2为当前走过的路线（轨迹） 3为当前路线尽头（即为死路 当前位置的上下左右都是障碍物）
			3.如何确定老鼠走出了迷宫 即 map[6][5] 为2
			4.找路规律 上->右->下->左
			5.最终返回布尔值 是否找到了路
	*/
	public boolean FindWay(int[][] map ,int i, int j){
		if (map[6][5] == 2) {
			return true
		}else {
			//小老鼠的起始路线要在路上我们才做出处理 不能在障碍物上或者边界上面
			if (map[i][j] == 0) {
			//把当前这个格子记录为行走路线
				map[i][j] = 2
				//开始按照找路规律递归 因为FindWay本身返回布尔值 所以if else 判断会一直走 知道最后找到路或者没找到路
				if ( FindWay ( map, i - 1, j ) ) { //上
					return true
				} else if (FindWay(map, i , j+1)) { // 右
					return true
				} else if (FindWay(map,i+1, j)) { //下
					return true
				} else if (FindWay(map, i-1, j)) { //左
					return true
				}
			}else { // 因为起始的时候数组只有0和1 如果不是0那我们不做处理
				return false
			}
		}
	}
}