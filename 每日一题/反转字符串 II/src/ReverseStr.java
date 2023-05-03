public class ReverseStr {
    public static void main(String[] args) {

    }

//    public String reverseStr(String s, int k) {
//        char[] ch = s.toCharArray();
//        for (int i = 0; i < ch.length; i += 2 * k) {
//            //看尾数够不够k个 来决定end的索引
//            int start = i;
//            int end = Math.min(ch.length - 1, start + k - 1);
//            while (start < end) {
//                char c = ch[start];
//                ch[start] = ch[end];
//                ch[end] = c;
//
//                start++;
//                end--;
//            }
//        }
//        return new String(ch);
//    }
    public String reverseStr(String s, int k){
        //得到字符数组
        char[] ch = s.toCharArray();
        //根据题意反转 其实就是循环的时候2k递增 然后反转的end索引根据最后是否>=k决定
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length - 1,start + k - 1);
            //然后开始反转目标区域的字符串 知道start >= end
            //尾数如果不够k个 那么start = end 则循环不执行
            while(start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
