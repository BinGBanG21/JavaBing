import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {

    }

    //创建结果
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //用于树层去重的used数组
        int[] used = new int[candidates.length];
        //对数组进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0, used);
        return result;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIndex, int[] used) {
        //终止条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        //单层递归 + 树层去重
        for (int i = startIndex; i < candidates.length; i++) {
            //如果和比目标值大 那么return
            //used[i - 1] == 0 : 表示是在数层去重
            if (i > 0 && candidates[i - 1] == candidates[i] && used[i - 1] == 0) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = 1;
            backTracking(candidates, target, sum, i + 1, used);
            //回溯
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
