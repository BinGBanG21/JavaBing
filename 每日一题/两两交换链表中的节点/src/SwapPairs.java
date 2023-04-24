public class SwapPairs {
    public static void main(String[] args) {


    }

//    public ListNode swapPairs(ListNode head) {
//        //链表操作 虚拟头节点
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode cur = dummyHead;
//        //如果链表个数是奇数 cur.next == null 偶数 cur.next.next == null
//        while (cur.next != null && cur.next.next != null) {
//            //先保存1 3 节点
//            ListNode temp = cur.next;
//            ListNode temp1 = cur.next.next.next;
//            //dummy指向2节点
//            cur.next = cur.next.next;
//            //此时cur.next已经是2节点 然后2节点指向1节点
//            cur.next.next = temp;
//            //1节点指向3节点
//            temp.next = temp1;
//            //只需要移动虚拟头节点即可
//            cur = cur.next.next;
//        }
//        return dummyHead.next;
//    }
    public ListNode swapPairs(ListNode head){
        //创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //想要两两交换节点 就要知道第一个节点的前驱节点
        //当前节点 指向虚拟头节点
        ListNode cur = dummyHead;
        //开始交换 奇数节点 next next 为 null
        //偶数节点 next 为 null
        while(cur.next != null && cur.next.next != null){
            // dummy  1  2  3  4
            //保存1节点 因为要更改dummy
            ListNode temp1 = cur.next;
            //保存3节点 因为要更改2指向
            ListNode temp2 = cur.next.next.next;
            //进行交换
            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            //当前节点向后移动两位
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
