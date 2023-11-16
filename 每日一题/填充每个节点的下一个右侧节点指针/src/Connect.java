public class Connect {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftBegin = root;

        //从左往右连接 找最左节点
        while (leftBegin.left != null) {

            //用于遍历的指针
            Node conNode = leftBegin;

            //开始连接
            while (conNode != null) {
                //连接左右孩子
                conNode.left.next = conNode.right;

                //连接右左
                if (conNode.next != null) {  //上一级的右节点
                    conNode.right.next = conNode.next.left;
                }

                //指针后移
                conNode = conNode.next;
            }
            //去下一层
            leftBegin = leftBegin.left;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};