import java.util.Deque;
import java.util.LinkedList;

public class isValid {
    public boolean isvalid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '[') {
                deque.push(']');
            } else if (ch == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
