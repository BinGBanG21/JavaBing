public class IsPalindrome {
    public static void main(String[] args) {


    }

    public boolean isPalindrome(ListNode head) {
        //快慢指针 快指针一次走2步 慢指针一次走1步
        //如果链表元素为奇数 那么中间节点看作前半部分
        ListNode slow = head;
        ListNode fast = head;
        //通过快慢指针找到链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //while完成后 看fast是否指向null 如果不指向null 则表示节点个数为单数
        //指向null 为双数
        if (fast != null) {
            //如果是单数 我们把这个节点给到左边节点 那么右边节点开头就要后移一个
            slow = slow.next;
        }
        //拿到后半段链表的头slow 反转后半段链表 然后进行一一比较

        ListNode reverseHead = reverse(slow);
        while (reverseHead != null) {
            if (head.val != reverseHead.val) {
                return false;
            } else {
                head = head.next;
                reverseHead = reverseHead.next;
            }
        }
        return true;

    }

    public ListNode reverse(ListNode head) {
        //双指针反转链表
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            //先把后面节点保存 防止丢失
            temp = cur.next;
            cur.next = pre;
            //前移节点
            pre = cur;
            cur = temp;

        }
        return pre;
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
