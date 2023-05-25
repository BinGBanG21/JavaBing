import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    //    List<Integer> t = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//    public static void main(String[] args) {
//
//    }
//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        dfs(false, 0, nums);
//        return ans;
//    }
//
//    public void dfs(boolean choosePre, int cur, int[] nums) {
//        if (cur == nums.length) {
//            ans.add(new ArrayList<Integer>(t));
//            return;
//        }
//        dfs(false, cur + 1, nums);
//        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
//            return;
//        }
//        t.add(nums[cur]);
//        dfs(true, cur + 1, nums);
//        t.remove(t.size() - 1);
//    }
    //创建结果
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //参数处理 空数组
        if (nums.length == 0) {
            result.add(new ArrayList<>(path));
            return result;
        }
        //对数组进行排序 方便去重
        Arrays.sort(nums);
        //used数组 辅助去重 使用过为1
        int[] used = new int[nums.length];
        backTracking(nums, 0, used);
        return result;
    }

    public void backTracking(int[] nums, int startIndex, int[] used) {
        //先收集结果 举例  加入startIndex == length 那么结果也是合理的 也要收集 然后return
        result.add(new ArrayList<>(path));
        //终止条件 如果startIndex指到最后表示递归完成
        if (startIndex == nums.length) {
            return;
        }
        //单层递归
        for (int i = startIndex; i < nums.length; i++) {
            //剪枝
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 0) {
                continue;
            } else {
                path.add(nums[i]);
                used[i] = 1;
                backTracking(nums, i + 1, used);
                //回溯
                path.removeLast();
                used[i] = 0;
            }

        }

    }
}
