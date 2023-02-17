public class CanConstruct {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            //注意：可以存在负数
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
