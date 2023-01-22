public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        //中心扩散法 找到当前的中点 然后看左右字符串是否相等
        //动态规划其实就是优化了中心扩散法 把结果记录下来
        if(s == null || s.length() < 2){
            return s;
        }
        //初始化起点 终点 回文串的长度
        int len = s.length();
        int start = 0;
        int end = 0;
        int maxLen = 1;
        //初始化状态容器 返回布尔值
        boolean[][] dp = new boolean[len][len];
        //两种特殊情况 指针重合或者相等
        //重合了 说明本次 r-l 长度的字符串已经比较完毕了 l重置为开头 r++
        //如果相等 分奇数偶数 奇数的话 有长度要求 偶数的话 两个相邻相等 再中心扩散一下 看是不是还想等
        for(int r = 1; r < len; r++){
            for(int l = 0; l < r; l++){
                //如果两个字符相等 要分奇数相等还是偶数相等
                //如果奇数相等 那么索引是大于等于2 例如bab 可以 bacb 不行 所以字符串长度要求小于等于3
                //如果偶数相等 那么索引是轴对称
                if( s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])){
                    dp[l][r] = true;
                    //判断最大值 然后给长度和起始点赋值
                    if( r - l + 1 > maxLen){
                        maxLen = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start,end +1);
    }
}
