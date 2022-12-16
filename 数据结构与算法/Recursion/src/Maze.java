/*
    递归-迷宫问题

* */
public class Maze {
    public static void main(String[] args) {
        //先创建二维数组 模拟迷宫
        int[][] map = new int[8][7];
        //画出障碍 0表示路 1表示障碍 初始化迷宫
        //第一行和最后一行都是1 此处循环给列赋值
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //其余第1、7个是1 此处循环给行赋值
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //第4行的第23个为障碍
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        System.out.println("初始地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        //输出走过的地图
        System.out.println("走过的地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
    //使用递归回溯给老鼠找路
    //出发点map[i][j] 结束位置map[6][5]
    //0代表路 1代表墙 2代表障碍 3表示已经走过 但是走不通（为了回溯 回溯就是递归条件不成立 栈继续往下走）
    //策略：下 -- 右 -- 上 -- 左

    /**
     * @param map 地图
     * @param i   老鼠的起始位置
     * @param j   老鼠的起始位置
     * @return 找到返回true 找不到返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果当前位置为0 证明是路
            if (map[i][j] == 0) {
                //判断起点 上下左右四个位置是否能走通
                //拿到起点 先假设能走通 尝试走
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) { //下
                    return true;
                } else if (setWay(map, i, j + 1)) {//右
                    return true;
                } else if (setWay(map, i - 1, j)) {//上
                    return true;
                } else if (setWay(map, i, j - 1)) {//左
                    return true;
                } else {
                    //如果都没走通 那么表示当前这个点的上下左右都走不通 表示这个点是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {   //如果map[i][j]为123  要么初始值 也就是防止老鼠放置的位置一开始就有问题 还可以躲避障碍 并且防止走以前的路
                return false;
            }
        }
    }
}