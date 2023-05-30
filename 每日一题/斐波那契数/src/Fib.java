public class Fib {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        //根据题目 初始化dp数组 因为题目说dp数组的第一项为0
        int[] dp = new int[n + 1]; //多个一个0
        //初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { //因为多了一个数 循环的时候我们下标正好就可以循环到n
            //状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
