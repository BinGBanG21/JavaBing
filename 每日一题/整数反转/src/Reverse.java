public class Reverse {
    public static void main(String[] args) {

    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //开始循环前 要判断是否溢出
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int num = x % 10;
            x = x / 10;

            res = res * 10 + num;
        }
        return res;
    }
}
