public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    //    public TreeNode traversal(int[] nums, int left, int right) {
//        //思路：找到中间值 保证左右节点树木相同 然后递归构建root left right 节点
//        //终止条件: 区间内只有一个节点 将节点放好后 mid会-1 此时left < right 证明已经构建完成 递归结束
//        if (left > right) {
//            return null;
//        }
//        //拿到数组中间值 创建根节点
//        int mid = (left + right) / 2;
//        //创建根节点
//        TreeNode root = new TreeNode(nums[mid]);
//        //递归创建左右子树
//        root.left = traversal(nums, left, mid - 1);
//        root.right = traversal(nums, mid + 1, right);
//        return root;
//    }
    public TreeNode traversal(int[] nums, int left, int right) {
        //判断数组切割完毕  那么节点就是null
        if (left > right) {
            return null;
        }
        //防止越界
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构造左右子树
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
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