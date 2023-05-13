import java.util.ArrayList;
import java.util.List;

public class Flatten {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        //创建结果链表
        List<TreeNode> result = new ArrayList<>();
        //将节点放入数组中
        preorderTraversal(root, result);
        //更改每个节点的左右指向
        int size = result.size();
        //单向链表 想更改1的指向 必须先拿到2
        //拿到后驱节点和前一个节点
        for (int i = 1; i < size; i++) {
            TreeNode pre = result.get(i - 1);
            TreeNode cur = result.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> result) {
        if (root != null) {
            result.add(root);
            preorderTraversal(root.left, result);
            preorderTraversal(root.right, result);
        }
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