/*
    线索化二叉树
        1.n个结点的二叉链表中含有n+1  【公式 2n-(n-1)=n+1】 个空指针域。利用二叉链表中的空指针域
          存放指向该结点在某种遍历次序下的前驱和后继结点的指针（这种附加的指针称为"线索"）
        2.这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(Threaded BinaryTree)。
          根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
        3.一个结点的前一个结点，称为前驱结点
        4.一个结点的后一个结点，称为后继结点

* */
public class ThreadBinaryTree {
    public static void main(String[] args) {

    }
}

class ThreadTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //因为二叉树的指向是单向的  为了实现线索化 需要创建一个变量 保存当前节点的上一个节点 不然向处理的时候找不到上一个节点
    //总是保留前一个节点
    public HeroNode pre = null;

    //实现二叉树中序线索化的方法 其实就是在线索化节点
    public void threadNodes(HeroNode node) {
        //如果node为null 无法线索化
        if (node == null){
            return;
        }

        //线索化左子树
        threadNodes(node.getLeft());
        //线索化当前节点
        //如果左节点为空 那么证明是我们要找到的带有空位的节点
        if (node.getLeft() == null){
            //设置前驱节点和节点的类型
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //然后用前驱节点pre设置后继节点
        //如果node的右节点为空 并且pre不为null 证明我们在设置后继节点
        if (pre!=null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //递归的递进条件:每处理完一个节点 让当前节点是下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadNodes(node.getRight());
    }


    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("树为空 无法遍历");
        }
    }


    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("树为空 无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("树为空 无法遍历");
        }
    }

    //前序查找
    //都是对root进行一个空值判断
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.postSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.postSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postSearch(no);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                delNode(no);
            }

        } else {
            System.out.println("空树 不能删除");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    //二叉树节点的左右
    private HeroNode left;
    private HeroNode right;

    //因为我们的左节点右节点有可能指向的是树 有可能指向的是子节点
    //所以要定义两个变量
    //0代表树  1代表节点  left1前驱节点 right后驱节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
        //左右初始值为null
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    //前序遍历的方法
    //先输出父节点，再遍历左子树和右子树
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //后序遍历的方法
    public void postOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode preSearch(int no) {
        //如果当前节点是 return当前节点
        if (this.no == no) {
            return this;
        }
        //如果当前节点不是 且左节点不为空 则递归左侧查找
        //且必须要事先声明result节点 不然没法做错误的判断
        HeroNode result = null;
        if (this.getLeft() != null) {
            result = this.left.preSearch(no);
            if (result != null) {
                return result;
            }
        }
        //如果在递归左子节点的时候找到了 就赋值判断返回 否则递归右节点 直接返回即可
        if (this.getRight() != null) {
            result = this.right.preSearch(no);
        }
        return result;
    }

    //中序遍历查找
    public HeroNode infixSearch(int no) {
        HeroNode result = null;
        if (this.getLeft() != null) {
            result = this.left.infixSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.no == no) {
            return this;
        }
        if (this.getRight() != null) {
            result = this.right.infixSearch(no);
        }
        //找到了 就会返回 找不到  那就返回前面的null
        return result;
    }

    //后序遍历查找
    public HeroNode postSearch(int no) {
        HeroNode result = null;
        if (this.getLeft() != null) {
            result = this.left.postSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.getRight() != null) {
            result = this.right.postSearch(no);
        }
        if (result != null) {
            return result;
        }
        if (this.no == no) {
            return this;
        }
        return result;
    }

    //二叉树删除节点
    //思路：因为我们的二叉树是单向的 所以我们在删除节点的时候 不能找到当前节点
    //要找到当前节点的下一个节点 然后才能删除
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //如果都没找到 那么递归向下找
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}