public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        //边界判断
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        //明确dp数组的含义
        //dp[i][0] : 维持状态
        //dp[i][1] : 第一次买入
        //dp[i][2] : 第一次卖出
        //dp[i][3] : 第二次买入
        //dp[i][4] : 第二次卖出
        //初始化dp数组
        int[][] dp = new int[len][5];
        //初始化第一项
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < len; i++) {
            //第一次持有 之前持有 延续状态 当天持有
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            //第一次卖出 之前卖出 延续状态 当天卖出 总利润为上次的结果
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            //第二次买入 之前买入 延续状态 当天买入 总利润为上次的结果
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
            //第二次卖出 之前卖出 延续状态 当天卖出 总利润为上次的结果
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
}
