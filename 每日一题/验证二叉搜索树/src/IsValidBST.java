public class IsValidBST {
    public static void main(String[] args) {

    }

    //可以把二叉树前序遍历 放到一个数组中 然后去判断数组是否递增
    //优化：在遍历的过程中直接比较 方法：全局变量一个最小的值去进行比较 然后赋值
    //缺点：可能和二叉树最左侧节点的值相等
    //双指针法 全局变量记录的是前一个节点的值 利用双指针记录上一个节点 节点之间相互比较
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        //终止条件
        //如果到叶子节点还没有return 那么表明是合法二叉树
        if (root == null) {
            return true;
        }
        //前序
        boolean left = isValidBST(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
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