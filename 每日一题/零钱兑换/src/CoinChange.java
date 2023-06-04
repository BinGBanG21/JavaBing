import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        //dp[j] ：表示和为j的最少硬币个数
        //创建dp数组并且初始化
        int[] dp = new int[amount + 1];
        //求的是最少硬币数量 我们初始化数组为最大值
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        //初始化第一项
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) { //物品
            for (int j = coins[i]; j <= amount; j++) {
                //如果上一次结果为最大值 说明上一次没有结果
                if (dp[j - coins[i]] != max) {
                    //硬币的最小值 + 1 即为放了当前硬币的最小值
                    //dp[j] 不放最小值
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }

        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
