public class MyPow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        long N = n;
        //n < 0 取倒数
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    //快速幂 把上一次的结果平方
    //如果是奇数 那么在* x
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        //判断奇偶
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
