
public class IsBalanced {
    public static void main(String[] args) {

    }

    //    public boolean isBalanced(TreeNode root) {
//        return height(root) >= 0;
//    }
//
//    public int height(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftHeight = height(root.left);
//        int rightHeight = height(root.right);
//        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
//            return -1;
//        } else {
//            return Math.max(leftHeight, rightHeight) + 1;
//        }
//    }
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    //求高度 我们采用后序遍历
    public int getHeight(TreeNode node) {
        //终止条件
        if (node == null) {
            return 0;
        }
        ////计算左右子树的高度 如果左右子树高度差不符合 直接返回
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        //如果符合 进行比较
        int result;
        //如果差值大于1 直接返回-1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        //否则计算高度
        return result = Math.max(leftHeight, rightHeight) + 1;
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
