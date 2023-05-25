import java.util.*;

public class FindSubsequences {
    public static void main(String[] args) {

    }

    //创建结果
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex) {
        //如果path.size() > 1 我们就收获结果 结果要先收集 因为是各个几点 不是叶子节点
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        //定义树层去重使用的set
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //树枝树层去重 如果取当前值导致不是递增或者树层重复 那么continue
            if ((path.size() != 0 && nums[i] < path.getLast()) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            //回溯 set是局部变量 每次重新生成 不需要回溯
            path.remove(path.size() - 1);
        }
    }
}
