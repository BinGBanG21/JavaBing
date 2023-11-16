import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        //从2开始枚举到sqrt(n) 因为合数肯定有一个因数 <= sqrt(n)
        for (int i = 2; i * i < n; i++) {
            //如果当前是素数 就从i*i开始 i的所有倍数都不会是素数
            //为什么从平方开始 因为 2倍 3倍 会被过滤掉 23本身是质数 所以从平方开始
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        //计数
        int res = 0;
        for (int i = 2; i < isPrim.length; i++) {
            if (isPrim[i]) {
                res++;
            }
        }
        return res;
    }
}
