public class MaxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //dp[i] 以nums[i]为结尾的最大子数组的和
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < len;i++){
            dp[i] = Math.max(dp[i-1] + nums[i] , nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
