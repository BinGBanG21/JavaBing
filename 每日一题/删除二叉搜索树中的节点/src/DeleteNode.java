public class DeleteNode {
    public static void main(String[] args) {

    }

    //    public TreeNode deleteNode(TreeNode root, int key) {
//        TreeNode cur = root, curParent = null;
//        while (cur != null && cur.val != key) {
//            curParent = cur;
//            if (cur.val > key) {
//                cur = cur.left;
//            } else {
//                cur = cur.right;
//            }
//        }
//        if (cur == null) {
//            return root;
//        }
//        if (cur.left == null && cur.right == null) {
//            cur = null;
//        } else if (cur.right == null) {
//            cur = cur.left;
//        } else if (cur.left == null) {
//            cur = cur.right;
//        } else {
//            TreeNode successor = cur.right, successorParent = cur;
//            while (successor.left != null) {
//                successorParent = successor;
//                successor = successor.left;
//            }
//            if (successorParent.val == cur.val) {
//                successorParent.right = successor.right;
//            } else {
//                successorParent.left = successor.right;
//            }
//            successor.right = cur.right;
//            successor.left = cur.left;
//            cur = successor;
//        }
//        if (curParent == null) {
//            return cur;
//        } else {
//            if (curParent.left != null && curParent.left.val == key) {
//                curParent.left = cur;
//            } else {
//                curParent.right = cur;
//            }
//            return root;
//        }
//    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //5中情况 不需要遍历所有的节点 找到目标节点 然后终止递归 开始处理
        //1.没找到节点 或者说是空节点
        if (root == null) {
            return root;
        }
        //2.找到了
        if (root.val == key) {
            //2.找到了  是叶子节点
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) { //3.待删除节点有左节点
                return root.left;
            } else if (root.right != null && root.left == null) { //4.待删除节点有右节点
                return root.right;
            } else { //5.待删除节点 有左节点和右节点 我们调整搜索树 让右节点上位
                //找到右子节点的最左侧节点 把左节点挂上
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                //将右节点返回
                return root.right;
            }
        }
        //递归左右
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
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