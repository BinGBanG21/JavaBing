public class SwapPairs {
    public static void main(String[] args) {


    }

    public ListNode swapPairs(ListNode head) {
        //链表操作 虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        //如果链表个数是奇数 cur.next == null 偶数 cur.next.next == null
        while (cur.next != null && cur.next.next != null) {
            //先保存1 3 节点
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;
            //dummy指向2节点
            cur.next = cur.next.next;
            //此时cur.next已经是2节点 然后2节点指向1节点
            cur.next.next = temp;
            //1节点指向3节点
            temp.next = temp1;
            //只需要移动虚拟头节点即可
            cur = cur.next.next;
        }
        return dummyHead.next;
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
