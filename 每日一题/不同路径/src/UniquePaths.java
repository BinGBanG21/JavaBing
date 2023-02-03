public class UniquePaths {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        //设置初始值 起始点设为 0 0
        for(int i = 0 ; i < m; ++i){
            path[i][0] = 1;
        }
        for(int j = 0; j < n; ++j){
            path[0][j] = 1;
        }
        //递推公式 dp[i][j] = dp[i - 1][j] + dp[i][j-1]
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        // 0,0 一种走法  m,n m-1 n-1 种走法
        return path[m-1][n-1];
    }
}
