import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        //记录得到的数字 如果重复出现了 就说明是一个循环
        Set<Integer> set = new HashSet<>();
        //有两种情况
        //1. = 1
        //2. 无限循环 通过set.contains检测循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    public int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            //拿到数字计算 然后n往前移
            int temp = n % 10;
            res += temp * temp;
            //计算一位数字后 小数点前移
            n = n / 10;
        }
        return res;
    }
}
