public class ReverseLeftWords {
    public static void main(String[] args) {

    }

    //     public String reverseLeftWords(String s, int n) {
//        StringBuilder sb = new StringBuilder(s);
//        //反转前半段字符串
//        reverseString(sb, 0, n - 1);
//        //反转后半段字符串
//        reverseString(sb, n, s.length() - 1);
//        //反转整个字符串
//        return sb.reverse().toString();
//    }
//
//    public void reverseString(StringBuilder sb, int start, int end) {
//        //双指针交换 反转字符串
//        while (start < end) {
//            char temp = sb.charAt(start);
//            sb.setCharAt(start, sb.charAt(end));
//            sb.setCharAt(end, temp);
//            start++;
//            end--;
//        }
//    }
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        //思路 先反转 0 - n 字符
        //然后再反转n 到 length - 1
        //然后再把整个字符串反转 由于上面已经反转过一次
        //就导致好像把整个字符分成了两个部分 然后旋转一样
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, s.length() - 1);
        reverseString(sb, 0, s.length() - 1);
        return new String(sb);

    }

    //用于反转的函数
    public void reverseString(StringBuilder sb, int start, int end) {
        //循环交换 不需要<= 因为<不动 恰好完成
        while (start < end) {
            char temp = sb.charAt(end);
            sb.setCharAt(end, sb.charAt(start));
            sb.setCharAt(start, temp);
            start++;
            end--;
        }
    }
}
