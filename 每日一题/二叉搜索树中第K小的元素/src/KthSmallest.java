
public class KthSmallest {
    public static void main(String[] args) {

    }

    int count = 0;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        //因为是二叉搜索树 所以满足左<中<右
        //对二叉搜索树进行中序遍历 同时记录count = k 即为第K小的元素
        inorderTraversal(root, k);
        return res;
    }

    public void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, k);
        count++;
        if (count == k) {
            res = node.val;
            return;
        }
        inorderTraversal(node.right, k);

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