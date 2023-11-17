

public class MaxPathSum {
    public static void main(String[] args) {

    }

    //全局最大值 考虑val为负数的情况
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //对于一个节点来说 向上被一个父节点连接 连接左右两个子节点
        //路径的特点：途径一个节点只能选择两个方向
        //路径的可能情况有3种：左中右 左中上 右中上
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        //计算左右子节点能贡献的最大值 如果值为负数 我们+0表示忽略这个节点
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        //计算左中右的值
        int lmr = node.val + leftGain + rightGain;


        //计算左中右和左上右上的最大值
        maxSum = Math.max(maxSum, lmr);

        //返回该节点作为路径的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
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