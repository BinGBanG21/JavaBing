public class ReverseWords {
    public static void main(String[] args) {

    }

    //    public String reverseWords(String s) {
//        char[] ch = s.toCharArray();
//        //1.快慢指针 去除空格
//        int slow = 0;
//        for (int fast = 0; fast < ch.length; fast++) {
//            if (ch[fast] != ' ') {
//                //如果不是空格 直接赋值 然后slow也跟着上面的循环++
//                ch[slow++] = ch[fast];
//            } else {
//                //如果是空格 并且前一位不是空格 那么书写空格 并且快慢指针都向后移动
//                if (slow != 0 && ch[slow - 1] != ' ') {
//                    ch[slow++] = ' ';
//                }
//            }
//        }
//        //结尾空格处理
//        if (ch[slow - 1] == ' ') {
//            slow--;
//        }
//        //2.字符反转
//        change(ch, 0, slow - 1);
//
//        //3.单词反转
//        int left = 0;
//        for (int i = 0; i < slow; i++) {
//            //遇到空格 表示一个完整单词 反转
//            if (ch[i] == ' ') {
//                change(ch, left, i - 1);
//                //left重置为空格后
//                left = i + 1;
//                //处理最后一个单词
//            } else if (i == slow - 1) {
//                change(ch, left, i);
//            }
//        }
//        return new String(ch, 0, slow);
//
//    }
//
//    public void change(char[] ch, int left, int right) {
//        //双指针反转
//        while (left <= right) {
//            char temp = ch[left];
//            ch[left] = ch[right];
//            ch[right] = temp;
//            left++;
//            right--;
//        }
//    }
    public String reverseWords(String s) {
        //把字符串转成字符数组 方便操作
        char[] ch = s.toCharArray();
        //双指针 快指针找目标元素 慢指针从新给字符数组赋值
        int slow = 0;
        for (int fast = 0; fast < ch.length; fast++) {
            //如果不是空格 那么赋值
            if (ch[fast] != ' ') {
                ch[slow++] = ch[fast];
            } else { //如果是空格
                //1.看前一位是不是空格 如果是 证明连续空格 不做处理
                //2.如果不是 证明一个单词书写完毕 那么书写空格
                if (slow > 0 && ch[slow - 1] != ' ') {
                    ch[slow++] = ' ';
                }
            }
        }
        //处理结尾空格
        if (ch[slow - 1] == ' ') {
            slow--;
        }
        //先将整个字符串反转 然后反转单词
        reverse(ch, 0, slow - 1);
        int start = 0;
        for (int i = 0; i < slow; i++) {
            //找到了单词
            if (ch[i] == ' ') {
                reverse(ch, start, i - 1);
                start = i + 1;
            } else if (i == slow - 1) { //处理最后一个单词
                reverse(ch, start, slow - 1);
            }
        }
        return new String(ch,0,slow);
    }

    //反转函数
    public void reverse(char[] ch, int start, int end) {
        //双指针反转
        while (start <= end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            //移动指针
            start++;
            end--;
        }
    }
}
