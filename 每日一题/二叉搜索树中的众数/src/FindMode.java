import java.util.ArrayList;
import java.util.List;

public class FindMode {
    public static void main(String[] args) {

    }

    ArrayList<Integer> resList;
    int count = 0;
    int maxCount = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        //对ArrayList结果处理
        traversal(root);
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }

    public void traversal(TreeNode cur) {
        //中序遍历
        //终止条件
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        //中节点处理逻辑
        if (pre == null || pre.val != cur.val) {
            count = 1;
        } else {
            count++;
        }
        //对统计完的count进行判断
        if (count > maxCount) {
            resList.clear();
            maxCount = count;
            resList.add(cur.val);
        } else if (count == maxCount) {
            resList.add(cur.val);
        }
        pre = cur;
        traversal(cur.right);
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