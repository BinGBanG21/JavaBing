import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public static void main(String[] args) {

    }

    //    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        //数组两两处理
//        //n的四次方变成n的平方
//        Map<Integer, Integer> map = new HashMap<>();
//        int temp = 0;
//        int res = 0;
//        //第一组
//        for (int i : nums1) {
//            for (int j : nums2) {
//                temp = i + j;
//                if (map.containsKey(temp)) {
//                    map.put(temp, map.get(temp) + 1);
//                } else {
//                    map.put(temp, 1);
//                }
//            }
//        }
//        //第二组
//        for (int i : nums3) {
//            for (int j : nums4) {
//                temp = i + j;
//                if (map.containsKey(0 - temp)) {
//                    res += map.get(0 - temp);
//                }
//            }
//        }
//        return res;
//    }
    public int fourSumCount(int[] num1, int[] num2, int[] num3, int[] num4) {
        //把12数组的和求出来 利用map 加入
        Map<Integer, Integer> map = new HashMap<>();
        //临时变量
        int temp;
        //结果
        int res;
        //时间复杂度由n4 -> n2
        //12组
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                temp = num1[i] + num2[j];
                //和存在 次数加1 不存在 加入map
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //34组
        for (int i = 0; i < num3.length; i++) {
            for (int j = 0; j < num4.length; j++) {
                temp = num3[i] + num4[j];
                //map中如果存在差 则拿到次数值
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
