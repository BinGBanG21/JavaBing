public class LongestValidParentheses {
    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        //从左向右遍历的话 (() 会判断不出来 所以要从右向左遍历
        //重置指针
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;
    }
}
