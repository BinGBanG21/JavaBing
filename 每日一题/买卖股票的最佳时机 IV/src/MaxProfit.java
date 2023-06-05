import java.util.Arrays;

public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int k, int[] prices) {
        //参数判断
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        //和4一样 只不过2次变成了k次 是对4的抽象
        //初始化dp数组
        int[][] dp = new int[prices.length][2 * k + 1];
        //初始化dp数组的第一项 每次买入 利润为-prices[i]
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        //填表 从第二项开始
        for (int i = 0; i < len; i++) {
            // 0 表示无操作
            for (int j = 0; j < 2 * k - 1; j += 2) {
                //每次的买入卖出 0无操作 1买入 2卖出
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][2 * k];
    }
}
