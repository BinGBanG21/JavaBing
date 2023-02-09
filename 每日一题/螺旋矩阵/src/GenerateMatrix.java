public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        //结果
        int[][] result = new int[n][n];
        //元素值
        int count = 1;
        //递归的次数  每次走一条边 少两个
        int loop = 0;
        //没圈的起始位置
        int start = 0;
        int i, j;

        while (loop++ < n / 2) {
            //循环不变量 左闭右开
            //上边从左到右
            for (j = start; j < n - loop; j++) {
                result[start][j] = count++;
            }
            //右边从上到下
            for (i = start; i < n - loop; i++) {
                result[i][j] = count++;
            }
            //下边从右到左
            for (; j >= loop; j--) {
                result[i][j] = count++;
            }
            //左边从下到上
            for (; i >= loop; i--) {
                result[i][j] = count++;
            }
            //第一圈走完 走第二圈
            start++;
        }
        //如果是奇数 那么最后的坐标start = count
        if (n % 2 == 1) {
            result[start][start] = count;
        }
        return result;
    }
}
