public class Rob {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        //首先对数组进行非空判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //初始化dp数组 dp[i]为考虑nums[i]在内的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //从2开始推导
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
