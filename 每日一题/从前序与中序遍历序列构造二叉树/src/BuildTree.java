import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //拿到两个数组的长度
        int preLen = preorder.length;
        int inLen = inorder.length;

        //判断数组长度是否合法
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data");
        }

        //创建map结构 储存节点对应的下标
        Map<Integer, Integer> map = new HashMap<>(preLen);

        //找到根元素 然后依据根元素在后序数组中的位置 划分左右子树 所以要储存的是后续数组中的索引
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preLen - 1, map, 0, inLen - 1);

    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        //递归 退出条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        //递进条件
        //找到根元素 并且创建根节点
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        //然后根据根节点的索引 划分左右子树 创建
        //中序拿个数 前序划分 找根节点
        int pIndex = map.get(rootValue);
        root.left = build(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = build(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }

    static class TreeNode {
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

}
