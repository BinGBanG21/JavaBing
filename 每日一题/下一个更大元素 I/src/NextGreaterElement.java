import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //单调栈的应用 首先做一个nums1的数值和索引的映射
        //然后遍历nums2 如果找到大的数且值相等nums1 那么记录到结果数组中
        int[] res = new int[nums1.length];
        //初始化数组为-1 因为找不到就是-1
        Arrays.fill(res, -1);
        //创建映射
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i], i);
        }
        //创建栈 把第一个元素的索引加入
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 1; i < nums2.length; i++) {
            //两种情况 <= 入栈 大于记录 出栈 当前值入栈
            if (nums2[i] <= nums2[s.peek()]) {
                s.add(i);
            } else {
                while (!s.isEmpty() && nums2[i] > nums2[s.peek()]) {
                    if (m.containsKey(nums2[s.peek()])) {
                        //找到对应的索引 记录值
                        Integer index = m.get(nums2[s.peek()]);
                        res[index] = nums2[i];
                    }
                    //没找到1数组中对应的值 也需要弹出
                    s.pop();
                }
                //如果小于= 继续入栈
                s.add(i);
            }
        }
        return res;
    }
}
