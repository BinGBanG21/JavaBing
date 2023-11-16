import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static void main(String[] args) {

    }

    public String fractionToDecimal(int numerator, int denominator) {
        //转化成long计算 防止溢出
        long a = numerator, b = denominator;
        //如果本身能整除 则直接返回结果
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        //不能整除 则需要拼接
        StringBuilder sb = new StringBuilder();
        //计算符号 然后转化为绝对值计算
        if (a * b < 0) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);

        //计算小数点的前面部分 将余数赋值给a继续除
        sb.append(String.valueOf(a / b) + ".");
        a %= b;
        //记录余数 找循环体
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            //记录余数的值和出现的位置
            map.put(a, sb.length());
            //每次*10 然后除
            a *= 10;
            sb.append(a / b);
            a %= b;
            //再次对余数a进行查找
            if (map.containsKey(a)) {
                int start = map.get(a);
                //依据格式拼接
                return String.format("%s(%s)", sb.substring(0, start), sb.substring(start));
            }
        }
        return sb.toString();
    }
}
