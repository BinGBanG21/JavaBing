import java.lang.reflect.Array;

/*
    递归-八皇后问题(回溯算法)
        八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：
        在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
        即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
    八皇后问题算法思路分析
        1.第一个皇后先放第一行第一列
        2.第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
        3.继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
        4.当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
        5.然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
    说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题.
         arr[8] = {0, 4, 7, 5, 2, 6, 1, 3} //对应arr 下标 表示第几行，即第几个皇后，
         arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列

* */
public class EightQueens {
    int max = 8; //定义皇后的数量
    int[] array = new int[8];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.putAndCheck(0);
        System.out.printf("一共有%s种写法,判断了%d次", count,judgeCount);
    }

    //在n行放置第n个皇后
    public void putAndCheck(int n) {
        if (n == 8) { //说明皇后放置完毕 已经有了一种答案 打印输出即可
            print();
            return;
        }
        //开始放置 如果不冲突就放下一个皇后 n递增 如果冲突 就放下一列 i递增
        for (int i = 0; i < 8; i++) {
            //先把皇后放到该行的第一列 判断是否冲突
            //不冲突放下一个 冲突的话i会自增 接着向后放置
            array[n] = i;
            if (judge(n)) {
                putAndCheck(n + 1);
            }
        }


    }

    //当摆放第n个皇后时 把这个皇后个前面所有的皇后进行冲突检测 注意 n不是总数
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //结果中的一维数组 索引表示行数 值表示列数 因为一行只放一个皇后且数组中索引是递增的 n也是递增的 所以不用考虑在一行的情况
            //如果在同一直线或者同一斜线上 就冲突 如何判定同一直线 ：行 - 行 = 列 - 列 注意处理用abs
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        //如果不冲突
        return true;
    }


    //统计并打印输出皇后的情况
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
