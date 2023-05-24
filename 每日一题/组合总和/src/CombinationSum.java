import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {


    }

    //    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        //新建一个二维数组 保存答案
//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(candidates);
//        backtracking(candidates,ans,new ArrayList<>(),0,0,target);
//        return ans;
//    }
//    public void backtracking( int[] candidates, List<List<Integer>> ans,List<Integer> path, int sum, int startIndex,int target){
//        //终止条件
//        if(sum == target){
//            //收集路径 return
//            ans.add(new ArrayList<>(path));
//            return;
//        }
//        //递进逻辑
//        for(int i = startIndex; i < candidates.length; i++ ){
//            //排序后 如果当前的值比target大 那么跳过本次循环
//            if(sum + candidates[i] > target){
//                break;
//            }
//            //否则递进
//            path.add(candidates[i]);
//            backtracking(candidates,ans,path,sum + candidates[i],i,target);
//            //如果不满足条件 那么吐出本次值 回溯
//            path.remove(path.size() - 1);
//        }
//    }
    //剪枝优化
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //创建结果
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        //对数组进行排序 剪枝
        Arrays.sort(candidates);
        int sum = 0;
        backTracking(candidates, target, 0, 0, result, path);
        return result;
    }


    public void backTracking(int[] candidates, int target, int sum, int startIndex, List<List<Integer>> result, LinkedList<Integer> path) {
        //终止条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        //单层递归的逻辑
        //循环中的i++ 控制树的宽度 往后取值
        //startIndex: 递归节点的宽度 还是i 不变 为了重复取值
        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, sum, i, result, path);
            //回溯
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}



