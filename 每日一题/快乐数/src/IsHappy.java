import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        boolean result1 = isHappy(19);
        boolean result2 = isHappy(68);
        System.out.println(result1);
        System.out.println(result2);
    }

    //    public boolean isHappy(int n) {
//        //记录得到的数字 如果重复出现了 就说明是一个循环
//        Set<Integer> set = new HashSet<>();
//        //有两种情况
//        //1. = 1
//        //2. 无限循环 通过set.contains检测循环
//        while (n != 1 && !set.contains(n)) {
//            set.add(n);
//            n = getNextNumber(n);
//        }
//        return n == 1;
//    }
//
//    public int getNextNumber(int n) {
//        int res = 0;
//        while (n > 0) {
//            //拿到数字计算 然后n往前移
//            int temp = n % 10;
//            res += temp * temp;
//            //计算一位数字后 小数点前移
//            n = n / 10;
//        }
//        return res;
//    }
    public boolean isHappy(int n) {
        //只有两种情况
        //我们需要记录每次结果 来判断是否发生了循环
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNum(n);
        }
        //发生循环 当前数字在集合中已经找到 此时返回即可
        //这里不直接返回false 是吧n=1的情况进行了考虑
        return n == 1;
    }


    //获得平方数
    public int getNum(int n) {
        int res = 0;
        //去余数  n = 0说明取完了 12/10 = 1   1/10 = 0
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
