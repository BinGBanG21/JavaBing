public class GetIntersectionNode {
    public static void main(String[] args) {

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        //思路：遍历两链表 如果a到头了 就从b开始遍历 反之相同
        while( pA!= pB ){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
