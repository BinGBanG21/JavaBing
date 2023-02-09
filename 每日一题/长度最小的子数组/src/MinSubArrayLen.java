public class MinSubArrayLen {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口解决
        int start = 0;
        int end = nums.length;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        //i起始位置 j终止位置
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                int subL = j - i + 1;
                result = Math.min(result, subL);
                sum -= nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
