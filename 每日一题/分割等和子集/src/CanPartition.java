public class CanPartition {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        //看作01背包问题
        //只有一个数组 物品的重量和价值相等
        //参数处理
        if (nums == null || nums.length == 0) {
            return false;
        }
        //拿到中间值 判断能否分成两个和相等的子集
        //只需要算出总和 然后看元素是否相加能等于总和即可
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //如果n为奇数 那么不可能相等
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //创建dp数组
        //为什么全部初始化为0  因为dp[0] = 0 我们在计算dp[j]的值的时候 使用的是max
        //负数又没有意义 所以初始化一个非负整数的最小的值 就是0
        int[] dp = new int[target + 1];
        //填表
        for (int i = 0; i < nums.length; i++) {
            //为什么要倒叙遍历 因为根据状态转移方程
            //我们压缩数组 本质是把二维数组中上一行的结果拷贝过来使用
            //计算当前值 需要借助左边的值 然后计算好后直接填值 相当于覆盖
            //如果正序遍历 那么前面的值都被覆盖了
            for (int j = target; j >= nums[i]; j--) {
                //不放入当前物品 dp[j]值不变 放入就-重量 +价值
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        //判断是否相等
        return dp[target] == target;
    }
}
