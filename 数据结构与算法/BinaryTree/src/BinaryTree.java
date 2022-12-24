/*
    二叉树
        为什么需要树这种数据结构
            1.数组存储方式的分析
                优点：通过下标方式访问元素，速度快。对于有序数组，还可使用二分查找提高检索速度。
                缺点：如果要检索具体某个值，或者插入值(按一定顺序)会整体移动，效率较低 [示意图]
            2.链式存储方式的分析
                优点：在一定程度上对数组存储方式有优化(比如：插入一个数值节点，只需要将插入节点，链接到链表中即可， 删除效率也很好)。
                缺点：在进行检索时，效率仍然较低，比如(检索某个值，需要从头节点开始遍历)
    树存储方式的分析
        能提高数据存储，读取的效率, 比如利用 二叉排序树(Binary Sort Tree)
        既可以保证数据的检索速度，同时也可以保证数据的插入，删除，修改的速度。
    树的常用术语:
        节点
        根节点
        父节点
        子节点
        叶子节点 (没有子节点的节点)
        节点的权(节点值)
        路径(从root节点找到该节点的路线)
        层
        子树
        树的高度(最大层数)
        森林 :多颗子树构成森林
    二叉树的概念
        1.树有很多种，每个节点最多只能有两个子节点的一种形式称为二叉树。
        2.二叉树的子节点分为左节点和右节点。
        3.如果该二叉树的所有叶子节点都在最后一层，并且结点总数= 2^n -1 , n 为层数，则我们称为满二叉树。
        4.如果该二叉树的所有叶子节点都在最后一层或者倒数第二层，而且最后一层的叶子节点在左边连续
          倒数第二层的叶子节点在右边连续，我们称为完全二叉树
    二叉树的遍历
        前序遍历: 先输出父节点，再遍历左子树和右子树
        中序遍历: 先遍历左子树，再输出父节点，再遍历右子树
        后序遍历: 先遍历左子树，再遍历右子树，最后输出父节点
        总结：看输出父节点的顺序，就确定是前序，中序还是后序
* */

public class BinaryTree {
    public static void main(String[] args) {
        //手动创建二叉树
        BinaryTree1 binaryTree1 = new BinaryTree1();
        //创建节点
        HeroNode root = new HeroNode(1, "及时雨");
        HeroNode node1 = new HeroNode(2, "玉麒麟");
        HeroNode node2 = new HeroNode(3, "浪子");
        HeroNode node3 = new HeroNode(4, "豹子头");

        //手动方式创建二叉树
        binaryTree1.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);

        binaryTree1.preOrder();
    }
}

class BinaryTree1{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("树为空 无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("树为空 无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("树为空 无法遍历");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    //二叉树节点的左右
    private HeroNode left;
    private HeroNode right;

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
}
