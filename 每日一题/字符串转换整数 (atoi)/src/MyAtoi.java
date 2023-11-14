public class MyAtoi {
    public static void main(String[] args) {

    }

    public int myAtoi(String s) {
        int res = 0, max = Integer.MAX_VALUE / 10; //防止越界
        int i = 0, sign = 1, len = s.length();
        //特殊处理
        if (len == 0) {
            return 0;
        }
        //对空白格进行处理
        while (s.charAt(i) == ' ') {
            //跳过空格 如果只有空格 那么return 0
            if (++i == len) {
                return 0;
            }
        }
        //对正负号进行处理
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        //走到数字
        for (int j = i; j < len; j++) {
            if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                break;
            }
            //越界处理
            if (res > max || res == max && s.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(j) - '0');
        }
        return res * sign;
    }
}
