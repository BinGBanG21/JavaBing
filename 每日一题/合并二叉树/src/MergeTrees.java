
public class MergeTrees {
    public static void main(String[] args) {

    }

//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        //如果其中一个为空 则返回另一个 如果另一个也为null
//        //那么都为null
//        if (root1 == null) {
//            return root2;
//        }
//        if (root2 == null) {
//            return root1;
//        }
//        root1.val += root2.val;
//        root1.left = mergeTrees(root1.left, root2.left);
//        root1.right = mergeTrees(root1.right, root2.right);
//        return root1;
//    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //其中一个为null 两个不为null
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //不为空 合并节点的值
        root1.val += root2.val;
        //处理左右子树
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
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