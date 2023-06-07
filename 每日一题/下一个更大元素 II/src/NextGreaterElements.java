import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        //和单调栈一样 重点在于成环 我们在遍历的时候 2被数组 然后%就可以了
        //边界判断
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        //创建结果数组以及栈 并初始化栈
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 1; i < 2 * nums.length; i++) {
            //2种情况
            if (nums[i % nums.length] <= nums[s.peek() % nums.length]) {
                s.add(i % nums.length);
            } else {
                while (!s.isEmpty() && nums[i % nums.length] > nums[s.peek() % nums.length]) {
                    res[s.peek()] = nums[i % nums.length];
                    s.pop();
                }
                //如果还是<= 就加入
                s.add(i % nums.length);
            }
        }
        return res;
    }
}
