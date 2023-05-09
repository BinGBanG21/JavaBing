
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    //    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        if (root == null) {
//            return res;
//        }
//
//        TreeNode p1 = root, p2 = null;
//
//        while (p1 != null) {
//            p2 = p1.left;
//            if (p2 != null) {
//                while (p2.right != null && p2.right != p1) {
//                    p2 = p2.right;
//                }
//                if (p2.right == null) {
//                    res.add(p1.val);
//                    p2.right = p1;
//                    p1 = p1.left;
//                    continue;
//                } else {
//                    p2.right = null;
//                }
//            } else {
//                res.add(p1.val);
//            }
//            p1 = p1.right;
//        }
//        return res;
//    }
//    二叉树前序遍历 递归
//    public List<Integer> preorderTraversal(TreeNode root) {
//        //创建结果
//        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);
//        return result;
//    }
//
//    public void preOrder(TreeNode cur, List result) {
//        //终止条件
//        if (cur == null) {
//            return;
//        }
//        //前序 中左右
//        result.add(cur.val);
//        preOrder(cur.left, result);
//        preOrder(cur.right, result);
//    }
    //迭代法
//    public List<Integer> preorderTraversal(TreeNode root) {
//        //创建结果
//        List<Integer> result = new ArrayList<>();
//        //参数处理
//        if (root == null) {
//            return result;
//        }
//        //使用栈 模拟递归
//        Stack<TreeNode> stack = new Stack<>();
//        //把根节点放入 然后开始迭代
//        stack.push(root);
//        //前中后
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            result.add(node.val);
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//        }
//        return result;
//    }
    //统一迭代法
    //之前的写法不统一 根本原因是因为访问节点和处理节点顺序不一致
    //比方说中序遍历 那么最先访问的节点是中间节点 但是处理的时候处理的是左节点
    //那么就需要一种方法记录中间节点 但是不处理 这也就是为什么交标记法
    public List<Integer> preorderTraversal(TreeNode root) {
        //创建结果
        List<Integer> result = new ArrayList<>();
        //创建栈
        Stack<TreeNode> stack = new Stack<>();
        //参数处理
        if (root != null) {
            stack.push(root);
        }
        //迭代处理
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                //先将改节点弹出 避免重复操作
                stack.pop();
                //如果节点不为null 那么加入右左中节点
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            }else{ //遇到待处理节点 先将null弹出 然后重新赋值node
                stack.pop();
                node= stack.peek();
                stack.pop(); //弹出 避免重复操作
                result.add(node.val);
            }
        }
        return result;
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
