public class HammingWeight {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        //二进制1  0001一直左移 比较每一位数
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
