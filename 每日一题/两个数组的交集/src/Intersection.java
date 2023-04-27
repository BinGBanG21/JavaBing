import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {

    }

    //    public int[] intersection(int[] nums1, int[] nums2) {
//        //边界处理
//        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
//            return new int[0];
//        }
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> resSet = new HashSet<>();
//        //把第一个数组中的元素放入
//        for (int i : nums1) {
//            set.add(i);
//        }
//        for (int i : nums2) {
//            if (set.contains(i)) {
//                resSet.add(i);
//            }
//        }
//        //把resSet变成数组 返回
//        return resSet.stream().mapToInt(x -> x).toArray();
//    }
    public int[] intersection(int[] nums1, int[] nums2) {
        //边界处理
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //使用set 去重 并且查询
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        //将第一个数组加入到set中
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i)){
                resultSet.add(i);
            }
        }
        //将resultSet转化成数组
        return resultSet.stream().mapToInt( x -> x).toArray();
    }
}
