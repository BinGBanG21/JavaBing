public class KthSmallest {
    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {
        //n n矩阵
        int n = matrix.length;
        //计算mid的值
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        //循环计算mid的值 并且比较
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, n, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    //计算左区间的元素个数 同时和k比较
    public boolean check(int[][] matrix, int mid, int n, int k) {
        //从左下角开始找
        int i = n - 1;
        int j = 0;

        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count >= k;
    }
}
