public class Trie {

    public static void main(String[] args) {

    }

    class TreeNode {
        //是否是一个单词 遍历单词 存放结束后改为true
        boolean isWord = false;
        //孩子节点
        TreeNode[] children;

        public TreeNode() {
            //本题是a-z
            children = new TreeNode[26];
        }
    }

    //根节点
    TreeNode root;

    public Trie() {
        root = new TreeNode();

    }

    public void insert(String word) {
        //拿到根节点 然后向下记录单词
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //查看对应数组中是否存在
            int index = c - 'a';
            //如果不存在 那么创建节点 也就是相当于+1
            if (curr.children[index] == null) {
                curr.children[index] = new TreeNode();
            }
            //如果存在 指向下一格 其实就是把当前指针向下移动  继续比较
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        //拿到根节点 然后向下查询
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //查看对应数组中是否存在
            int index = c - 'a';
            //如果为null说明查不到单词
            if (curr.children[index] == null) {
                return false;
            }
            //如果存在 指向下一格 其实就是把当前指针向下移动  继续比较
            curr = curr.children[index];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
