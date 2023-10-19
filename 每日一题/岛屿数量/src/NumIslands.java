public class NumIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        //对数组合法性做判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //创建结果
        int numIslands = 0;
        //把每一个点当作起点 循环
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //找到岛屿1 就开始同化 同时结果+1
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int row, int col) {
        int r = grid.length;
        int c = grid[0].length;

        //对当前输入位置的合法性进行判断(数组下标的越界判断)
        //如果当前不是陆地1 那么也直接返回
        if (row < 0 || row >= r || col < 0 || col >= c || grid[row][col] == '0') {
            return;
        }
        //找到一个岛屿后同化
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
