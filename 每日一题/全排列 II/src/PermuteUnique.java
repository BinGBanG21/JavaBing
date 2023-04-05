import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //创建used数组
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;

    }

    public void backTrack(int nums[], boolean[] used) {
        //终止条件 path的长度和给定数组长度相等
        if (path.size() == nums.length) {
            //收集结果
            result.add(new ArrayList<>(path));
            return;
        }
        //递进条件 循环
        for (int i = 0; i < nums.length; i++) {
            //对数层进行剪枝
            // i > 0 防止i-1 < 0  i-1 = i 说明重复 跳过
            //i-1 == false 说明我们在做树层的去重 因为树层有回溯
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            //树枝进行操作
            //如果当前值没有处理过 那么处理
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                //进行递归 处理后面的值
                backTrack(nums, used);
                //处理完后 回溯 弹出 进行下一个
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }
}
