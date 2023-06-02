public class LastStoneWeightII {
    public static void main(String[] args) {

    }

    public int lastStoneWeightII(int[] stones) {
        //和相等子集问题类似
        //转化为01背包问题
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        //初始化dp数组 都为0 采用1维数组
        int[] dp = new int[target + 1];
        //填表
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                //状态转移方程
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //如果大于证明有剩余 否则为0
        //target > dp[target] ? target - dp[target] : 0; 不要用除法
        //举例： 11 - 5 * 2 = 1  11 / 2 -5 = 0
        return sum - dp[target] * 2;
    }
}
