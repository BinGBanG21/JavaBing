public class IsPowerOfThree {
    public static void main(String[] args) {

    }

    //3的最大次幂为1162261467  我们只需要判断n是否为3^19的约数即可
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
