public class MaxProfit {
    public static void main(String[] args) {

    }

    //    public int maxProfit(int[] prices) {
//        int ans = 0;
//        int n = prices.length;
//        for (int i = 1; i < n; ++i) {
//            ans += Math.max(0, prices[i] - prices[i - 1]);
//        }
//        return ans;
//    }
    //从第二天开始循环 正数就就记录
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            maxPro += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxPro;
    }
}
