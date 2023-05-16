public class SumOfLeftLeaves {
    public static void main(String[] args) {

    }
//    public int sumOfLeftLeaves(TreeNode root) {
//        return root != null ? dfs(root) : 0;
//    }
//
//    public int dfs(TreeNode node) {
//        int ans = 0;
//        if (node.left != null) {
//            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
//        }
//        if (node.right != null && !isLeafNode(node.right)) {
//            ans += dfs(node.right);
//        }
//        return ans;
//    }
//
//    public boolean isLeafNode(TreeNode node) {
//        return node.left == null && node.right == null;
//    }
    public int sumOfLeftLeaves(TreeNode root){
        //终止条件
        if (root == null) {
            return 0;
        }
        //后序遍历
        int leftNum = sumOfLeftLeaves(root.left);
        int rightNum = sumOfLeftLeaves(root.right);
        //找到叶子节点的父节点 然后拿到左子节点的值
        int midVal = 0; //记录左边的值
        if(root.left != null && root.left.left == null && root.left.right == null){
            midVal = root.left.val;
        }
        //中间节点处理
        return leftNum + rightNum + midVal;
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