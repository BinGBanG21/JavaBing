

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //一共3种情况 > < =
//        if (root.val > p.val && root.val > q.val) {
//            //向左走
//            return lowestCommonAncestor(root.left, p, q);
//        }
//        if (root.val < p.val && root.val < q.val) {
//            //向右走
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        //如果root在pq之间 说明正好是最近的公共祖先
//        return root;
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}