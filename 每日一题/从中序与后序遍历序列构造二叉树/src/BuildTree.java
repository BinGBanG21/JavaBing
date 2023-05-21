
import java.util.Deque;
import java.util.LinkedList;

public class BuildTree {
    public static void main(String[] args) {

    }

    //    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (postorder == null || postorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.push(root);
//        int inorderIndex = inorder.length - 1;
//        for (int i = postorder.length - 2; i >= 0; i--) {
//            int postorderVal = postorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inorderIndex]) {
//                node.right = new TreeNode(postorderVal);
//                stack.push(node.right);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex--;
//                }
//                node.left = new TreeNode(postorderVal);
//                stack.push(node.left);
//            }
//        }
//        return root;
//    }
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //把中序数组的元素值和索引记录 方便查找
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] postorder, int poBegin, int poEnd) {
        //终止条件 到叶子节点
        if (inBegin >= inEnd && poBegin >= poEnd) {
            return null;
        }
        //找到后序中最后一个元素的位置 然后拿到其索引
        int rootIndex = map.get(postorder[poEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        //拿到左子树的节点个数
        int lenOfLeft = rootIndex - inBegin;
        //生成左右子树 后序采用lenOfLeft进行切割
        root.left = traversal(inorder, inBegin, rootIndex, postorder, poBegin, poBegin + lenOfLeft);
        root.right = traversal(inorder, rootIndex + 1, inEnd, postorder, poBegin + lenOfLeft, poEnd - 1);
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