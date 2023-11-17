public class RotateRight {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        //成环 断点为n - k k可能> n 断开 返回新头节点
        //参数处理
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        //统计链表 找分割点
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        int cut = n - k % n;
        if (cut == n) {
            return head;
        }
        //连成环
        curr.next = head;
        //找断开点 注意 要从尾节点开始算个数
        while (cut-- > 0) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}

class ListNode {
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