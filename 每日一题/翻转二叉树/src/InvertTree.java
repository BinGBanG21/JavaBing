

public class InvertTree {
    public static void main(String[] args) {

    }

    //    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//    }
    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        //参数处理 终止条件
        if (root == null) {
            return null;
        }
        //中-左-右 前序
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //交换节点
    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}