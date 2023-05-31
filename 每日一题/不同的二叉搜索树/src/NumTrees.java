public class NumTrees {
    public static void main(String[] args) {

    }

    //    public int numTrees(int n) {
//        int[] G = new int[n + 1];
//        G[0] = 1;
//        G[1] = 1;
//
//        for (int i = 2; i <= n; ++i) {
//            for (int j = 1; j <= i; ++j) {
//                G[i] += G[j - 1] * G[i - j];
//            }
//        }
//        return G[n];
//    }
    public int numTrees(int n) {
        //为了取到dp[n]
        int[] dp = new int[n + 1];
        //dp[i] 表示i个节点不同的二叉树总和
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //状态转移方程
                //左边节点的不同子树 1-j * 右边节点的不同子树 j- i
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
