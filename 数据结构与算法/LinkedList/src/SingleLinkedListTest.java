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

    public HeroNode getHead() {
        return head;
    }

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

    //指定位置插入
    public void addByNo(int no, HeroNode node) {
        HeroNode current = head; //这里前后两个变量就用current 和 current.next
        boolean flag = false;
        while (true) {
            if (current.next == null) {
                break;
            }
            if (current.next.no > no) {
                break;
            } else if (current.next.no == no) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            System.out.println("武将已存在");
        } else {
            node.next = current.next;
            current.next = node;
        }

    }

    //查找链表中倒数第K个节点
    public HeroNode findLastIndexNode(HeroNode head, int lastIndex) {
        int size = SingleLinkedList.linkedSize(head);
        if (head.next == null || lastIndex > size || lastIndex <= 0) {
            System.out.println("链表为空或者超出了链表的范围");
            return null;
        }
        HeroNode temp = head.next;
        int index = size - lastIndex;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //获取链表内有效节点的个数（如果带有头节点 则去掉头节点）
    public static int linkedSize(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return -1;
        }
        int size = 0;
        HeroNode temp = head.next; //去掉了头节点
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    //指定位置删除元素
    public void removeByNo(int no) {
        //对链表进行非空判断
        if (head == null) {
            System.out.println("链表为空 不能删除武将");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("武将本身不存在，无法删除");
        } else {
            temp.next = temp.next.next;
            temp.next.next = null; //他引用别人不用管 只要没有引用指向他 就会被GC回收
        }
    }


    //根据no,修改武将的信息
    public void modifyByNo(int no, String nickName) {
        //对链表进行非空判断
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //还是要先找到要修改的元素
        HeroNode temp = head;
        boolean isModify = false;

        //while循环就是负责找到目标元素 没找到就向下走 找到了就改标识符 到最后就停掉
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no != no) {
                temp = temp.next;
            }
            if (temp.next.no == no) {
                isModify = true;
            }
        }
        //走出循环 证明找到了目标元素
        if (!isModify) {
            System.out.println("不存在对应的武将");
        } else {
            temp.nickName = nickName;
        }
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