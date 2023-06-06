public class MaxUncrossedLines {
    public static void main(String[] args) {

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //其实线连起来 不能相交 都是虚晃
        //这个问题就是最长公共子序列 保证了顺序和个数
        //dp[i][j] : 表示[0, i-1] [0, j-1]
        //创建dp数组 并且dp数组全部初始化为0 因为是根据前一个状态推过来的
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                //dp的状态 两种情况 相等 不相等
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不相等 当下互相退一位 比较
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
