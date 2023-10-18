public class ProductExceptSelf {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        //创建answer数组 存放前缀之积
        int len = nums.length;
        int[] ans = new int[len];
        //第一位前缀没有数 值为1
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int R = 1;
        //先求结果 然后再保存后缀之积
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}
