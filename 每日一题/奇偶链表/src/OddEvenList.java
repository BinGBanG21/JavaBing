public class OddEvenList {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        //先连接所有奇数索引节点为奇链表
        //然后连接所有偶数节点为偶链表
        //然后奇偶链表连接
        if (head == null) {
            return head;
        }
        //奇数链表的头节点
        ListNode evenHead = head.next;
        ListNode oddCurr = head, evenCurr = evenHead;
        //循环 奇数节点靠后 所以用奇数索引节点去判断
        while (evenCurr != null && evenCurr.next != null) {
            //连接偶数节点 当前偶数节点前移
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            //连接奇数节点 当前奇数节点前移
            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }
        //拼接 返回
        oddCurr.next = evenHead;
        return head;
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