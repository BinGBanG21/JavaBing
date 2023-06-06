public class FindLength {
    public static void main(String[] args) {

    }

    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j] : 以 i -1 j -1 为结尾的范围内的连续子数组的长度
        //初始化dp数组 dp[0][0]没有意义 赋值为0 所以我们要 + 1
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;
        //从1开始 索引不会越界
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                //如果当前相等 那么就把上一个范围内的相等连续子数组+1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }
        return result;
    }
}
