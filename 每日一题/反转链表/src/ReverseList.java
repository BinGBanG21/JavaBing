public class ReverseList {
    public static void main(String[] args) {

    }
    //双指针
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            //如果先让cur = cur.next 会丢失cur的值 那么pre就无法指向cur
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//    }
    //二刷
    public ListNode reverseList(ListNode head) {
        //双指针
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        //如果链表为空 则不进入该循环
        while(cur != null){
            //保存下一个节点 因为要改指向
            temp = cur.next;
            //反转
            cur.next = pre;
            //双双移动指针
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    //递归写法
    public ListNode reverseList2(ListNode head) {
        return reverse(head,null);
    }
    public ListNode reverse(ListNode cur , ListNode pre){
        if(cur == null){
            return pre;
        }
        //反转了一个节点
        ListNode temp = cur.next;
        cur.next = pre;
        //递归反转所有节点 两个指针往前走 cur = cur.next =temp pre =cur
        return reverse(temp,cur);
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
