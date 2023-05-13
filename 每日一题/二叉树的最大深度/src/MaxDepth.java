public class MaxDepth {
    public static void main(String[] args) {

    }

    //    public int maxDepth(TreeNode root) {
//        if( root == null ){
//            return 0;
//        }
//        int leftHeight = maxDepth(root.left);
//        int rightHeight = maxDepth(root.right);
//        return 1 + Math.max(leftHeight,rightHeight);
//    }
    public int maxDepth(TreeNode root) {
        //根节点的深度和高度是一样的 所以本题采用高度的后序遍历
        if (root == null) {
            return 0;
        }
        //递归都是一样的 二叉数的遍历大多数都是在后序 然后处理逻辑在中间节点
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }


    public static class TreeNode {
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
}
