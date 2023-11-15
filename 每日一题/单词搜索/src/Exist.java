public class Exist {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        //dfs搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //中止条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        //查找完毕
        if (k == word.length - 1) {
            return true;
        }
        //递进条件 首先把当前符合的元素改为.
        board[i][j] = '.';
        //上下左右dfs
        boolean result = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        //还原为初始值
        board[i][j] = word[k];
        return result;
    }
}
