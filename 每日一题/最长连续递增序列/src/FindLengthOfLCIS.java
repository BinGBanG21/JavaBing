import java.util.Arrays;

public class FindLengthOfLCIS {
    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] nums) {
        //dp[i] 以nums[i]结尾的练习子序列的长度
        //创建dp数组并初始化 因为1个元素也看作递增 所以全部赋值为1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            if (dp[i + 1] > result) {
                result = dp[i + 1];
            }
        }
        return result;
    }
}
