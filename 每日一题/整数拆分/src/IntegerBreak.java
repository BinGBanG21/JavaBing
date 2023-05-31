public class IntegerBreak {
    public static void main(String[] args) {

    }

    public int integerBreak(int n) {
        //dp[i] 即为正整数i拆分的最大乘机
        //为了取到n 所以[] 为n + 1
        int[] dp = new int[n + 1];
        // 0不能拆分 1也不能拆分 所以都是0  2拆分11
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) { //从1开始递增 最大值就是
                //有些数拆了不如不拆 例如3  然后是拆成2个数 拆成3个及以上数
                dp[i] = Math.max(dp[i], Math.max((j * (i - j)), (j * dp[i - j])));
            }
        }
        return dp[n];
    }
}
