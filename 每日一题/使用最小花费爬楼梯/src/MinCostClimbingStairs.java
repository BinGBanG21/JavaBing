public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //因为要爬完所有台阶 要>最后一个台阶 所以dp数组的长度为n + 1 索引为n
        int[] dp = new int[n + 1];
        //根据递推公式 初始化dp数组的已知项
        dp[0] = 0;
        dp[1] = 0;
        //dp[i -1] 为到达dp[i -1]的花费 cost为以当前阶梯为起点的两种花费
        //多爬一个台阶 要多一层循环
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min((dp[i - 1] + cost[i - 1]), (dp[i - 2] + cost[i - 2]));
        }
        return dp[n];
    }
}
