
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //奇数层从左往右 偶数层从右往左
        //创建用于层序遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        //结果
        List<List<Integer>> res = new ArrayList<>();

        //开始层序遍历 将根节点加入队列
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //保存单次结果 模拟双端队列 偶数从右往左 加入开头 奇数相反
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                //弹出节点
                TreeNode node = queue.poll();
                //利用res判断 初始res为0 是第一层 所以我们要加入尾部
                if (res.size() % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    //偶数
                    temp.addFirst(node.val);
                }
                //接着处理左右节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
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