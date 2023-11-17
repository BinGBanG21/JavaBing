import java.awt.color.CMMException;
import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        //滑动窗口 + 双指针遍历
        //创建两个HashMap 用于检查两个字符串中字母出现的种类和数量
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();

        //记录t到ht中
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";

        //cnt为字符串中字母的种类数
        int len = Integer.MAX_VALUE;
        int cnt = 0;

        //滑动窗口
        for (int left = 0, right = 0; right < s.length(); right++) {
            //统计当前窗口中的字符数量和类型
            hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0) + 1);
            //分情况判断 如果包含当前字符 就看数量
            if (ht.containsKey(s.charAt(right))) {
                //如果小于ht中的字符数量 那么就是必须的
                if (hs.get(s.charAt(right)) <= ht.get(s.charAt(right))) {
                    //该字符数量++
                    cnt++;
                }
            }
            //如果ht中根本没有当前字符 那么说明这个字符不被需要
            //或者该字符的数量比ht需要的大
            //那么我们就要重新找窗口
            //收缩left 新窗口
            while (left < right && (!ht.containsKey(s.charAt(left)) ||
                    hs.get(s.charAt(left)) > ht.get(s.charAt(left)))) {
                //更新窗口中该字符的数量 然后left++
                hs.put(s.charAt(left), hs.get(s.charAt(left)) - 1);
                left++;
            }

            //如果上述情况我们都满足 说明找到了一个答案
            if (cnt == t.length() && right - left + 1 < len) {
                len = right - left + 1;
                ans = s.substring(left, right + 1);
            }
        }
        return ans;
    }
}
