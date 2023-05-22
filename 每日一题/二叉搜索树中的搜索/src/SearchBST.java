public class SearchBST {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        //前序遍历
        //终止条件
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode result = null;
        //单层递归的条件
        if (root.val > val) {
            result = searchBST(root.left, val);
        }
        if (root.val < val) {
            result = searchBST(root.right, val);
        }
        return result;
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