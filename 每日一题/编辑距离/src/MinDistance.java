public class MinDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        //dp[i][j] : 以i -1为结尾的word1转化为以j-1为结尾的word2的最小操作数
        //创建dp数组并初始化
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //如果w2为空 那么操作数为1的长度 说白了1要一直删除
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        //同理
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //相等 那么操作数不变
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果不相等 那么增删操作数是一样的 我们取一种 替换的后果就是就是上次的结果+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
