public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建一个虚拟头节点 防止要删除的节点就是头节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        //创建快慢指针
        ListNode fast = newHead;
        ListNode slow = newHead;
        //先让快指针走n步 然后快慢指针一起走
        int step = 0;
        //开始遍历链表
        while (fast.next != null) {
            fast = fast.next;
            step++;
            if (step > n) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return newHead.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
