public class Multiply {
    public static void main(String[] args) {

    }

    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        //创建结果数组 相乘的最大值不会超过m+n
        int[] res = new int[m + n];
        //倒叙遍历 模拟乘算过程
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                //拿到两个数 相乘
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int r = a * b;
                //从后向前放入数组
                r += res[i + j + 1];
                //进位
                res[i + j + 1] = r % 10;
                res[i + j] += r / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            //忽略前导0
            if (sb.length() == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
