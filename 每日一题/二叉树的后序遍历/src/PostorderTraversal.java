import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {

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

//    public List<Integer> postorderTraversal(TreeNode root) {
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
//                    p2.right = p1;
//                    p1 = p1.left;
//                    continue;
//                } else {
//                    p2.right = null;
//                    addPath(res, p1.left);
//                }
//            }
//            p1 = p1.right;
//        }
//        addPath(res, root);
//        return res;
//    }

    //    public List<Integer> postorderTraversal(TreeNode root) {
//        //创建结果数组
//        List<Integer> result = new ArrayList<>();
//        postOrder(root,result);
//        return result;
//    }
//
//    public void postOrder(TreeNode cur, List<Integer> result) {
//        //终止条件
//        if (cur == null) {
//            return;
//        }
//        //左-右-中
//        postOrder(cur.left, result);
//        postOrder(cur.right, result);
//        result.add(cur.val);
//    }
    //迭代法 后序和前序差不多 最后要翻转结果数组
//    public List<Integer> postorderTraversal(TreeNode root) {
//        //创建结果数组
//        List<Integer> result = new ArrayList<>();
//        //参数处理
//        if (root == null) {
//            return result;
//        }
//        //创建栈结构 用来迭代
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        //入栈顺序 中-左-右 出栈 中-右-左 翻转结果数组达到 左-右-中
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            result.add(node.val);
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//        }
//        Collections.reverse(result);
//        return result;
//    }
    //统一迭代法
    public List<Integer> postorderTraversal(TreeNode root) {
        //创建结果数组
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        //参数处理
        if (root != null) {
            st.push(root);
        }
        //开始迭代
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) { //收集元素
                st.pop();//弹出元素 避免重复
                //中-右-左
                st.push(node);
                st.push(null);
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
            } else {
                st.pop();//弹出null
                node = st.peek();//保存元素
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }
}
