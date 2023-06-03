public class FindTargetSumWays {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        //思路 我们把数组分成两个子集 left加 right减
        // left + right = sum  left - right = target
        // right = left - target  left + left - target = sum 2left = sum + target
        //得出left与target sum 的关系
        //dp[j]的含义： 如果背包容量为5 1重量的物品 剩下4容量有dp[4]种方法... 2 dp[3]
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //对target边界处理 left为背包容量 如果target + sum < 0 那么无意义 背包容量为负数
        if (target < 0 && -target > sum) {
            return 0;
        }
        // 2left一定为偶数  所以target + sum 也一定为偶数
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        //背包容量
        int size = (target + sum) / 2;
        //初始化dp数组
        int[] dp = new int[size + 1];
        //背包容量为0 有一种方法 就是不放
        dp[0] = 1;
        for (int num : nums) {
            for (int j = size; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[size];
    }
}
