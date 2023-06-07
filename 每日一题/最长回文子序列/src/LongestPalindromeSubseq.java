public class LongestPalindromeSubseq {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        //dp[i][j]: [i,j]范围内的最长回文子串的长度
        //创建并初始化dp数组
        int[][] dp = new int[s.length()][s.length()];
        //状态由i+1 j -1而来 所以两个最终会相交 需要初始化相交的值 回文串的长度为1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        //遍历顺序 根据状态转移方程 从下到上 从左到右
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                //如果相等 上次状态+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //如果不相等 那么取各退一位的最大值
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
