public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //思路：贪心算法 每次拿到的值都要比当前的总和大 如果是负数 就全部扔掉
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            //和为正数 记录sum
            result = Math.max(result, sum);
            //从下一位开始取 不拉低总和
            if (sum <= 0) {
                sum = 0;
            }
        }
        return result;
    }
}
