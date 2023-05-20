import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftValue {
    public static void main(String[] args) {

    }

//    public int findBottomLeftValue(TreeNode root) {
//        int ret = 0;
//        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode p = queue.poll();
//            if (p.right != null) {
//                queue.offer(p.right);
//            }
//            if (p.left != null) {
//                queue.offer(p.left);
//            }
//            ret = p.val;
//        }
//        return ret;
//    }
    int dep = -1;
    int result;
    public int findBottomLeftValue(TreeNode root){
        return traversal(root);
    }
    public int traversal( TreeNode node, int depth){
        //终止条件
        if (node.left == null && node.right == null) {
            if (depth > dep) {
                //更新深度 记录值
                dep = depth;
                result = node.val;
            }
        }
        //递进条件
        if (node.left != null) {
            depth++;
            traversal(node.left,depth);
            depth--;
        }
        if (node.right != null) {
            depth++;
            traversal(node.right,depth);
            depth--;
        }
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