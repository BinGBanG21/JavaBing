public class ReverseList {
    public static void main(String[] args) {

    }
    //双指针
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //如果先让cur = cur.next 会丢失cur的值 那么pre就无法指向cur
            ListNode temp = cur.next;
            cur.next = pre;
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
