public class FirstMissingPositive {
    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //如果当前的数字没有在对应的位置上
            //对应位置：索引0 -> 1
            //如果这个数字超出范围 那么不必理会
            //索引为i的当前值  : num[i]
            //该值应在的正确位置  : nums[num[i] - 1]
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //把位置上的值存起来
                int temp = nums[nums[i] - 1];
                //把num[i]放过去
                nums[nums[i] - 1] = nums[i];
                //拿到这个不对的值继续循环比较
                nums[i] = temp;
            }
        }
        //检查各个位置的索引和值是否对应
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //找没出现的最小的正整数 例如：1-7 7个都存在 那么这么数是8
        return n + 1;
    }
}
