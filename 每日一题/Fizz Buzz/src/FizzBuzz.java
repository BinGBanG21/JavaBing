import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {
        //创建结果
        List<String> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            //拼接字符串
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
