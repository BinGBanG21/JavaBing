import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        //结果
        Deque<Integer> stack = new ArrayDeque<>();
        //上一个字符变量 初始值补一个+ 这样就可以把第一个值放入
        char preSign = '+';
        int num = 0;
        int n = s.length();
        //循环读取
        for (int i = 0; i < n; i++) {
            //如果是数字 考虑到几位数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //如果符号 或者遍历到了最后
            // 我们都拿当前值和前一个符号处理
            // 如果乘除 那么弹栈中的数字 运算后入栈
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                //然后记录当前符号
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
