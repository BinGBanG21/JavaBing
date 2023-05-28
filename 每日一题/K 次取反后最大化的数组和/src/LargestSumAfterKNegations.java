import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestSumAfterKNegations {
    public static void main(String[] args) {

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        //思路 先将数组按照绝对值大小从大到小排列
        nums = IntStream.of(nums).
                boxed().
                sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        //然后从前向后循环数组 翻转负数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        //假如k还有剩余 偶数的话我们反转在反转就消掉了 所以只剩下1次 我们反转最小值
        if (k % 2 == 1) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
