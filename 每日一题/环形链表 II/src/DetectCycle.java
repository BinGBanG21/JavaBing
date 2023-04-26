import java.util.List;

public class DetectCycle {
    public static void main(String[] args) {

    }

//    public ListNode detectCycle(ListNode head) {
//        //快慢指针 如果相遇 证明有环
//        //先找相遇点 然后通过相遇点找到起始点
//        ListNode slow = head;
//        ListNode fast = head;
//        //链表中没有元素或者只有一个元素 都不行
//        while (fast != null && fast.next != null) {
//            //快指针走两步 慢指针走一步
//            fast = fast.next.next;
//            slow = slow.next;
//            //如果相遇 记录相遇点
//            //相同时间  距离关系和速度一样
//            // 2( x + y )  = x + y + n( y + z)
//            // x + y = ny + nz
//            // x = ny + nz - y  n >= 1 假设n = 1
//            // x = z
//            if (fast == slow) {
//                ListNode index1 = fast;
//                ListNode index2 = head;
//                while (index1 != index2) {
//                    index1 = index1.next;
//                    index2 = index2.next;
//                }
//                return index1;
//            }
//        }
//        return null;
//    }
    public ListNode detectCycle(ListNode head){
        //思路:快慢指针 快指针走2步 慢指针走一步 相对位移1步 不会跳过
        ListNode fast = head;
        ListNode slow = head;
        //走 防止空指针异常
        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //如果相等 证明相交
            if(fast == slow){
                //记录相交点的index
                ListNode meetNode = fast;
                ListNode cur = head;
                //两个节点  从头节点和相遇节点开始相同速度走 交点即为入口
                while(cur != meetNode){
                    cur = cur.next;
                    meetNode = meetNode.next;
                }
                return cur;
            }
        }
        return null;
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
