public class ClimbStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        //假设楼梯有1层 ： 1
        //2层 ： 2种  1 或者 2
        //3层 ： 先走1阶 然后剩下2阶 或者先走2阶 剩下1阶
        //斐波那契
        if (n <= 2) return n;
        int a = 1, b = 2, sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
