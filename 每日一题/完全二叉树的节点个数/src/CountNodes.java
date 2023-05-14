public class CountNodes {
    public static void main(String[] args) {

    }

    //使用完全二叉树的特性来解题
    //查询节点的左右子树高度 如果相等就使用 2 n次方 - 1计算以当前节点为根节点的子树节点数量
    //省去了遍历中间节点
    public int countNodes(TreeNode root) {
        //终止条件
        if (root == null) {
            return 0;
        }
        //如果左右子树高度一致 也终止
        int leftNum = 0;
        int rightNum = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left = left.left;
            leftNum++;
        }
        while (right != null) {
            right = right.right;
            rightNum++;
        }
        if (leftNum == rightNum) {
            return (2 << leftNum) - 1;
        }
        //递进 后序遍历
        int countLeft = countNodes(root.left);
        int countRight = countNodes(root.right);
        return 1 + countLeft + countRight;
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