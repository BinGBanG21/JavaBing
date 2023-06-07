import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈：和栈一样 只不过里面的元素是递增的或者递减的
        //栈的元素为索引 方便计算
        //创建结果和栈
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> s = new Stack<>();
        //把第一个元素的索引放入 然后从第二个元素开始遍历
        s.push(0);
        for (int i = 1; i < len; i++) {
            //如果当前元素小于等于栈顶元素 那么直接入栈
            if (temperatures[i] <= temperatures[s.peek()]) {
                s.push(i);
            } else {
                //如果大于 那么记录到结果数组 然后弹出
                while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                    res[s.peek()] = i - s.peek();
                    s.pop();
                }
                //如果遇到<=的值 继续push到栈中
                s.push(i);
            }
        }
        return res;
    }
}
