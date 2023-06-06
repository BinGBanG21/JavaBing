import java.util.Arrays;

public class LengthOfLIS {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        //明确dp数组的含义 dp[i] : 以nums[i]为结尾的最长递增子序列的长度为dp[i]
        //创建dp数组并全部初始化为1
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //如果i > j 说明我们的j可以+1 然后重新给dp[i]赋值 找到最近的小于nums[i]的那个数的dp值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
