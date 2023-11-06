import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        //最长公共前缀 公共就是对所有字符串而言 那么先对字符串排序 找最长最短的字符串公共前缀即可
        if (strs.length == 0) {
            return "";
        }
        //排序
        Arrays.sort(strs);
        String s = strs[0];
        String l = strs[strs.length - 1];

        int num = Math.min(s.length(), l.length());
        int i;
        for (i = 0; i < num && s.charAt(i) == l.charAt(i); i++) {}
        String ans = s.substring(0, i);
        return ans;
    }
}
