import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {

    }

    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        //计算出要移除的左右括号数 也就是括号的净剩
        int lr = 0;
        int rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') lr++;
            if (s.charAt(i) == ')') {
                if (lr > 0) {
                    lr--;
                } else {
                    rr++;
                }
            }
        }
        backTracking(0, lr, rr, s);
        return res;
    }

    //回溯 移除左右括号
    public void backTracking(int start, int lr, int rr, String s) {
        //中止条件
        if (lr == 0 && rr == 0) {
            if (isValid(s)) {
                res.add(s);
            }
        }
        //循环
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {  // ()())() 当前值和上一个相同 那么跳过
                continue;
            }
            //处理左括号 如果是'('并且 lr > 0 那么删除'('
            if (s.charAt(i) == '(' && lr > 0) {
                backTracking(i, --lr, rr, s.substring(0, i) + s.substring(i + 1));
            }
            //处理有括号 如果是')'并且 rr > 0 那么删除')'
            if (s.charAt(i) == ')' && rr > 0) {
                backTracking(i, lr, --rr, s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    //判断括号是否有效
    public boolean isValid(String s) {
        //用于存放括号
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //消除
            if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            //只要括号
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
