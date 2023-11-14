public class MergeKLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        //对链表进行两两划分 合并
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        //二分下去 对左右进行合并
        int mid = (l + r) / 2;
        return mergerTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergerTwoLists(ListNode a, ListNode b) {
        //如果一个链表为空
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        //新链表的头节点 和用于遍历的当前节点
        ListNode newHead = new ListNode(0);
        ListNode newCurr = newHead;
        //用于遍历a b链表的当前节点
        ListNode aCurr = a, bCurr = b;

        //循环比较连接
        while (aCurr != null && bCurr != null) {
            if (aCurr.val < bCurr.val) {
                //新节点连接a
                newCurr.next = aCurr;
                //比较过的节点向后移动
                aCurr = aCurr.next;
            } else {
                newCurr.next = bCurr;
                bCurr = bCurr.next;
            }
            newCurr = newCurr.next;
        }
        //假如有其中一条链表合并完成
        newCurr.next = (aCurr == null ? bCurr : aCurr);
        return newHead.next;
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