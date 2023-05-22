public class TrimBST {
    public static void main(String[] args) {

    }

//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        while (root != null && (root.val < low || root.val > high)) {
//            if (root.val < low) {
//                root = root.right;
//            } else {
//                root = root.left;
//            }
//        }
//        if (root == null) {
//            return null;
//        }
//        for (TreeNode node = root; node.left != null; ) {
//            if (node.left.val < low) {
//                node.left = node.left.right;
//            } else {
//                node = node.left;
//            }
//        }
//        for (TreeNode node = root; node.right != null; ) {
//            if (node.right.val > high) {
//                node.right = node.right.left;
//            } else {
//                node = node.right;
//            }
//        }
//        return root;
//    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        //终止条件
        if (root == null) {
            return null;
        }
        //利用搜索树的特性 递归处理左右子树
        if (root.val < low) {  //还要看一下右节点有没有符合条件的
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
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