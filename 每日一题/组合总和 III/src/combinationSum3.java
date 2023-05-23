import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {

    }

//    public List<List<Integer>> combinationSum3(int k, int n) {
//        dfs(1, 9, k, n);
//        return ans;
//    }
//
//    public void dfs(int cur, int n, int k, int sum) {
//        if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
//            return;
//        }
//        if (temp.size() == k) {
//            int tempSum = 0;
//            for (int num : temp) {
//                tempSum += num;
//            }
//            if (tempSum == sum) {
//                ans.add(new ArrayList<Integer>(temp));
//                return;
//            }
//        }
//        temp.add(cur);
//        dfs(cur + 1, n, k, sum);
//        temp.remove(temp.size() - 1);
//        dfs(cur + 1, n, k, sum);
//    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        backTracking(k, n, 0, 1);
        return result;
    }

    //对元素个数和path的和做一个剪枝
    public void backTracking(int k, int target, int sum, int startIndex) {
        //对已取元素和的剪枝
        if (sum > target) {
            return;
        }
        //终止条件
        if (path.size() == k) {
            //收集结果
            if (target == sum) {
                result.add(new ArrayList<>(path));
                return;
            }

        }
        //递归代替循环
        //对元素个数剪枝
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backTracking(k, target, sum, i + 1);
            //回溯
            sum -= i;
            path.removeLast();
        }
    }

}
