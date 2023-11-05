public class MaximalSquare {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        //如果参数不满足二维数组 返回0
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        //思路 我们把每一个给格当做正方形的右下角 那么最大的正方形为: 以其 左 上 左上 3个格子分别为正方形右下角的最小边长+1(也就是本身的格子)
        //所以我们要扩容 行列多填充一组0 使得二维数组中第一个元素就是右下角
        //dp数组的含义 dp[i + 1][j + 1]表示以dp[i][j]为右下角的最大正方形的边长
        int row = matrix.length;
        int col = matrix[0].length;
        //边长
        int maxSide = 0;

        //预处理 第一行第一列都为0
        int[][] dp = new int[row + 1][col + 1];

        //循环 记录状态
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //如果当前值为1 那么当作正方形的右下角
                if (matrix[i][j] == '1') {
                    //状态转移 取最小值+1
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    //计算出多个边长 选最大的
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
