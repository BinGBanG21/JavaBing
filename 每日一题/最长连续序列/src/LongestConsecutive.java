import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        //把当前数组存到set集合中
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        //记录最长连续序列
        int longStreak = 0;

        //循环数组 假设num - 1在数组中出现过 那么它就不可能是最长的连续序列
        for (int i = 0; i < nums.length; i++) {
            //如果不存在 证明有可能是最长的连续序列
            //那么已该元素为起点 一直向后找 同时更新最大长度
            if (!set.contains(nums[i] - 1)) {
                int currentNum = nums[i];
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longStreak = Math.max(longStreak, currentStreak);
            }
        }
        return longStreak;
    }
}
