import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        //数据在磁盘中 排序双指针浪费时间
        //用哈希表方便查询
        Map<Integer, Integer> map = new HashMap<>();
        //结果 不知道几个 用可变数组
        List<Integer> list = new ArrayList<>();
        //将nums1加入到map中
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            //>0为交集 我们-1 加入结果中
            if (map.getOrDefault(nums2[i],0)!=0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
