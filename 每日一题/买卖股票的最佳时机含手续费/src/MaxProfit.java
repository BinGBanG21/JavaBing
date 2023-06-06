public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        //和2一样 只不过算利润的时候-fee
        //明确dp数组的含义 dp[0][1] 0 持有 1不持有
        //创建dp数组
        int[][] dp = new int[prices.length][2];
        //初始化数组的第一项
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //持有2种情况 1：之前持有 2：当天买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //不持有2种情况 1: 之前卖出 2：当天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}
