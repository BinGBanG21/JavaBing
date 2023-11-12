import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {

    }

    int capacity;
    Map<Integer, LinkNode> map = new HashMap<>();
    //链表的头尾 方便操作
    LinkNode head = new LinkNode(0, 0);
    LinkNode tail = new LinkNode(0, 0);

    public LRUCache(int capacity) {
        //初始化
        this.capacity = capacity;
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            moveNodeToTop(node);
            return node.val;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        //如果不存在 我们要放入 放入的同时我们要根据容量处理
        if (!map.containsKey(key)) {
            //删除最后一个元素 然后把新放入的放在头部
            if (map.size() == capacity)  deleteLastNode();
            LinkNode newNode = new LinkNode(key, value);
            LinkNode temp = head.next;
            head.next = newNode;
            newNode.front = head;
            //把当前节点和之前的头节点连接
            temp.front = newNode;
            newNode.next = temp;
            //存入map
            map.put(key, newNode);
        } else {  //map中获取 更新 然后放到最前面
            LinkNode node = map.get(key);
            node.val = value;
            moveNodeToTop(node);
        }
    }

    //删除最后一个节点 也就是跳过节点
    public void deleteLastNode() {
        LinkNode lastNode = tail.front;
        lastNode.front.next = tail;
        tail.front = lastNode.front;
        map.remove(lastNode.key);
    }

    //更新node的val 然后放到最前面
    //先断开 然后和head连接
    public void moveNodeToTop(LinkNode node) {
        node.front.next = node.next;
        node.next.front = node.front;
        //保存第一个
        LinkNode temp = head.next;
        head.next = node;
        node.front = head;
        node.next = temp;
        temp.front = node;

    }
}

//双向链表
class LinkNode {
    int key;
    int val;
    LinkNode front;
    LinkNode next;

    public LinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}