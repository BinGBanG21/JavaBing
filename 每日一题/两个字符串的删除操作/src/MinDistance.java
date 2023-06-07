public class MinDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        //其实本题求的还是最长相等子序列
        //dp[i][j] : 以i -1结尾的word1和j-1结尾的word2最长公共子序列的长度 方便初始化
        //创建数组并且初始化
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //相等和不相等两种情况 相等的话子序列长度+1 不相等就各退一位取最大值
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - (2 * dp[word1.length()][word2.length()]);
    }
}
