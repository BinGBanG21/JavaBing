import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //数组两两处理
        //n的四次方变成n的平方
        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        int res = 0;
        //第一组
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //第二组
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
