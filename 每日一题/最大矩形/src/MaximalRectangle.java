import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        //以每一行为底 统计置顶的高度 把当图形变成矩形
        //0就重置0  1就累加
        int row = matrix.length, col = matrix[0].length, ans = 0;
        //记录数组高度的数组
        //首尾补0作用：防止 单调递增或者递减数组 走不到计算过程
        int[] height = new int[col + 2];
        int res = 0;
        //以每一行为底 转换矩形图 并求最大值
        for (int i = 0; i < row; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < height.length; j++) {
                if (j >= 1 && j <= col) {
                    if (matrix[i][j - 1] == '1') {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                //计算该层矩形图的最大面积
                //左边值：栈顶 基准值：栈顶后一个元素 右边值:j 当前元素
                while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
                    //因为前面补了0 循环从0开始
                    //所以高为栈顶元素 右边界为当前值
                    int cur = stack.pop();
                    res = Math.max(res, (j - stack.peek() - 1) * height[cur]);
                }
                stack.push(j);
            }
        }
        return res;
    }
}
