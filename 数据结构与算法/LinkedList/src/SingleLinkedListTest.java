/*
    链表(Linked List)
        链表是有序的列表（有序但是不连续），但是它在内存中是存储如下
            总结:
                链表是以节点的方式来存储,是链式存储
                每个节点包含 data 域， next 域：指向下一个节点.
                如图：发现链表的各个节点不一定是连续存储.
                链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定

* */

public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();

    }
}

//定义SingleLinkedList 管理单链表
class SingleLinkedList {
    //初始化链表的头
    private HeroNode head = new HeroNode(0, "", "");

    //向单向链表中添加数据
    public void add(HeroNode node) {
        //其实就是递归找到next = null 的节点 进行赋值 需要注意的是 head节点不能动
        //因为在递归的时候要不停的往下指 所以要一个辅助指针（节点）
        HeroNode temp = head;
        //不要用 ！= null 去判断 这样会漏掉最后一个元素
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果next不是null 说明没找到头 那就继续找
            temp = temp.next;
        }
        //出了循环 证明已经找到了最后一个节点
        temp.next = node;

    }


    //遍历链表 链表的操作都离不开辅助变量
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        } else {
            HeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

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