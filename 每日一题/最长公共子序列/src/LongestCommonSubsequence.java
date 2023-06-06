public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]: 表示[0,i - 1] [0,j - 1]的最长公共自序列的长度 方便初始化
        //创建dp数组并初始化
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                //dp有两种情况 相等和不相等
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //如果不相等 那么上下退一位 求最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
