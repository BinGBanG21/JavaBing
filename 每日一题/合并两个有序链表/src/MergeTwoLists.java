public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //递归的思路：如果在合并的时候有一个为空 那么就返回另一个值 直接挂到链表后面
        //如果list1 < l2 那么list1.next = l2; 否则相反
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //进行递归
        if (list1.val < list2.val) {
            //将l1的next节点往后挂
            list1.next = mergeTwoLists(list1.next, list2);
            //返回头节点
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
