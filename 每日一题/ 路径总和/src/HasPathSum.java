

public class HasPathSum {
    //递归
    //递进条件 每一个节点及其左右子节点看成一部分
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        //空树 直接return
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        //递进条件 root节点两条路走下去 走一次减一个节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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