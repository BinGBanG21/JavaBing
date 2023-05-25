import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    public static void main(String[] args) {

    }

    //创建结果
    List<List<String>> result = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTracking(chessboard, 0, n);
        return result;
    }

    public void backTracking(char[][] chessboard, int row, int n) {
        //终止 收集棋盘
        if (row == n) {
            result.add(Array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; ++i) {
            //如果当前位置合法 放下皇后 继续
            if (isValid(row, i, n, chessboard)) {
                chessboard[row][i] = 'Q';
                backTracking(chessboard, row + 1, n);
                chessboard[row][i] = '.';
            }
        }

    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        //把搜集来的棋盘转化为List<String>
        for (char[] chars : chessboard) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        //row col 为皇后坐标 放下后往上检查
        //检查列
        for (int i = 0; i < col; ++i) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        //右上对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        //左上对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
