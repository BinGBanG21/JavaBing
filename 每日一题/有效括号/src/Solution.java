import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        //创建字符
        char c;
        //循环数组 进行符号判断
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            //如果是左边3种括号 直接加入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //如果栈为空 证明多了右边的括号 那么false
                if (stack.empty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
