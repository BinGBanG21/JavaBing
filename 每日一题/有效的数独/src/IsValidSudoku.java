public class IsValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        //根据题目规则 每一行不能重复 每一列不能重复 每一个九宫格不能重复
        //使用数组记录数字是否出现 初始为0 出现则+1
        //创建记录行的数组
        int[][] row = new int[9][9];
        //创建记录列的数组
        int[][] col = new int[9][9];
        //创建记录每一个小的九宫格的三位数组
        int[][][] subboxes = new int[3][3][9];

        //开始检查
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    //计算出索引 记录 然后判断是否合理
                    int index = c - '0' - 1;
                    row[i][index]++;
                    col[j][index]++;
                    subboxes[i / 3][j / 3][index]++; // i / 3 结果只能为012
                    //检查是否超过1
                    if (row[i][index] > 1 || col[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
