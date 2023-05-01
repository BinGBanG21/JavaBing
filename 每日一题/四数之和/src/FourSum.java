import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    //    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        //对数组进行排序
//        Arrays.sort(nums);
//
//        //和三数之和一样
//        for (int i = 0; i < nums.length; i++) {
//            //对i进行剪枝操作 排除负数的情况
//            if (nums[i] > 0 && nums[i] > target) {
//                return result;
//            }
//            //去重 i的左边是下一个数 所以要用i- 1进去重 不能使用i + 1
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            //取j
//            for (int j = i + 1; j < nums.length; j++) {
//                //对j去重 因为是排序过的 j在i后面 所以不需要判断和target的关系
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
//                //和三数之和差不多的逻辑处理
//                int left = j + 1;
//                int right = nums.length - 1;
//                //双指针循环的条件
//                while (left < right) {
//                    //对四数之和做处理 防止溢出
//                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
//                    //说明大了 那么right--
//                    if (sum > target) {
//                        right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        //上面是对i j去重 下面对left right去重
//                        while (left < right && nums[left] == nums[left + 1]) {
//                            left++;
//                        }
//                        while (left < right && nums[right] == nums[right - 1]) {
//                            right--;
//                        }
//                        //然后指针都移动
//                        left++;
//                        right--;
//                    }
//                }
//            }
//        }
//        return result;
//    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //沿用三数之和的思路
        //创建结果的二维数组
        List<List<Integer>> result = new ArrayList<>();
        //双重for循环
        //对数组排序
        Arrays.sort(nums);
        //a + b + c + d = target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            //对a做剪纸操作 需要注意的是可能包含负数
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //对b做剪纸操作
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                //初始化指针
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else { //=target
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //找到结果后 再对cd做剪纸操作
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //没有相同数值 指针也要走
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
