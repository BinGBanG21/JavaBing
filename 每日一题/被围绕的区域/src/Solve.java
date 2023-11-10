public class Solve {
    public static void main(String[] args) {

    }

    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;

        //从四个边出发 寻找在边上的'O' 找到后 和边上的'O'相连接的o 也不属于被包围 都要打上标记
        //然后遍历数组 把打标记的改为X

        //左右两边
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        //上下两边
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        //遍历 修改A为X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //不是被包围的 改成O
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {  //被包围 改成X
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        //边界处理
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        //标记 然后继续找下去
        board[x][y] = 'A';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }
}
