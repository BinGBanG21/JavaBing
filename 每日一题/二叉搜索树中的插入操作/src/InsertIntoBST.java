public class InsertIntoBST {
    public static void main(String[] args) {

    }

    //    public TreeNode insertIntoBST(TreeNode root, int val) {
//        //因为是二叉搜索树 所以想插入任意一个节点 都可以在其叶子节点中找到他正确的位置
//        if (root == null) {
//            //说明找到了位置
//            TreeNode newNode = new TreeNode(val);
//            return newNode;
//        }
//        //规定路线 并且连接节点
//        if (root.val > val) {
//            root.left = insertIntoBST(root.left, val);
//        }
//        if (root.val < val) {
//            root.right = insertIntoBST(root.right, val);
//        }
//        return root;
//    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //任何一棵二叉搜索树 都可以在其叶子节点找到其正确位置
        if (root == null) {
            //创建节点 返回给上一层
            TreeNode node = new TreeNode(val);
            return node;
        }
        //根据val判断是左节点还是右节点
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
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