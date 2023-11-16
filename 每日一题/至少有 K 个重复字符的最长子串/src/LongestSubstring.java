public class LongestSubstring {
    public static void main(String[] args) {

    }

    public int longestSubstring(String s, int k) {
        //分治
        //统计字符串中各个字符出现的个数 然后找出<k的拿个字符 进行分割
        //对分割出来的字串进行同样的递归处理
        int n = s.length();

        //特殊情况处理
        if (k == 1) {
            return n;
        }
        if (k > n) {
            return 0;
        }
        //统计字符串中各个字符出现的次数
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        //找出最小值
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                int res = 0;
                char ch = (char) (i + 'a');
                //用该字符将字符串分割成几个部分
                for (String ss : s.split(String.valueOf(ch))) {
                    //对每个部分递归处理
                    res = Math.max(res, longestSubstring(ss, k));
                }
                return res;
            }
        }
        //整个循环跑完都没找到说明每个字符出现次数都>k
        return n;
    }
}
