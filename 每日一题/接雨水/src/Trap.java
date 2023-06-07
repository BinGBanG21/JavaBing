import java.util.Stack;

public class Trap {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        //还是单调栈的一个应用
        //创建单调栈 保存下标 并初始化
        int area = 0;
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 1; i < height.length; i++) {
            //3中情况 大于小于等于
            if (height[i] < height[s.peek()]) {
                s.add(i);
            } else if (height[i] == height[s.peek()]) { //如果= 弹出再加入 避免重复计算
                s.pop();
                s.add(i);
            } else {
                //如果大于 那么持续计算雨水
                while (!s.isEmpty() && height[i] > height[s.peek()]) {
                    //记录mid值 然后弹出 才能拿到左边的值
                    int mid = s.peek();
                    s.pop();
                    //操作栈 就要判空
                    if (!s.isEmpty()) {
                        int h = Math.min(height[i], height[s.peek()]) - height[mid]; //左右取最小值 然后-中间柱子的高度 才是凹槽
                        int w = i - s.peek() - 1;
                        area += h * w;
                    }
                }
                //如果不大于 加入栈中
                s.add(i);
            }
        }
        return area;
    }
}
