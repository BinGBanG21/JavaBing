public class IsPowerOfTwo {
    public static void main(String[] args) {

    }

    public boolean isPowerOfTwo(int n) {
        //2的最大次幂为30 所以我们只需要看n是不是2的约
        int BIG = 1 << 30;
        return n > 0 && BIG % n == 0;
    }
}
