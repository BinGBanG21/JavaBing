
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    //    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        if (root == null) {
//            return res;
//        }
//
//        TreeNode p1 = root, p2 = null;
//
//        while (p1 != null) {
//            p2 = p1.left;
//            if (p2 != null) {
//                while (p2.right != null && p2.right != p1) {
//                    p2 = p2.right;
//                }
//                if (p2.right == null) {
//                    res.add(p1.val);
//                    p2.right = p1;
//                    p1 = p1.left;
//                    continue;
//                } else {
//                    p2.right = null;
//                }
//            } else {
//                res.add(p1.val);
//            }
//            p1 = p1.right;
//        }
//        return res;
//    }
    //二叉树前序遍历 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        //创建结果
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode cur, List result) {
        //终止条件
        if (cur == null) {
            return;
        }
        //前序 中左右
        result.add(cur.val);
        preOrder(cur.left, result);
        preOrder(cur.right, result);
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
