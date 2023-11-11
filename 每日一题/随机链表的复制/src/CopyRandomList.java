import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //使用map创建映射
        Map<Node, Node> map = new HashMap<>();
        //先遍历一遍原链表 创建节点 同时记录映射关系
        //然后通过映射表查找
        Node dummyhead = head;
        while (dummyhead != null) {
            Node newNode = new Node(dummyhead.val);
            map.put(dummyhead, newNode);
            dummyhead = dummyhead.next;
        }
        //设置random和next属性
        dummyhead = head;
        while (dummyhead != null) {
            map.get(dummyhead).next = map.get(dummyhead.next);
            map.get(dummyhead).random = map.get(dummyhead.random);
            dummyhead = dummyhead.next;
        }
        //返回新节点
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}