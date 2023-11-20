public class IsMatch {
    public static void main(String[] args) {

    }

    public boolean isMatch(String ss, String pp) {
        int n = ss.length();
        int m = pp.length();
        //创建二维数组 f[i][j]表示前i个字符和前j个字符的匹配情况
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        //拼接空字符串 方便遍历
        ss = " " + ss;
        pp = " " + pp;
        //转换成字符数组 方便取值
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //当前字符是否为*
                if (p[j] == '*') {
                    //使用 * (1次或多次) 不使用 *
                    f[i][j] = f[i][j - 1] || (i >= 1 && f[i - 1][j]);
                } else {
                    //如果都是小写字母 或者？
                    f[i][j] = i >= 1 && f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '?');
                }
            }
        }
        return f[n][m];
    }
}
