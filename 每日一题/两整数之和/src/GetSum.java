public class GetSum {
    public static void main(String[] args) {

    }
    public int getSum(int a, int b) {
        // 循环，当进位为 0 时跳出
        while (b != 0) {
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
