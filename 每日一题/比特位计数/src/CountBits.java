public class CountBits {
    public static void main(String[] args) {

    }
    public int[] countBits(int n) {
        //通过1-10的数字找规律我们发现 0-0 1-1 奇数是偶数的数字+1 偶数是/2
        int[] dp = new int[n+1];
        for(int i =0; i < dp.length; i++){
            if(i % 2 == 1){
                dp[i] = dp[i-1] +1;
            }
            if(i % 2 ==0){
                dp[i] = dp[i/2];
            }
        }
        return dp;
    }
}
