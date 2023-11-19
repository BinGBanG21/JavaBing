public class MaxCoins {
    public static void main(String[] args) {

    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        //创建一个n+2的数组 开始元素和末尾元素都为1
        int[] arr = new int[n + 2];
        //复制原数组 同时首尾元素都为1
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        //创建dp二维数组
        //表示ij中最后戳爆k气球所能得到的最大值 ij为开区间
        int[][] dp = new int[n + 2][n + 2];
        //从下往上遍历 因为当前值依赖左边的值和下边的值
        //例如 dp[1][5] 戳爆3  = dp[1][3] + dp[3][5] + (arr[1] * arr[3] * arr[5]);
        //i控制左边界 j控制右边界 k为当前气球
        for (int i = n - 1; i >= 0; i--) {
            //开区间 保证有1个元素
            for (int j = i + 2; j <= n + 1; j++) {
                //在i j范围内选择气球戳爆
                //dp[1][5]  2 3 4
                for (int k = i + 1; k < j; k++) {
                    int total = dp[i][k] + dp[k][j] + (arr[i] * arr[k] * arr[j]);
                    dp[i][j] = Math.max(dp[i][j], total);
                }
            }
        }
        return dp[0][n + 1];
    }
}
