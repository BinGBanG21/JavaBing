/*
    二叉排序树
        先看一个需求:给你一个数列 (7, 3, 10, 12, 5, 1, 9)，要求能够高效的完成对数据的查询和添加
        解决方案分析
            1.数组(未排序)
              优点：直接在数组尾添加，速度快。 缺点：查找速度慢.
            2.数组排序
              优点：可以使用二分查找，查找速度快，缺点：为了保证数组有序，在添加新数据时，找到插入位置后，后面的数据需整体移动，速度慢。
            3.使用链式存储-链表 不管链表是否有序，查找速度都慢，添加数据速度比数组快，不需要数据整体移动。
            *使用二叉排序树
   二叉排序树：BST: (Binary Sort(Search) Tree), 对于二叉排序树的任何一个非叶子节点，
             要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大。
             特别说明：如果有相同的值，可以将该节点放在左子节点或右子节点
   二叉排序树的删除
      二叉排序树的删除情况比较复杂，有下面三种情况需要考虑
         1.删除叶子节点 (比如：2, 5, 9, 12)
         2.删除只有一颗子树的节点 (比如：1)
         3.删除有两颗子树的节点. (比如：7, 3，10 )

* */

public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};

        //创建二叉树
        BSTree bsTree = new BSTree();
        for (int i : arr) {
            bsTree.add(new Node(i));
        }

        //遍历(走完添加方法 自动会设置root节点)
        bsTree.infixOrder();
    }
}

//创建二叉树的类
class BSTree {
    private Node root;

    //添加节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        if (root == null) {
            System.out.println("空树 无法遍历");
        } else {
            root.infixOrder();
        }
    }
}

//节点类
class Node {
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

    //添加节点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //如果不为空 那么就比较大小 小于就挂左边
        if (node.value < this.value) {
            if (this.left != null) {
                //递归调用
                this.left.add(node);
            } else {
                this.left = node;
            }
        } else {   //大于等于就挂右边
            if (this.right != null) { //递归调用
                this.right.add(node);
            } else {
                this.right = node;
            }
        }
    }

    //删除节点（1.是否是叶子节点 2.如果不是 那么有一棵子树还是两棵子树）
    public void remove(){

    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
