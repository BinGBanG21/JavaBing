import java.util.HashMap;

public class NoRepeatString {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        //定义最大不重复的长度
        int maxLen = 0;
        int len = s.length();
        //创建map 保存字符
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < len; right++) {
            //拿到字符串中当前字符
            char c = s.charAt(right);
            if (map.containsKey(right)) {
                //如果map存在 重置left的值
                left = Math.max(map.get(c), left);
            }
            //把right指针的值放入map 同时更新最大值
            map.put(c, right + 1);
            maxLen = Math.max((right - left + 1), maxLen);
        }
        return maxLen;
    }
}
