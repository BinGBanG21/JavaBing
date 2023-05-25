import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {

    }
//    List<List<Integer>> res = new ArrayList<>(); //结果
//    LinkedList<Integer> path = new LinkedList(); //过程中收集的结果 也是路径
//    boolean[] used;
//
//    public List<List<Integer>> permute(int[] nums) {
//        if (nums.length == 0) {
//            return res;
//        }
//        used = new boolean[nums.length];
//        permuteHelper(nums);
//        return res;
//
//    }
//
//    public void permuteHelper(int[] nums) {
//        //退出条件
//        if (path.size() == nums.length) {
//            //收集结果
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i] == true) {
//                continue;
//            }
//            //如果没取过加入结果集 并把当前索引设置为true
//            used[i] = true;
//            path.add(nums[i]);
//            permuteHelper(nums);
//            //回退
//            path.removeLast();
//            used[i] = false;
//
//        }
//    }

    //创建结果
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        //排列可以重复 used数组标记每次取了哪个值
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return result;
    }

    public void backTracking(int[] nums, int[] used) {
        //叶子节点收集结果
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) { //排列 取过的元素还可以取
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
