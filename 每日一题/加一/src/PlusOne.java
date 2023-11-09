public class PlusOne {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        //倒序遍历 9变0 前一位+1
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        //如果走到这里证明全是9
        int[] ans = new int[len + 1];
        ans[0] = 1;
        return ans;
    }
}
