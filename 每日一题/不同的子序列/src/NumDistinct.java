public class NumDistinct {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        //dp[i][j] : 以 i-i结尾的字符串s中含有的以j -1结尾的字符串t的个数
        //初始化dp数组
        int[][] dp = new int[s.length() + 1][t.length() + 1]; //+1为了取到length()
        //我们的状态由左上和上推到而来 所以我们要初始化[i][0] [0][j]
        //根据定义 i 0表示t为空 那么s全删除 符合 所以为1
        // 0 j 表示s为空 那么肯定不满足 所以为0
        // 0 0都为空 则为1
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < t.length(); j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                //如果两个字符相等 那么就相当于不考虑这个字符 结果就是上次的结果 然后i后退继续和j比较
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
