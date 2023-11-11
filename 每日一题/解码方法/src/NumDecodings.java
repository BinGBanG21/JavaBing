public class NumDecodings {
    public static void main(String[] args) {

    }

    public int numDecodings(String s) {
        //最后一个数字有两种解法
        //1.单独解码 2.和前一位一起解码(10,26)
        //f[i] = f[i -1] + f[i - 2]
        int n = s.length();
        //字符串下标从0开始
        int[] f = new int[n + 1];
        //初始化f[0]为1 保证f[2]的正确性
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            //单独解码
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            //2位
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
