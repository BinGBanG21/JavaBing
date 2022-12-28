/*
    赫夫曼树
        1.路径和路径长度：在一棵树中，从一个结点往下可以达到的孩子或孙子结点之间的通路，称为路径。
          通路中分支的数目称为路径长度。若规定根结点的层数为1，则从根结点到第L层结点的路径长度为L-1
        2.结点的权及带权路径长度：若将树中结点赋给一个有着某种含义的数值，则这个数值称为该结点的权。
          结点的带权路径长度为：从根结点到该结点之间的路径长度与该结点的权的乘积
        3.树的带权路径长度：树的带权路径长度规定为所有叶子结点的带权路径长度之和，记为WPL(weighted path length)
          权值越大的结点离根结点越近的二叉树才是最优二叉树。
        4.WPL最小的就是赫夫曼树
    应用
        给你一个数列 {13, 7, 8, 3, 29, 6, 1}，要求转成一颗赫夫曼树.
        构成赫夫曼树的步骤：
            1.从小到大进行排序, 将每一个数据，每个数据都是一个节点,每个节点可以看成是一颗最简单的二叉树
            2.取出根节点权值最小的两颗二叉树
            3.组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
            4.再将这颗新的二叉树，以根节点的权值大小 再次排序，不断重复  1-2-3-4 的步骤
              直到数列中，所有的数据都被处理，就得到一颗赫夫曼树

* */

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = huffman(arr);
        root.preOrder();
    }

    public static Node huffman(int[] arr) {
        //把数组中的每个元素包装成node 放入ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int j : arr) {
            nodes.add(new Node(j));
        }
        Collections.sort(nodes);
        while (nodes.size() > 1) {
            //取出节点权值最小的两个 构建成一个树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构建成一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            //把节点挂上
            parent.left = leftNode;
            parent.right = rightNode;

            //从arrayList删除用过构建树的两个节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将新生成的树加入到list中
            nodes.add(parent);
        }
        //返回树头
        return nodes.get(0);

    }

    //前序遍历huffmanTree
    public static void huffmanList(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空 无法遍历");
        }
    }

}

//为了让node可以排序、使用Collections
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value; //从小到大排
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

}