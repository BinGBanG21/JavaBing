public class RomanToInt {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        //总和
        int sum = 0;
        //拿到第0个数字 当作前面的值
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            //把前一个值和当前值做比较  小值在大值的左边 做减法 否则为加法
            if (pre < getValue(s.charAt(i))) {
                sum -= pre;
            } else {
                sum += pre;
            }
            //将pre后移 也就是把num的值赋给pre
            pre = getValue(s.charAt(i));
        }
        //还剩下最后一个值 肯定为正
        return sum += pre;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
