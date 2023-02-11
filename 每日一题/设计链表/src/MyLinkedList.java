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

    class myLinkedList {
        int size;
        ListNode head;

        public myLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            //边界条件
            if (index < 0 || index > size - 1) {
                return -1;
            }
            //初始化头节点 这个节点就是虚拟头节点
            ListNode cur = head;
            //包含虚拟头节点 所以要+1
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            //找到要插入节点的前驱节点 利用我们的虚拟头节点
            ListNode pre = head;
            //生成要插入的节点
            ListNode add = new ListNode(val);
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            add.next = pre.next;
            pre.next = add;
        }

        public void deleteAtIndex(int index) {
            //index包含虚拟头节点
            if (index < 0 || index >= size) {
                return;
            }
            //要先size-- 不然删完头节点直接return了
            size--;
            //如果删除头节点
            if (index == 0) {
                //移动虚拟头节点即可
                head = head.next;
                return;
            }
            ListNode pre = head;
            //找到当前节点的前一个节点
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
    }
}
