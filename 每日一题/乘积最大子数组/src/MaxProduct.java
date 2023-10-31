public class MaxProduct {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        //假如数组中全是正数 那么乘积最大值肯定为所有值相乘
        //如果遇到正数 那么此时就需要一个最小值 这样最小值和负数相乘 才能最大
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                //交换最大值和最小值
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //对比出最大值 保存最小值
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(imax, max);
        }
        return max;
    }
}
