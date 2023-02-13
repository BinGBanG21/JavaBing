public class IsAnagram {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        //循环字符串赋值
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        //循环给定字符串 进行-- 操作
        for (int j = 0; j < t.length(); j++) {
            hash[t.charAt(j) - 'a']--;
        }
        //查看当前数组中是否有0
        for (int k = 0; k < hash.length; k++) {
            if (hash[k] != 0) {
                return false;
            }
        }
        return true;
    }
}
