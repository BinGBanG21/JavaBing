public class Divide {
    public static void main(String[] args) {

    }

    public int divide(int dividend, int divisor) {
        //倍增法
        //判断溢出的情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //记录结果的符号
        int sign = -1;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            sign = 1;
        }

        //全部换成负数 防止溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        //倍乘法
        //每次减去2^0*除数 2^1*除数 2^2*除数 如果结果小于除数 那么就更换被除数 从2^0重新开始
        //注意都是负数
        while (dividend <= divisor) {
            int count = 1;
            int temp = divisor;
            while (temp >= dividend - temp) {
                temp = temp << 1;
                count = count << 1;
            }
            //更新被除数
            dividend -= temp;
            ans += count;
        }
        return sign < 0 ? -ans : ans;
    }
}
