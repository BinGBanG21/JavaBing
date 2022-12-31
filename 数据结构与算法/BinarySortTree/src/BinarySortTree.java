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
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

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

    //查找结点的方法
    public Node findTarget(int value) {
        if (root == null) {
            return null;
        } else {
            return root.findTarget(value);
        }
    }

    //查找父节点的方法
    public Node findParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.findParent(value);
        }
    }
    //返回以node为节点的二叉排序树的最小值
    //删除node为根节点的二叉排序树的最小节点
    //因为删除了当前树 那么要找一个节点代替他 以免他下面的树节点丢失
    //那么该找什么样的值呢 因为是二叉排序树 所以要找比右边小 比左边大的
    //说白了 要从右子节点向左递归
    //把带有最小值的树节点删除 然后把值赋给target

    //其实就是为了满足二叉排序树 那么删除双子树节点的时候 要从左子树选一个最大值或者后子树选一个最小值
    //那么我们这里是选择右子树的最小值
    //最小值其实就是右子树一直左递归 拿到最左边的值然后替换 这样才能保证是一棵顺序二叉树
    public int delRightTree(Node node) {
        Node target = node;
        //循环拿到最小值
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //找到当前节点和父节点
            //找到当前节点 进行处理(非空 root)
            Node target = findTarget(value);
            if (target == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            Node parent = findParent(value);

            //接下来进行删除操作
            //如果删除的是叶子节点
            if (target.left == null && target.right == null) {
                //然后确定是左还是右节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }
                if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (target.left != null && target.right != null) { //该树有两个节点
                int minVal = delRightTree(target.right);
                target.value = minVal;
            } else { //该树有一个节点
                //如果target有左子节点 那么将target删除后 将子节点补在target的位置
                //找出target是parent的左节点还是右节点 然后判断target带着的是左节点还是右节点
                //补位
                //如果只剩根节点 挂着一个子节点 那么直接删除根节点 我们把剩下的节点设成根节点即可
                if (target.left != null) {
                    if (parent != null) { //证明删除的不是根节点
                        if (parent.left.value == target.value) {
                            parent.left = target.left;
                        } else {
                            parent.right = target.left;
                        }
                    } else {
                        root = target.left;
                    }
                }
                if (target.right != null) {
                    if (parent != null) {
                        if (parent.left.value == target.value) {
                            parent.left = target.right;
                        } else {
                            parent.right = target.right;
                        }
                    } else {
                        root = target.right;
                    }
                }
            }

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
    //首先找到目标节点target  然后找到其父节点parent
    //判断删除的是左子节点还是右子节点 对应删除即可

    //不管哪种删除情况 都需要找到目标节点以及目标节点的父节点

    /**
     * 如果当前值比this的值小 那么就往左递归查找 否则往右递归查找
     *
     * @param value //希望删除的节点的value值 通过这个值找节点
     * @return
     */
    public Node findTarget(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value < value) {

            if (this.left == null) {
                return null;
            }
            return this.left.findTarget(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.findTarget(value);
        }
    }

    //查找父节点的方法
    public Node findParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.left.value > value) {
                return this.left.findParent(value);
            } else if (this.right != null && this.right.value >= value) {
                return this.right.findParent(value);
            } else {
                return null;
            }
        }
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
