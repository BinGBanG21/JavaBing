public class Change {
    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {
        //明确dp[]的含义
        //完全背包问题 装满amount容量的方法有几种
        //创建dp[]数组
        int[] dp = new int[amount + 1];
        //初始化dp数组
        dp[0] = 1;
        //循环 递推公式
        //完全背包 正序遍历
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
