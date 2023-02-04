public class MinPathSum {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        //边界处理
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //初始化dp二维数组
        int r = grid.length;
        int c = grid[0].length;
        //初始化起点的值
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];
        //状态转移表达式
        //只有一行或一列
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < c; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[r - 1][c - 1];
    }
}
