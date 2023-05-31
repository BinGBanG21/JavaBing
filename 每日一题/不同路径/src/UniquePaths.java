public class UniquePaths {
    public static void main(String[] args) {

    }

    //    public int uniquePaths(int m, int n) {
//        int[][] path = new int[m][n];
//        //设置初始值 起始点设为 0 0
//        for(int i = 0 ; i < m; ++i){
//            path[i][0] = 1;
//        }
//        for(int j = 0; j < n; ++j){
//            path[0][j] = 1;
//        }
//        //递推公式 dp[i][j] = dp[i - 1][j] + dp[i][j-1]
//        for(int i = 1; i < m; ++i){
//            for(int j = 1; j < n; ++j){
//                path[i][j] = path[i - 1][j] + path[i][j - 1];
//            }
//        }
//        // 0,0 一种走法  m,n m-1 n-1 种走法
//        return path[m-1][n-1];
//    }
    public int uniquePaths(int m, int n) {
        //初始化地图 也就是我们的dp数组
        int[][] path = new int[m][n];
        //为地图赋坐标 m n 为终止条件
        //++i 是出发点为 0,0 站在起点出发
        //赋值 也就是长宽中的宽
        for (int i = 0; i < m; ++i) {
            path[i][0] = 1;
        }
        //长 长和宽为什么初始化为1呢 是因为长宽只有1种走法
        for (int j = 0; j < n; ++j) {
            path[0][j] = 1;
        }
        //dp[i][j]：表示到达当前位置有多少种走法
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                path[i][j] = path[i][j - 1] + path[i - 1][j];
            }
        }
        //返回动规数组的最后一个值
        return path[m - 1][n - 1];
    }
}
