/*
    平衡二叉树(AVL树)
        看一个案例(说明二叉排序树可能的问题)
            给你一个数列{1,2,3,4,5,6}，要求创建一颗二叉排序树(BST), 并分析问题所在.
            左边BST 存在的问题分析:
                1.左子树全部为空，从形式上看，更像一个单链表.
                2.插入速度没有影响
                3.查询速度明显降低(因为需要依次比较), 不能发挥BST的优势，因为每次还需要比较左子树，其查询速度比单链表还慢
                *解决方案-平衡二叉树(AVL)
        平衡二叉树
            1.平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树， 可以保证查询效率较高。
            2.具有以下特点：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。平
              衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。
        单旋转(左旋转)
            应用场景: 有一个数列，创建出对应的平衡二叉树.数列 {4,3,6,5,7,8}
            何为旋转 就好像一根绳子 你随便找一个点把绳子拎起来 绳子的左右长度进行对比
            如果右边长 那我们拎起来的点就要左移 其实就是换一个更大的根节点 左边同理
            右边高左旋转 左边高右旋转
        双旋转
            前面的两个数列，进行单旋转(即一次旋转)就可以将非平衡二叉树转成平衡二叉树,但是在某些情况下，单旋转不能完成平衡二叉树的转换、
            问题分析
            1.当符和右旋转的条件时
            2.如果它的左子树的右子树高度大于它的左子树的高度
            3.先对当前这个结点的左节点进行左旋转
            4.在对当前结点进行右旋转的操作即可

* */


public class AVLTree {
    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建一个AVLTree
        CreateAVLTree AVLTree = new CreateAVLTree();
        for (int i : arr) {
            AVLTree.add(new Node(i));
        }

        System.out.println("平衡后树的高度");
        System.out.println(AVLTree.getRoot().height());
        System.out.println("左子树的高度" + AVLTree.getRoot().leftHeight());
        System.out.println("右子树的高度" + AVLTree.getRoot().rightHeight());

    }
}

class CreateAVLTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //首先计算左右子树的高度
    //返回以当前节点为根节点的左右子树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    //左旋转的方法
    public void leftRoute() {
        //创建一个新节点 值为老的根节点 也就是当前节点
        Node newNode = new Node(value);
        //将新节点的左子节点设为原来根节点的左子节点
        newNode.left = left;
        //将新节点的右子节点设为原根节点的右子节点
        newNode.right = right.left;
        //将当前节点(也就是原根节点)的值替换为当前节点右节点的值(即根节点右移)
        value = right.value;
        //右移后将当前节点的左节点设为新节点 右节点设为原根节点的右右节点
        left = newNode;
        right = right.right;
    }

    //右旋转的方法
    public void rightRoute() {
        //创建一个节点
        Node newNode = new Node(value);
        //设置newNode的左右节点  右节点不变 左节点为原根节点左子节点的右子节点
        newNode.right = right;
        newNode.left = left.right;
        //更改原根节点的值为(因为右旋 所以为左子节点的值)
        value = left.value;
        //将根节点与新节点连接
        right = newNode;
        //删除原根节点的左子节点(把它越过去)
        left = left.left;

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
        //当添加完一个节点后 判断左右子树的高度 然后旋转
        //比如在决定要使用右旋转之前 root左节点的右子节点高度高于左节点 那么就需要双旋转
        //可以理解为右旋转左树高度高没事 右树高就旋转无效


        //左旋转
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //以左子树为root节点 先右旋转
                right.rightRoute();
                leftRoute();
            } else {
                leftRoute();
            }
            //我们在添加节点的时候 会一直判断 所以必须要加return 或者if else的形式 不然会出问题
            return;
        }
        //右旋转之前 如果左节点的右子树的高度大于左子树的高度 那么就要双旋转 即先旋转左子树 然后在旋转右子树
        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //以左子树为root节点 先右旋转
                left.leftRoute();
                rightRoute();
            } else { //必须要用else 不然会转两次
                rightRoute();
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
