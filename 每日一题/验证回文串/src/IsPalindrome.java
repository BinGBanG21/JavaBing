public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        //双指针
        int n = s.length();
        int left = 0, right = n - 1;
        //循环比较 如果不是数字就跳过 知道数字 然后比较
        //如果两指针相遇 证明是回文串
        while (left < right) {
            //找到有效字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //开始比较
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                //继续移动指针
                left++;
                right--;
            }
        }
        return true;
    }
}
