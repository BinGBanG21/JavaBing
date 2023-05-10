
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {

    }

    //    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        if (root == null) {
//            return ret;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<Integer>();
//            int currentLevelSize = queue.size();
//            for (int i = 1; i <= currentLevelSize; ++i) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            ret.add(level);
//        }
//
//        return ret;
//    }
    //借助队列完成层序遍历
    //创建结果数组
    public List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        check(root);
        return result;
    }

    public void check(TreeNode node) {
        //创建用于迭代的队列
        Queue<TreeNode> que = new LinkedList<>();
        //将节点加入队列
        if (node != null) {
            que.offer(node);
        }
        //迭代
        while (!que.isEmpty()) {
            //创建结果一维数组
            List<Integer> itemResult = new ArrayList<>();
            //计算队列的长度
            int len = que.size();
            while (len > 0) {
                //将该节点弹出 然后收集结果 将其左右节点加入队列
                TreeNode cur = que.poll();
                itemResult.add(cur.val);
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
                len--;
            }
            //每次while循环 遍历一个层级
            result.add(itemResult);
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