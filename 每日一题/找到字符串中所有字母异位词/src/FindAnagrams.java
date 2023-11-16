import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        //滑动窗口+数组计数

        //用于统计字符出现的次数
        int[] s1 = new int[26];
        int[] p1 = new int[26];

        //统计p的字符出现次数
        for (int i = 0; i < p.length(); i++) {
            p1[p.charAt(i) - 'a']++;
        }

        //结果
        List<Integer> res = new ArrayList<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            //r先移动 形成窗口
            s1[s.charAt(r) - 'a']++;
            //如果窗口长度大于字符串 那么统计-- 同时l++
            if (r - l + 1 > p.length()) {
                s1[s.charAt(l++) - 'a']--;
            }
            if (r - l + 1 == p.length()) {
                //判断记录数组中的数据是否相等 相等就记录起始索引
                if (isSame(s1, p1)) {
                    res.add(l);
                }

            }
        }
        return res;
    }

    public boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
