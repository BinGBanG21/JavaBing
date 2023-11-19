
public class IsMatch {
    public static void main(String[] args) {

    }

    public boolean isMatch(String ss, String pp) {
        //创建dp数组 初始化dp数组的值
        int n = ss.length();
        int m = pp.length();
        //表示长度为
        boolean[][] f = new boolean[n + 1][m + 1];
        //拼接空字符 数组从1开始 方便索引的处理
        ss = " " + ss;
        pp = " " + pp;
        //如果是空字符串 两者也匹配
        f[0][0] = true;

        //转换为数组 方便取值 不用一直charAt
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        //s = " ", p = ".*"
        //所以s要从0开始遍历
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //对字母后面跟着* 要整体看 当前字符不能单独看 所以跳过
                if (j + 1 <= m && p[j + 1] == '*' && p[j] != '*') {
                    continue;
                }
                //如果不为* 那么dp数组的值为上一次的值 && 最后一个字符是否相等 || 最后一个字符为 .
                if (i >= 1 && p[j] != '*') {
                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                } else if (p[j] == '*') {
                    //如果为* 那么有两种情况
                    //1. *为0    f[i][j] = f[i][j -2]
                    //2. *为>=1  f[i][j] = f[i -1][j] 但是sp的两个字母位要相等 或者j的位置为 .
                    f[i][j] = (j >= 2 && f[i][j - 2]) ||
                            (i >= 1 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
                }
            }
        }
        return f[n][m];
    }
}
