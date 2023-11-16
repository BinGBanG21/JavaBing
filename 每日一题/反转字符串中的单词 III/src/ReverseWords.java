public class ReverseWords {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        //我们只关心空格和最后一个索引
        //开始记录单词的起始位置 如果遇到空格或者最后一个 翻转 然后重置start索引
        char[] array = s.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1;
                continue;
            }
            if (i == array.length - 1) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }

    public void reverse(char[] array, int l, int r) {
        while (l < r) {
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }
}
