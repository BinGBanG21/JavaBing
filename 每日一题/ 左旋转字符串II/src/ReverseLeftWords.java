public class ReverseLeftWords {
    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        //反转前半段字符串
        reverseString(sb, 0, n - 1);
        //反转后半段字符串
        reverseString(sb, n, s.length() - 1);
        //反转整个字符串
        return sb.reverse().toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        //双指针交换 反转字符串
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
