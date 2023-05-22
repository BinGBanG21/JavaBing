
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //终止条件 如果找到了p q 或者 遍历到头了 那么就返回
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//        //拿到左右子树的遍历结果 然后对结果进行处理 也就是后序遍历
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        //对结果进行处理
//        if (left == null && right == null) {
//            //说明没找到
//            return null;
//        } else if (left == null && right != null) {
//            //其中一个为null 另一个找到目标值p或q 返回该值
//            //同时也处理了节点祖先为自己的特殊情况
//            return right;
//        } else if (left != null && right == null) {
//            return left;
//        } else { //找到了两个节点
//            return root;
//        }
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //后序遍历 终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        //左右节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //中节点逻辑处理
        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return root;
        }
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