public class CountSubstrings {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        //dp[i][j]: i j 一头一尾 如果两个相等 那么就是回文串
        //创建dp数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        //创建结果
        int res = 0;
        //根据状态转移方程 当前值依赖于左下角的值
        //所以遍历顺序为从下到上 从左到右
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                //如果当前字符相等 那么就是true
                if (s.charAt(i) == s.charAt(j)) {
                    //并且如果 j - i <= 1  举例 a aa
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { //如果超过3个字符 那么看中间是否是回文串
                            res++;
                            dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }
}
