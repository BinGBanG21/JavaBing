public class Rob {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        //首先对nums进行处理 如果只有1 2两个元素
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //和打家劫舍同理 只不过题目中数组成环 我们不能同时取首尾
        //但是我们可以抛开头尾单独看 然后求两种情况的最大值
        int m = dp(nums, 1, nums.length - 1);
        int n = dp(nums, 0, nums.length - 2);
        return Math.max(m, n);
    }

    public int dp(int[] nums, int start, int end) {
        //这里也要对start end做参数处理
        if (start == end) { //1个元素
            return nums[start];
        }
        //初始化dp数组 dp[i] 表示截止到i的范围内 打劫的最大金币数
        int[] dp = new int[nums.length];
        //初始化dp[]的前两项 
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        //根据前两项得到递推公式
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
