import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //创建set 用于判断字典的单词在不在字符串中
        Set<String> set = new HashSet<>(wordDict);
        //dp[i] ：长度为i的字符串 是否能被拆分
        //创建dp数组
        boolean[] dp = new boolean[s.length() + 1];
        //初始化数组
        dp[0] = true;
        //单词是有顺序的 我们求的是排列 i = 1 非空字符串
        for (int i = 1; i <= s.length(); i++) {  //背包
            for (int j = 0; j < i; j++) { //物品
                //如果在单词区间中 并且前面都符合 我们才取
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
