public class IsAnagram {
    public static void main(String[] args) {

    }

//    public boolean isAnagram(String s, String t) {
//        int[] hash = new int[26];
//        //循环字符串赋值
//        for (int i = 0; i < s.length(); i++) {
//            hash[s.charAt(i) - 'a']++;
//        }
//        //循环给定字符串 进行-- 操作
//        for (int j = 0; j < t.length(); j++) {
//            hash[t.charAt(j) - 'a']--;
//        }
//        //查看当前数组中是否有0
//        for (int k = 0; k < hash.length; k++) {
//            if (hash[k] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isAnagram(String s, String t){
        //使用哈希表进行查询记录 比较快 数组也是哈希表的一种
        int[] record = new int[26];
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        //记录字母出现的次数
        for (int i =0; i < chars.length;i++){
            record[chars[i] - 'a'] += 1;
        }
        //消掉字母出现的次数
        for (int j = 0; j <chars1.length ; j++) {
            record[chars1[j] - 'a'] -= 1;
        }
        for (int k = 0; k < record.length; k++) {
            if(record[k] != 0){
                return false;
            }
        }
        return true;
    }
}
