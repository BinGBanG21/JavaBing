public class MinDepth {
    public static void main(String[] args) {

    }

    //    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//
//        int min_depth = Integer.MAX_VALUE;
//        if (root.left != null) {
//            min_depth = Math.min(minDepth(root.left), min_depth);
//        }
//        if (root.right != null) {
//            min_depth = Math.min(minDepth(root.right), min_depth);
//        }
//
//        return min_depth + 1;
//    }
    //最小深度
    public int minDepth(TreeNode root) {
        //参数处理
        if (root == null) {
            return 0;
        }
        //终止条件 遍历完毕
        if (root.left == null && root.right == null) {
            return 1;
        }
        //定义最大深度
        int minDep = Integer.MAX_VALUE;
        //递进条件 后序遍历 左右中
        //要进行非空判断 否则只有左子树或者右子树 就会出错
        if (root.left != null) {
            minDep = Math.min(minDepth(root.left), minDep);
        }
        if (root.right != null) {
            minDep = Math.min(minDepth(root.right), minDep);
        }
        return 1 + minDep;
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