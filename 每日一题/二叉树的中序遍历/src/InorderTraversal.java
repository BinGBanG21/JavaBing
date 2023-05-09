
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {

    }

    //    public List<Integer> inorderTraversal(TreeNode root) {
//        //递归的逻辑其实可以用栈去模拟 函数递归 开执行栈 然后栈顶先执行
//        //但是没有那么简单 所以比较简单的递归 我们可以使用栈去模拟
//        //思路：因为中序遍历 先处理左
//        //一直循环直到左边节点都加入到栈中
//        //然后开始填充返回的List 先把左节点加入
//        List<Integer> list = new ArrayList<>();
//        //创建栈 用来管理node
//        Stack<TreeNode> stack = new Stack<>();
//        //循环 先添加左节点到栈中
//        while (stack.size() > 0 || root != null) {
//            //向栈中添加节点 很关键的一步
//            if (root != null) {
//                stack.add(root);
//                root = root.left;
//            } else { //从栈中输出结果
//                TreeNode res = stack.pop();
//                list.add(res.val);
//                //很关键的一步 如果root节点没有右节点 那么就为null 那么会继续弹栈
//                //如果当前节点有右节点 那就不做弹栈操作 先做入栈
//                root = res.right;
//            }
//        }
//        return list;
//    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        //创建结果
//        List<Integer> result = new ArrayList<>();
//        inOrder(root, result);
//        return result;
//    }
//
//    public void inOrder(TreeNode cur, List<Integer> result) {
//        //终止条件
//        if (cur == null) {
//            return;
//        }
//        //左 右 中
//        inOrder(cur.left, result);
//        result.add(cur.val);
//        inOrder(cur.right, result);
//    }

    //    public List<Integer> inorderTraversal(TreeNode root) {
//        //创建结果
//        List<Integer> result = new ArrayList<>();
//        //参数处理
//        if (root == null) {
//            return result;
//        }
//        //创建栈 用来模拟递归
//        Stack<TreeNode> stack = new Stack<>();
//        //中序遍历其实可以把root节点归为左节点
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            //收集左子树
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                //处理左子树 弹栈 收集结果
//                cur = stack.pop();
//                result.add(cur.val);
//                //处理右子树
//                cur = cur.right;
//            }
//        }
//        return result;
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //创建结果
        List<Integer> result = new ArrayList<>();
        //创建用于迭代的栈
        Stack<TreeNode> st = new Stack<>();
        //参数处理
        if (root != null) {
            //先将root加入栈中
            st.push(root);
        }
        //迭代
        while (!st.isEmpty()) {
            //拿到栈顶元素
            TreeNode node = st.peek();
            //收集元素 右-中-左
            if (node != null) {
                st.pop();//避免重复处理
                if (node.right != null) {
                    st.push(node.right);
                }
                st.push(node);
                st.push(null);
                if (node.left != null) {
                    st.push(node.left);
                }
            } else {
                st.pop();//避免重复处理
                //收集值
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    public class TreeNode {
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
