import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

    public static void main(String[] args) {

    }

    //结果
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //因为求得是排列 我们循环是从0开始 所以使用used标记哪个元素用过了
        int[] used = new int[nums.length];
        //对数组进行排序 方便树层去重
        Arrays.sort(nums);
        backTracking(nums, used);
        return result;

    }

    public void backTracking(int[] nums, int[] used) {
        //叶子节点收取结果
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //求的是排列 不需要startIndex
        for (int i = 0; i < nums.length; i++) {
            //树层去重
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 0) {
                continue;
            }
            //证明该元素我们还没用使用过
            if (used[i] == 0) {
                path.add(nums[i]);
                used[i] = 1;
                backTracking(nums, used);
                path.remove(path.size() - 1);
                used[i] = 0;
            }
        }
    }
}
