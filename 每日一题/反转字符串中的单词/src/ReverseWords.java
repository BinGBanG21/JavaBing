public class ReverseWords {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        //1.快慢指针 去除空格
        int slow = 0;
        for (int fast = 0; fast < ch.length; fast++) {
            if (ch[fast] != ' ') {
                //如果不是空格 直接赋值 然后slow也跟着上面的循环++
                ch[slow++] = ch[fast];
            } else {
                //如果是空格 并且前一位不是空格 那么书写空格 并且快慢指针都向后移动
                if (slow != 0 && ch[slow - 1] != ' ') {
                    ch[slow++] = ' ';
                }
            }
        }
        //结尾空格处理
        if (ch[slow - 1] == ' ') {
            slow--;
        }
        //2.字符反转
        change(ch, 0, slow - 1);

        //3.单词反转
        int left = 0;
        for (int i = 0; i < slow; i++) {
            //遇到空格 表示一个完整单词 反转
            if (ch[i] == ' ') {
                change(ch, left, i - 1);
                //left重置为空格后
                left = i + 1;
                //处理最后一个单词
            } else if (i == slow - 1) {
                change(ch, left, i);
            }
        }
        return new String(ch, 0, slow);

    }

    public void change(char[] ch, int left, int right) {
        //双指针反转
        while (left <= right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
}
