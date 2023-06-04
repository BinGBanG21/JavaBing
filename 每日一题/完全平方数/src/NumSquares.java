public class NumSquares {
    public static void main(String[] args) {

    }

    //    public int numSquares(int n) {
//        int[] f = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            int minn = Integer.MAX_VALUE;
//            for (int j = 1; j * j <= i; j++) {
//                minn = Math.min(minn, f[i - j * j]);
//            }
//            f[i] = minn + 1;
//        }
//        return f[n];
//    }
    public int numSquares(int n) {
        //完全背包 起始就是和为n的最少整数的数量
        //初始化dp数组
        int[] dp = new int[n + 1];
        //初始化数组为最大值
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        //初始化第一项
        dp[0] = 0;
        //遍历物品  1 4 9....
        for (int i = 1; i * i < n; i++) {
            //遍历背包
            for (int j = i * i; j <= n; j++) {
                //如果上一项不为最大值 我们才取结果
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }
}
