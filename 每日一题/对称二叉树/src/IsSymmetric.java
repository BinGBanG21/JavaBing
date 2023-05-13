

public class IsSymmetric {
    public static void main(String[] args) {

    }

    //    public boolean isSymmetric(TreeNode root) {
//        return check(root, root);
//    }
//
//    public boolean check(TreeNode left, TreeNode right) {
//        //递归的终止条件
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null) {
//            return false;
//        }
//        //递归 继续比较  当前节点的值  左节点的左孩子和右节点的右孩子 左节点的右孩子和右节点的左孩子
//        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
//    }
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        //节点数量不对称
        if (left == null && right != null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        } else if (left == null && right == null) { //都为null
            return true;
        } else if (left.val != right.val) { //节点数量一样 不为空 值不相等
            return false;
        } else {
            boolean outSide = compare(left.left, right.right);
            boolean inSide = compare(left.right, right.left);
        }
        boolean result = outSide && inSide;
        return result;
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