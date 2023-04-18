public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
    }

    //    public static int[][] generateMatrix(int n) {
//        //结果
//        int[][] result = new int[n][n];
//        //元素值
//        int count = 1;
//        //递归的次数  每次走一条边 少两个
//        int loop = 0;
//        //没圈的起始位置
//        int start = 0;
//        int i, j;
//
//        while (loop++ < n / 2) {
//            //循环不变量 左闭右开
//            //上边从左到右
//            for (j = start; j < n - loop; j++) {
//                result[start][j] = count++;
//            }
//            //右边从上到下
//            for (i = start; i < n - loop; i++) {
//                result[i][j] = count++;
//            }
//            //下边从右到左
//            for (; j >= loop; j--) {
//                result[i][j] = count++;
//            }
//            //左边从下到上
//            for (; i >= loop; i--) {
//                result[i][j] = count++;
//            }
//            //第一圈走完 走第二圈
//            start++;
//        }
//        //如果是奇数 那么最后的坐标start = count
//        if (n % 2 == 1) {
//            result[start][start] = count;
//        }
//        return result;
//    }
    public int[][] generateMatrix(int n) {
        //其实就是生成一个二维数组 进行填充 注意循环不变量
        int[][] result = new int[n][n];
        int startX = 0; //起始坐标
        int startY = 0; //起始坐标
        int offset = 1;
        int count = 1; //用于填充的元素值
        int loop = 0; //循环次数
        int i, j;
        //因为是4条边 我们每填充1圈 边长就少2
        while (loop++ < n / 2) {
            //填充上边  也就是二维数组的第一个数组
            for (j = startY; j < n - offset; j++) {
                result[startY][j] = count++;
            }
            //填充右边 也就是二维数组每个子数组的最后一个元素
            for (i = startX; i < n - offset; i++) {
                result[i][j] = count++;
            }
            //填充下边 也就是二维数组的最后一个数组
            for (; j > startY; j--) {
                result[i][j] = count++;
            }
            //填充左边 也就是二维数组的每一个子数组的第一个元素
            for (; i > startX; i--) {
                result[i][j] = count++;
            }
            //更改起始位置
            startX++;
            startY++;
            offset++;
        }
        //奇数圈的话 填补中心点
        if (n % 2 == 1) {
            result[startX][startY] = count;
        }
        return result;
    }
}
