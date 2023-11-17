import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        //排序+双指针
        Arrays.sort(nums);
        int n = nums.length;
        //最接近的值
        int best = 10000000;

        //枚举a 双指针 b c
        for (int i = 0; i < n; i++) {
            //排除重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针枚举b c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                //如果不相等 更新当前3索引的接近值
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                //拿到best的值 控制左右指针
                //如果sum > target 移动C指针
                if (sum > target) {
                    int kk = k - 1;
                    //去重
                    while (j < kk && nums[kk] == nums[k]) {
                        kk--;
                    }
                    k = kk;
                } else {
                    int jj = j + 1;
                    //去重
                    while (jj < k && nums[jj] == nums[j]) {
                        jj++;
                    }
                    j = jj;
                }
            }
        }
        return best;
    }
}
