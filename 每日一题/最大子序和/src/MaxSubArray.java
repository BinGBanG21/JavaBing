public class MaxSubArray {
    public static void main(String[] args) {

    }

    //    public int maxSubArray(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        //思路：贪心算法 每次拿到的值都要比当前的总和大 如果是负数 就全部扔掉
//        int result = Integer.MIN_VALUE;
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//            //和为正数 记录sum
//            result = Math.max(result, sum);
//            //从下一位开始取 不拉低总和
//            if (sum <= 0) {
//                sum = 0;
//            }
//        }
//        return result;
//    }
    public int maxSubArray(int[] nums) {
        //边界处理
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]: 包含下标i在内的数组的子序列和的最大值
        //结果初始值为数组的第一项
        int res = nums[0];
        //创建并初始化dp数组
        int[] dp = new int[nums.length];
        //只有一个元素 和的最大值为nums[0]
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //3种情况  1：前面和为负数 从当前值开始累加 2：前面和为正数 当前值为负数 那么也适用
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
