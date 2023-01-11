import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建一个ListNode节点 作为结果链表的头节点 同时也是为了当作临时变量 储存链表的值
        ListNode pre = new ListNode(0);
        //用于遍历链表的指针
        ListNode cur = pre;
        //用于存储进位值
        int carry = 0;
        //循环链表  两个ListNode只要还有一个不为null 就一直循环
        while (l1 != null || l2 != null) {
            //拿到两个链表的值 进行相加
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int curVal = sum % 10;
            //创建这个结果节点 并将结果节点加入结果链表
            ListNode resNode = new ListNode(curVal);
            cur.next = resNode;
            //将当前节点后移
            cur = cur.next;
            //同时将l1 l2 后移动
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //走出while循环 假如我们的两条链表空了 但是还有进位数 那么把进位数新建节点 保存当前的进位数
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        //返回新链表的头节点
        return pre.next;


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
}
