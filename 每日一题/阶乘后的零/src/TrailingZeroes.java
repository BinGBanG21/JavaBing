public class TrailingZeroes {
    public static void main(String[] args) {

    }

    public int trailingZeroes(int n) {
        //求的是0的个数  所以2*5=10 会产生0
        //2每两个数出现一次 4=2*2 6=2*3 8=2*4 所以我们只需要求5的个数 就是0的个数
        //类似 10*10 = 100  25 50 也要统计
        int count = 0;
        while (n > 0) {
            //0的个数应为 n / 5 + n / 25 + n / 125
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
