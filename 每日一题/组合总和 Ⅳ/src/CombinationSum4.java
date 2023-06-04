public class CombinationSum4 {
    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
        //请注意，顺序不同的序列被视作不同的组合
        //完全背包问题 求的是排列
        //dp[]含义： dp[target] 和为target有dp[target]种方法
        //创建dp数组
        int[] dp = new int[target + 1];
        //初始化dp数组 target为0 表示空集
        dp[0] = 1;
        //先背包再物品
        for (int i = 0; i <= target; i++) { //背包
            for (int j = 0; j < nums.length; j++) { //物品
                //剩余容量足够才能放入
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
