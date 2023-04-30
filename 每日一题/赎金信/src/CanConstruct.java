public class CanConstruct {
    public static void main(String[] args) {

    }

//    public boolean canConstruct(String ransomNote, String magazine) {
//        int[] record = new int[26];
//        for (char c : magazine.toCharArray()) {
//            record[c - 'a'] += 1;
//        }
//        for (char c : ransomNote.toCharArray()) {
//            record[c - 'a'] -= 1;
//        }
//        for (int i : record) {
//            //注意：可以存在负数
//            if (i < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean canConstruct(String ransomNote, String magazine){
        //哈希表 因为是26个字母 用数组即可
        int[] record = new int[26];
        //循环ransoNote 记录字母情况
        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i) - 'a'] += 1;
        }
        //循环杂志
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a'] -= 1;
        }
        //根据题意 赎金字母是杂志的子集
        for (int i = 0; i < record.length; i++) {
            if(record[i] > 0){
                return false;
            }
        }
        return true;
    }
}
