public class FindMaxForm {
    public static void main(String[] args) {

    }

    //    public int findMaxForm(String[] strs, int m, int n) {
//        int[][] dp = new int[m + 1][n + 1];
//        int length = strs.length;
//        for (int i = 0; i < length; i++) {
//            int[] zerosOnes = getZerosOnes(strs[i]);
//            int zeros = zerosOnes[0], ones = zerosOnes[1];
//            for (int j = m; j >= zeros; j--) {
//                for (int k = n; k >= ones; k--) {
//                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
//                }
//            }
//        }
//        return dp[m][n];
//    }
//
//    public int[] getZerosOnes(String str) {
//        int[] zerosOnes = new int[2];
//        int length = str.length();
//        for (int i = 0; i < length; i++) {
//            zerosOnes[str.charAt(i) - '0']++;
//        }
//        return zerosOnes;
//    }
    public int findMaxForm(String[] strs, int m, int n) {
        //初始化dp数组 dp[i][j] 为装i个0 j个1的价值 也就是元素个数
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroSum = 0;
            int oneSum = 0;
            //计算 01 个数
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroSum++;
                } else {
                    oneSum++;
                }
            }
            //遍历背包
            for (int i = m; i >= zeroSum; i--) {
                for (int j = n; j >= oneSum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroSum][j - oneSum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

