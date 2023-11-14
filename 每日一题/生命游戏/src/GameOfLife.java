public class GameOfLife {
    public static void main(String[] args) {

    }
    public void gameOfLife(int[][] board) {
        //细胞四种状态
        //死 -> 活 10
        //死 -> 死 00
        //活 -> 死 01
        //活 -> 活 11

        //死:
        //   1.活：周围8个位置 刚好有3个活细胞
        //   2.死：对上面条件取反
        //活:
        //   1.活：周围有8个位置刚好有2个或者3个活细胞
        //   2.死：上条件取反

    }
}
