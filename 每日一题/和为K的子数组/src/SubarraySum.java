import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        //利用前缀和求解 哈希表优化
        //pre[i]为[0,i]所有元素的和 那么pre[i] = pre[i - 1] + nums[i];
        //[j,i]子数组和为K 可得 pre[i] - pre[j-1] == k
        //思路就是我们不停的计算前缀和 然后 -k 看结果是否在前缀表map中出现
        //如果出现 就证明有连续的子数组和为K 记录出现的次数 然后将num[i]的前缀和储存到map中
        int result = 0;
        //前缀和
        int pre = 0;
        //创建map
        Map<Integer, Integer> map = new HashMap<>();
        //特殊情况举例: 1 1 1    2
        //假如 k 恰好和前缀和相等 那么差值为0 所以要初始化0
        map.put(0,1);
        //求前缀和
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            //如果之前的前缀和满足条件 那么记录数量 同时记录当前的前缀和到map中
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }
            //储存当前的前缀和
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return result;
    }
}
