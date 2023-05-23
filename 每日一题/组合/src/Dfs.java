import java.util.ArrayList;
import java.util.List;

public class Dfs {
    public static void main(String[] args) {

    }

    //    List<Integer> temp = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> combine(int n, int k) {
//        dfs(1, n, k);
//        return ans;
//    }
//
//    public void dfs(int cur, int n, int k) {
//        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
//        if (temp.size() + (n - cur + 1) < k) {
//            return;
//        }
//        // 记录合法的答案
//        if (temp.size() == k) {
//            ans.add(new ArrayList<Integer>(temp));
//            return;
//        }
//        // 考虑选择当前位置
//        temp.add(cur);
//        dfs(cur + 1, n, k);
//        temp.remove(temp.size() - 1);
//        // 考虑不选择当前位置
//        dfs(cur + 1, n, k);
//    }
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //存放路径
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k > n) {
            return result;
        }
        backTracking(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex) { // startIndex 决定从哪个位置开始搜
        //终止条件
        if (path.size() == k) {
            //收集结果
            result.add(new ArrayList(path));
            return;
        }
        //递进条件
        for (int i = startIndex; i <= n; i++) { // 从当前位置开始 去找n个元素 优化 i <= n - (k -path.size()) +1
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
