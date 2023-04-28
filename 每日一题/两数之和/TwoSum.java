/*
    1. 两数之和
        给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        你可以按任意顺序返回答案。

* */

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5};
        int[] result = twoSum1(arr,9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

//    public static int[] twoSum1(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                result[0] = i;
//                result[1] = map.get(target - nums[i]);
//            }
//            //把遍历过的值加入到数组中 方便查找是否存在
//            map.put(nums[i], i);
//        }
//        return result;
//    }
    public int[] twoSum1(int[] nums, int target){
        //结果数组
        int[] res = new int[2];
        //边界处理
        if(nums == null || nums.length == 0){
            return res;
        }
        //创建用于记录的map 存放值和值的下标
        Map<Integer,Integer> map = new HashMap<>();
        //遍历元素
        for (int i = 0; i < nums.length; i++) {
            int temp = target -nums[i];
            //如果存在 返回结果 不存在就加入map集合
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
