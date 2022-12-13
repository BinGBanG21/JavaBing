/*
    Josephu(约瑟夫、约瑟夫环)
        Josephu问题为：
            设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
            它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
        提示：
            用一个不带头结点的循环链表来处理Josephu 问题：
            先构成一个有n个结点的单循环链表，然后由k结点起从1开始计数，计到m时，对应结点从链表中删除，
            然后再从被删除结点的下一个结点又从1开始计数，直到最后一个结点从链表中删除算法结束。
        构建一个单向的环形链表思路
            1.先创建第一个节点,让first指向该节点,并形成环形
            2.后面当我们每创建一个新的节点，就把该节点，加入到已有的环形链表中即可.
        遍历环形链表
            1.先让一个辅助指针(变量)curBoy，指向first节点
            2.然后通过一个while循环遍历该环形链表即可curBoy.next == first结束

* */

public class SingleRingLinkedList {
    public static void main(String[] args) {

    }
}

class CircleSingleLinkedList {
    //初始化first节点
    private node firstNode = null;
    private int size;

    public node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(node firstNode) {
        this.firstNode = firstNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //添加节点 构建一个环形链表
    public void addNode(int nums) {
        if (nums < 1) {
            System.out.println("至少添加一个节点");
        }
        //for循环生成环形节点
        //创建cur节点指向当前节点 newNode为新节点
        //然后cur.next指向newNode  newNode.next指向first 就完成了环形链表
        node cur = null;

        for (int i = 0; i < nums; i++) {
            node newNode = new node(i);
            if (i == 1) {
                firstNode = newNode;
                firstNode.setNext(firstNode); //构成了环状
                cur = firstNode; //因为first不能动 让cur保存first
            } else {
                cur.setNext(newNode);
                newNode.setNext(firstNode);
                cur = newNode;
            }
            size++;
        }
    }

    //遍历当前的链表
    public void list() {
        if (firstNode.getNext() == null) {
            System.out.println("链表为空 先添加元素吧");
        }
        node cur = firstNode.getNext();
        //遍历完毕的条件为firstNode
        while (cur != firstNode) {
            System.out.println(cur);
            cur = cur.getNext();
        }
    }

    //根据数字删除节点（其实就是目标节点和前一个节点）
    //核心逻辑说就是：
    //first指向头节点 然后创建一个辅助指针(变量) helper ,事先应该指向环形链表的最后这个节点.
    //当数数时，让first和helper指针同时的移动 count -1 次
    //这时就可以将first指向的节点出圈
    //first= first.next
    //helper.next=first
    //原来first指向的节点就没有任何引用，就会被回收
    public void removeByCount(int count) {
        if (count < 2 || count > getSize()) {
            System.out.println("输入的数字不合法 应在2-" + size + "之间");
        }
        node helper = firstNode;
        //遍历当前链表 找到最后一个节点 赋值为helper
        while (firstNode.getNext() != firstNode) {
            helper = helper.getNext();
        }
        //经过while循环 helper就指向链表的尾节点
        //移动距离为count - 1
        int num = 0;
        node cur = firstNode.getNext();
        while (true){
            if (firstNode == helper){
                break;
            }
            //双指针移动 找到要移除的节点
            while (num != count - 1) {
                helper = helper.getNext();
                firstNode = firstNode.getNext();
            }
            //firstNode指向的就是要出圈的节点
            System.out.printf("第%d个节点出圈\n",firstNode.getNo());
            firstNode = firstNode.getNext();
            helper.setNext(firstNode);
        }
        System.out.printf("最后留在圈中的节点为%d",firstNode.getNo());
    }
}

class node {
    private int no; //编号
    private node next; //指向下一个节点 默认为null

    public node(int no) {
        this.no = no;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "node{" +
                "no=" + no +
                '}';
    }
}