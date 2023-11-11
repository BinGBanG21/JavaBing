import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> helpStack;

    public static void main(String[] args) {

    }

    //借用辅助栈 入栈的时候同时在辅助栈中入当时的最小值
    //最小栈和辅助栈一一对应
    //弹出的时候都弹出
    public MinStack() {
        stack = new LinkedList<>();
        helpStack = new LinkedList<>();
        //初始化一下辅助站
        helpStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        helpStack.push(Math.min(helpStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        helpStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }
}
