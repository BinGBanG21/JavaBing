public class Solution {
    public static void main(String[] args) {

    }

    public static boolean num(int x) {
        //负数前面有-号  一定给不是回文数
        if (x < 0) {
            return false;
        }
        //整体思路 原来的数一直/10 结果数一直*10 有余数就加上余数(num%10)
        int res = 0; //初始值为0
        int num = x; //保存x的值
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res == x;
    }
}
