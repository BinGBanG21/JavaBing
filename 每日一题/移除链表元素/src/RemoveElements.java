public class RemoveElements {
    public static void main(String[] args) {

    }

    //    public ListNode removeElements(ListNode head, int val) {
//        //虚拟头节点 统一规则
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        //单链表 删除节点时 必须找到前一个节点
//        ListNode cur = dummyHead;
//        //删除当前节点 必须找到
//        while (cur.next != null) {
//            if (cur.next.val == val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//        return dummyHead.next;
//    }
    public ListNode removeElements(ListNode head, int val) {
        //题目中节点的个数可以=0 判断一下啊
        if (head == null) {
            return head;
        }
        //虚拟头节点 统一代码
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        //使用while循环 去除重复元素
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            //那种情况都需要向后移动cur
            cur = cur.next;
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
