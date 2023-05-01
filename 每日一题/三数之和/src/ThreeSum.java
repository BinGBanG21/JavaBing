import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
    }

    //    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList();
//        //首先对数组的长度处理
//        if (nums.length < 3 || nums == null) {
//            return list;
//        }
//        //很重要的一点 对数组进行排序
//        Arrays.sort(nums);
//        //三个指针 一个指向当前遍历的元素 一个指向该元素后面数字组合成的数组的两端 left right
//        for (int i = 0; i < nums.length; i++) {
//            //如果三数之和>0 那说明打了 right--
//            //如果三数之和>0 那说明打了 right--
//            //如果当前数大于0 那么和肯定大于0 结束循环
//            if (nums[i] > 0) {
//                break;
//            }
//            //对数组元素进行去重操作 关键就是发现i和i+1相等 那么continue
//            //从第二个元素开始
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//                //大于0 right--
//                if (sum > 0) {
//                    right--;
//                }
//                //小于0 left++
//                if (sum < 0) {
//                    left++;
//                }
//                //等于0的话 加入结果集合 并且对结果集去重 其实就是对left和right去重
//                if (sum == 0) {
//                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    //对当前i后面的left和right去重
//                    while (left < right && nums[left] == nums[left + 1]) {
//                        left++;
//                    }
//                    while (left < right && nums[right] == nums[right - 1]) {
//                        right--;
//                    }
//                    //一直找到不相等的 然后++
//                    left++;
//                    right--;
//                }
//            }
//        }
//        return list;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        //创建结果
        List<List<Integer>> result = new ArrayList<>();
        //对数组进行排序
        Arrays.sort(nums);
        //题目中要求找出a + b + c = 0;
        //排序后采用双指针
        for (int i = 0; i < nums.length; i++) {
            //排序后第一个数都>0 证明没有负数 结果肯定不为0
            if (nums[i] > 0) {
                return result;
            }
            //定义指针
            int left = i + 1;
            int right = nums.length - 1;
            //对a进行去重 要使用i - 1 如果使用i + 1 则为答案中的值去重 不对
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            //循环计算结果处理
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {  // =0 记录数值
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //得到正确结果后 再对bc去重 注意终止条件
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //如果没有重复的b c 那么指针也要移动
                    left++;
                    right--;
                }

            }
        }
        return result;
    }
}
