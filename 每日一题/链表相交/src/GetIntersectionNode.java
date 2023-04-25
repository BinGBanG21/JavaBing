import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路先分别计算两个链表的长度
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        //重置指针
        curA = headA;
        curB = headB;
        //把链表A作为长链表(把curA赋值为长链表的头节点 lenA为长链表的长度)
        if (lenB > lenA) {
            //交换长度
            int tempLen = lenB;
            lenB = lenA;
            lenA = tempLen;
            //交换头节点 curB - curA
            ListNode tempNode = curB;
            curB = curA;
            curA = tempNode;
        }
        //求出长度差gap 然后让A先走gap 然后判断是否相等
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        //尾端对其之后 一一节点比较 相等直接return退出循环 不相等就后移
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}