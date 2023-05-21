
import java.util.ArrayList;
import java.util.List;

public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {

    }

//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        int n = nums.length;
//        List<Integer> stack = new ArrayList<Integer>();
//        TreeNode[] tree = new TreeNode[n];
//        for (int i = 0; i < n; ++i) {
//            tree[i] = new TreeNode(nums[i]);
//            while (!stack.isEmpty() && nums[i] > nums[stack.get(stack.size() - 1)]) {
//                tree[i].left = tree[stack.get(stack.size() - 1)];
//                stack.remove(stack.size() - 1);
//            }
//            if (!stack.isEmpty()) {
//                tree[stack.get(stack.size() - 1)].right = tree[i];
//            }
//            stack.add(i);
//        }
//        return tree[stack.get(0)];
//    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length);
    }

    public TreeNode construct(int[] nums, int leftIndex, int rightIndex) {
        //生成树 都采用前序遍历
        //终止条件
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        //叶子节点
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        //中 假设第一个元素为最大值
        int maxIndex = leftIndex;
        int maxValue = nums[leftIndex];
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }

        }
        TreeNode root = new TreeNode(maxValue);
        //左右
        root.left = construct(nums, leftIndex, maxIndex);
        root.right = construct(nums, maxIndex + 1, rightIndex);
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