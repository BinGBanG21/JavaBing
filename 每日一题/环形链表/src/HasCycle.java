public class HasCycle {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        //双指针
        //首先保证两个指针都不能为null
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //如果没有相遇 就一直走下去
        while(slow != fast){
            //慢指针走一步 快指针走两步
            //如果fast == null 证明在slow和fast不相等的情况下 走到链表尽头了 那么证明没环 返回false
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果两个指针相遇 记录相遇点index1 起点index2  while循环 直到两个节点相遇  相遇点即为环形链表入口
        return true;

    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
