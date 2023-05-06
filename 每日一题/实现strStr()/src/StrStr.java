public class StrStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        //对模式串做边界处理
        if (needle.length() == 0) {
            return 0;
        }
        //创建数组
        int[] next = new int[needle.length()];
        //得到next数组
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            //不相等就回退 相等就向后比较
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //比较完毕
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    //得到最长相等前后缀的数组
    public void getNext(int[] next, String s) {
        //j表示前缀  i表示后缀
        int j = 0;
        next[0] = 0;
        //找最长相等前后缀
        for (int i = 0; i < s.length(); i++) {
            //如果不相等 那么回退 如果相等 那么记录next数组 然后j后移
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            //j不断后退 如果和i相等 那么记录next数组
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
