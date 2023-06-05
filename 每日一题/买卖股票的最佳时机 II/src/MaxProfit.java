public class MaxProfit {
    public static void main(String[] args) {

    }

    //    public int maxProfit(int[] prices) {
//        int ans = 0;
//        int n = prices.length;
//        for (int i = 1; i < n; ++i) {
//            ans += Math.max(0, prices[i] - prices[i - 1]);
//        }
//        return ans;
//    }
//    //从第二天开始循环 正数就就记录
//    public int maxProfit(int[] prices) {
//        int maxPro = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxPro += Math.max(0, prices[i] - prices[i - 1]);
//        }
//        return maxPro;
//    }
    public int maxProfit(int[] prices) {
        //思路 和买卖股票是一样的 区别就是可以多次买入 那我们的剩余利润不是0 而是dp[i -1][1]
        //明确dp数组含义:
        //    dp[i][0]: i天内持有股票的最大利润
        //    dp[i][1]: i天内不持有股票的最大利润
        int[][] dp = new int[prices.length][2];
        //初始化dp数组
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天持有股票 之前没买 今天买了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //第i天没持有股票 之前卖了 或者今天买了
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
