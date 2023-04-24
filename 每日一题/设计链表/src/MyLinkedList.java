import javax.swing.event.ListDataEvent;
import java.util.List;

public class MyLinkedList {
    public static void main(String[] args) {

    }

    static class ListNode {
        ListNode next;
        int val;

        ListNode() {
        }

        ;

        ListNode(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {
        //记录数据个数
        int size;
        //虚拟头节点
        ListNode head;

        //初始化链表
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
        public int get(int index) {
            //对size边界处理 和数组一样 不能越界
            if (index < 0 || index >= size) {
                return -1;
            }
            //记录当前节点 不可以使用head
            ListNode cur = head;
            //开始循环 如果index = 0 那么也会进入循环 cur为头节点
            while (index >= 0) {
                cur = cur.next;
                index--;
            }
            //如果=0 那么while循环不会执行 直接return cur
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }


        public void addAtTail(int val) {
            addAtIndex(size - 1, val);
        }

        //增删节点时使用虚拟头节点 统一代码
        //在第几个节点前添加节点 所以index可以 = size 不能 > size
        public void addAtIndex(int index, int val) {
            //对index做边界处理
            //题意:如果 index 等于链表的长度，那么该节点会被追加到链表的末尾
            //说明index 可以 = size
            //如果 index 比长度更大，该节点将 不会插入 到链表中
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            //index合理 首先增加size
            size++;
            //找到插入节点的前驱节点(恰好使用虚拟头节点)
            ListNode pre = head;
            while (index > 0) {
                pre = pre.next;
                index--;
            }
            //创建节点并添加
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;
        }

        public void deleteAtIndex(int index) {
            //对index做边界处理
            //题意：如果下标有效
            if (index < 0 || index >= size) {
                return;
            }
            //index合理 首先减少size
            size--;
            ListNode pre = head;
            //找到当前节点的前一个节点 并且删除
            while (index > 0) {
                pre = pre.next;
                index--;
            }
            pre.next = pre.next.next;
        }
    }
}
