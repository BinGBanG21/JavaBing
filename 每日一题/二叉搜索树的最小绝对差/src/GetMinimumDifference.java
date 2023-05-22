
public class GetMinimumDifference {


    public static void main(String[] args) {

    }

    //结果
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    public void traversal(TreeNode cur) {
        //双指针 前序遍历
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null) {
            result = Math.min(result, cur.val - pre.val);
        }
        pre = cur;
        traversal(cur.right);
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