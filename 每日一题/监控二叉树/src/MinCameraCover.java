

public class MinCameraCover {
    public static void main(String[] args) {

    }

    int result = 0;

    public int minCameraCover(TreeNode root) {
        //对根节点检查 防止无覆盖状态 即添加一个摄像头
        if (traversal(root) == 0) {
            result++;
        }
        return result;
    }

    //节点3个状态
    // 0 无覆盖 1 有摄像头  2 有覆盖
    public int traversal(TreeNode node) {
        //遍历到叶子节点终止 叶子节点全不放摄像头
        if (node == null) {
            return 2;
        }
        //后序遍历
        int left = traversal(node.left);
        int right = traversal(node.right);
        //处理逻辑
        //1 左右子节点都被覆盖 那么父节点无需摄像头 而需要在父节点的上衣节点放摄像头 此时父节点为无覆盖
        if (left == 2 && right == 2) {
            return 0;
        }
        //2 左右子节点至少有一个没被覆盖 那么父节点必须放一个摄像头
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        //3 左右子节点至少有一个摄像头 那么父节点被覆盖
        if (left == 1 || right == 1) {
            return 2;
        }
        return 4;
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