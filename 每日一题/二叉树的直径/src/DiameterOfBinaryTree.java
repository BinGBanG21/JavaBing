

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    int maxDep = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        //个人感觉其实就是求最大深度
        depth(root);
        return maxDep;
    }

    public int depth(TreeNode node) {
        //如果左右节点为null  那么深度为0
        if (node == null) {
            return 0;
        }

        int leftDep = depth(node.left);
        int rightDep = depth(node.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        //穿过根节点和不穿过根节点比较 并记录最大值
        maxDep = Math.max(leftDep + rightDep, maxDep);
        //返回当前节点深度 用于计算父节点深度
        return Math.max(leftDep, rightDep) + 1;

    }

    public class TreeNode {
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
