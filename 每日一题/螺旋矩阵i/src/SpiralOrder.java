import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //创建结果
        List<Integer> ans = new ArrayList<>();
        //空数组  直接返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        //一圈一圈输出
        int row = matrix.length, col = matrix[0].length;
        //循环开始的起点
        int left = 0, right = col - 1, top = 0, bottom = row - 1;

        //开始循环
        while (left <= right && top <= bottom) {
            //上
            for (int column = left; column <= right; column++) {
                ans.add(matrix[top][column]);
            }
            //右
            for (int r = top + 1; r <= bottom; r++) {
                ans.add(matrix[r][right]);
            }
            //奇数圈没有下左 偶数有 所以要判断一下
            if (left < right && top < bottom) {
                //下
                for (int column = right - 1; column > left; column--) {
                    ans.add(matrix[bottom][column]);
                }
                //左
                for (int r = bottom; r > top; r--) {
                    ans.add(matrix[r][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
