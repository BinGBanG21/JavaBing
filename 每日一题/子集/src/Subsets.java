import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    //    List<List<Integer>> result = new ArrayList<>(); //存放结果的集合
//    LinkedList<Integer> path = new LinkedList<>();  //收集结果
//    public static void main(String[] args) {
//
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        subsetsHelper(nums,0);
//        return result;
//    }
//    public void subsetsHelper(int[] nums, int startIndex){
//        //记录每次的结果
//        result.add(new ArrayList<>(path));
//        for(int i = startIndex; i < nums.length; i++){
//            path.add(nums[i]);
//            subsetsHelper(nums,i+1);
//            path.removeLast();
//        }
//    }
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
