public class ConvertBST {
    public static void main(String[] args) {

    }

    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        //我们采用右-中-左遍历方式 实现累加
        if (root == null) { //找到了叶子节点
            return;
        }
        //递进条件 右边
        traversal(root.right);
        //处理中间
        root.val += sum;
        //记录pre的值 并且后移  其实就是更改sum的值
        sum = root.val;
        //处理左边
        traversal(root.left);
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