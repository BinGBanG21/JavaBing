public class Rob {
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robHelper(TreeNode root) {
        //初始化dp数组 dp数组的长度为2 dp[4,2] 0表示不偷 1表示偷
        int[] res = new int[2];
        //采用后序遍历 终止条件
        if (root == null) {
            return res;
        }
        //左右中 中间节点进行逻辑处理
        int[] leftDp = robHelper(root.left);
        int[] rightDp = robHelper(root.right);
        //偷当前的根节点 那么子节点不在考虑范围内
        res[1] = root.val + leftDp[0] + rightDp[0];
        //不偷当前节点 那么考虑范围包括子节点 那么拿到考虑左右子节点的最大值
        res[0] = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        return res;
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