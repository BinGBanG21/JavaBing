
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public static void main(String[] args) {

    }

    //和正常的遍历顺序相比 我们要多遍历一层 来区分左右孩子

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rDeserialize(dataList);
    }

    public String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right, str);
        }
        return str;
    }

    public TreeNode rDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rDeserialize(dataList);
        root.right = rDeserialize(dataList);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}