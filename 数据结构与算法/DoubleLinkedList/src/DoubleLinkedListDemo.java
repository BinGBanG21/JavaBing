/*
     管理单向链表的缺点分析:
        单向链表，查找的方向只能是一个方向，而双向链表可以向前或者向后查找。
        单向链表不能自我删除，需要靠辅助节点 ，而双向链表，则可以自我删除，
        所以前面我们单链表删除时节点，总是找到temp,temp是待删除节点的前一个节点.
     分析双向链表的遍历，添加，修改，删除
        1)遍历方和单链表一样，只是可以向前，也可以向后查找
        2)添加(默认添加到双向链表的最后)
            (1)先找到双向链表的最后这个节点
            (2) temp.next =newHeroNode
            (3) newHeroNode.pre =temp;
        3)修改思路和原理的单向链表一样.
        4)删除
            (1)因为是双向链表，因此，我们可以实现自我删除某个节点
            (2)直接找到要删除的这个节点，比如temp
            (3)temp.pre.next =temp.next
            (4)temp.next.pre=temp.pre;
* */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //遍历双向链表
    public void list(HeroNode head) {
        //对链表进行非空判定
        if (head.next == null) {
            System.out.println("链表为空，请先添加数据");
        }
        HeroNode cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    //在双向链表尾部添加一个元素
    public void push(HeroNode head, HeroNode data) {
        HeroNode temp = head.next;
        if (temp == null) {
            temp = data;
            return;
        }
        while (temp != null) {
            temp = temp.next;
        }
        temp.next = data;
        data.prev = temp;
    }


}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点 初始值都为null
    public HeroNode prev; //指向前一个节点


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}