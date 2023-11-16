public class PathSum {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        //思路：先找从根节点出发到叶子节点的 在遍历的时候带一个参数 当node == null计算总和
        //     从根节点出发 每遍历一个节点 就计算总和 比较 -> 根节点到任意节点
        //     把任意一个节点当作根节点 —> 不以根节点开始 不以叶子节点结束
        if (root == null) {
            return 0;
        }

        //把每个节点都当作根节点(即题目中的可以不以根节点开始)
        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    //以当前节点为根节点 计算到任意节点的值是否=targetSum
    public int rootSum(TreeNode root, long targetSum) {
        int res = 0;

        //路径可以为1个节点
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            res++;
        }

        //左右当作根节点去遍历
        res += rootSum(root.left, targetSum - val);
        res += rootSum(root.right, targetSum - val);
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