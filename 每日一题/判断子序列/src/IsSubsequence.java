public class IsSubsequence {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        //求的就是最长公共子序列的长度
        //dp[i][j] : 表示[0,i-1] [0,j -1]范围内的最长公共子序列的长度
        //初始化dp数组
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                //两种情况 相等 前一个状态+1 不相等 那么长的字符串退位比较
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        //根据dp长度判断
        if (dp[s.length()][t.length()] == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
