import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        //首先对数组进行首尾+0操作
        //如果数组为 2468 那么不走计算逻辑 所以需要尾部+0 破坏递增
        //如果数组为 8642 那么需要首部+0 让其凑够3个元素 进行计算
        int[] newHeight = new int[heights.length + 2];
        newHeight[0] = 0;
        newHeight[newHeight.length - 1] = 0;
        //拷贝其他数据
        for (int i = 0; i < heights.length; i++) {
            newHeight[i + 1] = heights[i];
        }
        //创建单调递减栈及结果
        Stack<Integer> s = new Stack<>();
        s.add(0);
        int maxArea = 0;
        heights = newHeight;
        for (int i = 1; i < heights.length; i++) {
            //3种情况 大于 小于 等于 大于等于 入栈 小于就计算面积
            if (heights[i] > heights[s.peek()]) {
                s.add(i);
            } else if (heights[i] == heights[s.peek()]) {
                s.pop();
                s.add(i);
            } else {
                while (!s.isEmpty() && heights[i] < heights[s.peek()]) {
                    //计算面积
                    int baseHeight = s.peek();
                    s.pop();
                    int left = s.peek();
                    int right = i;
                    int area = (right - left - 1) * heights[baseHeight];
                    maxArea = Math.max(area, maxArea);
                }
                //如果大于等于 那么直接加入
                s.add(i);
            }
        }
        return maxArea;
    }
}
