public class SetZeroes {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        //利用第一行第一列 记录哪行哪里列要变成0(原点不需要)
        //因为要将其所在行和列的所有元素都设为0 所以把他记录到第一行
        //然后根据第一行的0 改行列为0
        //最后查看第一行本身是否有0
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;

        //遍历数组 在第一行第一列记录0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    //如果第一行存在0 那么先记录 不要改
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
        }
        //根据第一行的数据 把这行所有列改为0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //同上 把这列的所有行改为0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //如果行列本身里面有0 那么改为0
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
