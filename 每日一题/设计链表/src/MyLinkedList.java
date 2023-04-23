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
        ListNode head;

        //无参构造器
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
        public int get(int index) {
            //对size边界处理 注意index是从0开始 所以不能>size - 1 可以=
            if (index < 0 || index > size - 1) {
                return -1;
            }
            //记录当前节点 不能动head
            ListNode cur = head;
            //开始循环
            while (index > 0) {
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
        public void addAtIndex(int index, int val) {
            //对index做边界处理
            if (index < 0 || index > size - 1) {
                return;
            }
            //index合理 首先增加size
            size++;
            //创建虚拟头节点 并指为当前节点
            ListNode dummyhead = new ListNode(-1);
            dummyhead.next = head;
            ListNode cur = dummyhead;
            //因为多了一个虚拟头节点 cur就是当前节点的前一个节点 然后增加
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            //创建节点并添加
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next = newNode;
        }
        public void deleteAtIndex(int index) {
            //对index做边界处理
            if (index < 0 || index > size - 1) {
                return;
            }
            //index合理 首先减少size
            size--;
            //创建虚拟头节点
            ListNode dummyhead = new ListNode(-1);
            dummyhead.next = head;
            ListNode cur = dummyhead;
            //找到当前节点的前一个节点 并且删除
            while(index > 0){
                cur =cur.next;
                index--;
            }
            cur.next = cur.next.next;
        }
    }
}
