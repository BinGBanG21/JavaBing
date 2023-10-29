import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //如果为null或者只有一个元素 那么直接返回
        if (nums == null || nums.length < 2) {
            return nums;
        }
        //计算窗口的个数 记录每个窗口的最大值索引
        int[] res = new int[nums.length - k + 1];
        //创建双端队列
        LinkedList<Integer> queue = new LinkedList<>();
        //便利数组中的元素 right表示窗口的有边界
        for (int right = 0; right < nums.length; right++) {
            //如果当前考察的元素<队尾元素 不用管
            //如果当前考察的元素>=队尾元素 那么一直弹出元素直到新的队尾元素>=当前的考察元素
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            //找到最大值 储存下标
            queue.addLast(right);

            //计算窗口左边界的索引
            int left = right - k + 1;
            //当队首的下标<当前窗口的左边界的话 那么将其从队列中移除
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            //根据右边界 计算窗口形成 形成后记录最大值
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
