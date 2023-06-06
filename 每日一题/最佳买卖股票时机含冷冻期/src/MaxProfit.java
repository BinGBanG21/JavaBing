public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        //明确dp数组的含义
        //dp[i][0] : 持有股票的状态
        //dp[i][1] : 保持卖出股票的状态
        //dp[i][2] : 在今天卖股票
        //dp[i][3] : 冷冻期
        //因为卖出股票后有一天的冷冻期 所以我们要把持有股票的状态分成两个状态
        //创建dp数组并初始化第一项
        int len = prices.length;
        //参数处理
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            //持有股票的状态 1：前一天已持有  2：今天刚买  3：冷冻期后一天买的
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            //保持卖出股票的状态 1:之前卖出 2：买-卖-冷冻
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //当天卖出股票
            dp[i][2] = dp[i - 1][0] + prices[i];
            //冷冻期 前一天那天卖出 今天才是冷冻期
            dp[i][3] = dp[i - 1][2];
        }
        //除了买股票利润为- 剩下都为+ 取3个状态的最大值
        return Math.max(dp[len - 1][1], Math.max(dp[len - 1][2], dp[len - 1][3]));
    }
}
