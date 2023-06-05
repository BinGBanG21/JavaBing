public class MaxProfit {
    public static void main(String[] args) {

    }

    //    public int maxProfit(int[] prices) {
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        for (int price : prices) {
//            if (price < minPrice) {
//                minPrice = price;
//            } else if ((price - minPrice) > maxProfit) {
//                maxProfit = price - minPrice;
//            }
//        }
//        return maxProfit;
//    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //创建dp数组
        int[][] dp = new int[prices.length][2];
        //明确dp数组的含义 dp[i][j] j = 0 表示持有  1 表示不持有
        //初始化dp数组的前两项
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //递推公式
            //持有不持有两种情况 填充数组
            //当天是持有状态 那么是前面任意一天买入 或者今天买入
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            //当天是不持有状态 要么是前面任意一天卖出 或者以前持有今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
