
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {

    }

    //    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> paths = new ArrayList<String>();
//        constructPaths(root, "", paths);
//        return paths;
//    }
//
//    public void constructPaths(TreeNode root, String path, List<String> paths) {
//        if (root != null) {
//            StringBuffer pathSB = new StringBuffer(path);
//            pathSB.append(Integer.toString(root.val));
//            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
//                paths.add(pathSB.toString());  // 把路径加入到答案中
//            } else {
//                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
//                constructPaths(root.left, pathSB.toString(), paths);
//                constructPaths(root.right, pathSB.toString(), paths);
//            }
//        }
//    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        //对参数进行判断
        if (root == null) {
            return result;
        }
        //存放每个结果的数组
        List<Integer> itemResult = new ArrayList<>();
        traversal(root, itemResult, result);
        return result;

    }

    //根节点 以及两个结果数组N
    public void traversal(TreeNode node, List<Integer> path, List<String> result) {
        //前序遍历 为了不落下叶子节点 我们要在终止条件之前处理中节点
        path.add(node.val);
        //终止条件 到叶子节点终止
        if (node.left == null && node.right == null) {
            //说明收集完了一条陆警官 记录结果 返回
            //将path转成字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            //拼接最后一个字符
            sb.append(path.get(path.size() - 1));
            //收集路径
            result.add(sb.toString());
            return;
        }
        //左右节点
        if (node.left != null) {
            traversal(node.left, path, result);
            //回溯 弹出结果
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            traversal(node.right, path, result);
            //回溯 弹出结果
            path.remove(path.size() - 1);
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