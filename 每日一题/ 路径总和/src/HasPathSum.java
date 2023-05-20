

public class HasPathSum {
    //递归
    //递进条件 每一个节点及其左右子节点看成一部分
    public static void main(String[] args) {

    }

    //    public boolean hasPathSum(TreeNode root, int sum) {
//        //空树 直接return
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            return sum == root.val;
//        }
//        //递进条件 root节点两条路走下去 走一次减一个节点
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ){
            return false;
        }
        //减去中间节点的值
        return traversal(root, sum - root.val);
    }

    public boolean traversal(TreeNode node, int count) {
        //叶子节点终止
        if (node.left == null && node.right == null && count == 0) {
            return true;
        }
        if (node.left == null && node.right == null && count != 0){
            return false;
        }
        //单层递归的逻辑 左右节点
        if (node.left != null) {
            //减去当前节点的值
            count -= node.left.val;
            if (traversal(node.left, count) == true) {
                return true;
            }
            count += node.left.val;
        }
        if (node.right != null) {
            //减去当前节点的值
            count -= node.right.val;
            if (traversal(node.right, count) == true) {
                return true;
            }
            count += node.right.val;
        }
        return false;
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