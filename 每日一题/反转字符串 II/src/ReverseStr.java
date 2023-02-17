public class ReverseStr {
    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            //看尾数够不够k个 来决定end的索引
            int start = i;
            int end = Math.min(ch.length - 1, start + k - 1);
            while (start < end) {
                char c = ch[start];
                ch[start] = ch[end];
                ch[end] = c;

                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
