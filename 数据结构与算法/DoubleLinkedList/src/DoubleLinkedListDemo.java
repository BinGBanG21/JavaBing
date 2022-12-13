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

    //根据no修改元素信息
    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("链表为空，不能添加元素");
        }
        //找到修改的节点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.nickName = newNode.nickName;
            temp.name = newNode.name;
        } else {
            System.out.println("武将信息不存在，请重新输入");
        }
    }

    //从双向链表中删除一个元素
    public void remove(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空，不能添加元素");
        }
        //因为是双向链表 保存前一个节点的信息 所以不需要找到待删除节点的前一个节点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.prev.next = temp.next;
            //如果删除的是最后一个节点就要加一个判断 防止空指针异常
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        } else {
            System.out.println("武将信息不存在，请重新输入");
        }
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