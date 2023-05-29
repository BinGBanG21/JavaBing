public class MonotoneIncreasingDigits {
    public static void main(String[] args) {

    }

    public int monotoneIncreasingDigits(int n) {
        //变成字符数组 方便操作
        String[] str = (n + "").split("");
        //记录从哪个位置开始 都要重新赋值成9
        int start = str.length;
        for (int i = str.length - 1; i > 0; i--) {
            //如果不是单调递增 那么前一位-1 后一位变成9
            if (Integer.parseInt(str[i]) < Integer.parseInt(str[i - 1])) {
                str[i - 1] = (Integer.parseInt(str[i - 1]) - 1 + "");
                //记录从哪里开始重新赋值为9
                start = i;
            }
        }
        //赋值9  1234
        for (int i = start; i < str.length; i++) {
            str[i] = "9";
        }
        return Integer.parseInt(String.join("", str));
    }
}
