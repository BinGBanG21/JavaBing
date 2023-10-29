public class FindDuplicate {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        //双指针方法 同环形链表一样
        //只不过需要把数组映射成环形链表
        //可以利用数组的下标作为next属性 构建环
        //利用快慢指针解
        //定义慢指针
        int slow = 0;
        //slow相当于next属性 取一次值就相当于访问next属性 走了一步
        slow = nums[slow];
        //定义快指针
        int fast = 0;
        //fast相当于next属性 取两次值就相当于访问next属性 走了两步
        fast = nums[nums[fast]];

        //值没想等就说明没相遇 一直走
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //定义起点 同环形链表 起点遇到相遇点=入口
        //当前值为next 也就是当前值是下一个值的索引
        int begin = 0;
        int result = slow;
        while (begin != result) {
            begin = nums[begin];
            result = nums[result];
        }
        return result;
    }
}
