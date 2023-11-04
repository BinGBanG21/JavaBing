public class SortList {
    public static void main(String[] args) {

    }

    //实现链表的归并排序有两个环节
    //1.找出每段链表的头节点  2.合并
    public ListNode sortList(ListNode head) {
        //参数处理
        if (head == null) {
            return head;
        }
        //计算链表的长度 找出每段链表的头K节点
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        //创建虚拟节点 指向链表的头部
        ListNode dummyHead = new ListNode(0, head);

        //循环 合并链表
        for (int subLen = 1; subLen < len; subLen *= 2) {
            //prev用于指向每段排序后的链表 用于连接每段链表 curr用于遍历链表
            ListNode prev = dummyHead, curr = dummyHead.next;
            //找出每两段链表的两个头部 然后合并
            while (curr != null) {
                //第一段链表的头节点就是起点
                ListNode head1 = curr;
                //循环 找出多段节点 对每一对头节点 head1 head2 进行合并
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                //找到中点后断开 赋值给head2节点 并且断开
                ListNode head2 = curr.next;
                curr.next = null;
                //找到head2后 找下一个合并的起点
                curr = head2;
                //遍历到第二个链表的结尾 记录next
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                //初始化next 如果后面还有节点 那么进行记录
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    //到这里第二个链表也断开了 有了两个独立的链表 开始合并
                    curr.next = null;
                }
                ListNode merged = merger(head1, head2);
                //让临时的虚拟节点连接结果
                prev.next = merged;
                //让节点移动到链表后
                while (prev.next != null) {
                    prev = prev.next;
                }
                //curr移动到起点 继续合并
                curr = next;
            }
        }
        return dummyHead.next;
    }


    //自地向上合并链表 归并排序
    public ListNode merger(ListNode head1, ListNode head2) {
        //3中情况 node1为空 node2为空 两个都不为空
        //因为是要返回排序后新的链表 所以需要两个新的节点
        //创建虚拟头节点 方便下次比较时拿到较小的节点
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;

        //因为是对两个子链表排序 根据两个head指向 所以用while
        //直到其中一条链表next为null
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                //头节点指向较小数  然后head1向后移动 继续进入while循环比较
                temp.next = temp1;
                temp1 = temp1.next;
            } else { //反之相反
                temp.next = temp2;
                temp2 = temp2.next;
            }
            //排序后 temp向后移动
            temp = temp.next;
        }
        //把剩余链表进行连接
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        //返回较小节点
        return dummyHead.next;
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
}
