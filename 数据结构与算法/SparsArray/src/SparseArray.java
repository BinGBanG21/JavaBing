/*
    稀疏数组 SparseArray
        应用场景
           编写的五子棋程序中，有存盘退出和续上盘的功能
           因为五子棋的棋盘是一个二维数组 但是我们落子的地方占棋盘的很少部分
           故导致该二维数组的很多值是默认值0, 因此记录了很多没有意义的数据.
           如何解决呢？ --- 稀疏数组
        基本介绍
           当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
        稀疏数组的处理方法是:
           记录数组一共有几行几列，有多少个不同的值[0]
           然后一次记录改数字的行列（类似坐标）及其具体的值
           注意 因为是二维数组 所以坐标是和索引一样 从0开始的
           具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
        二维数组转稀疏数组的思路
           1.遍历原始的二维数组，得到有效数据的个数sum（因为要初始化数组的长度）
           2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
             行数为有效数值的个数+1（总体数量 且第一行为总的统计的值）
             列数为固定的3个属性：row col val
           3.将二维数组的有效数据数据存入到稀疏数组
        稀疏数组转原始的二维数组的思路
           1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2=int[11][11]
           2.在读取稀疏数组后几行的数据，并赋给原始的二维数组即可



* */

public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组的棋盘 11*11
        int[][] chessArr = new int[11][11];
        //给数组赋值（记录棋子的位置  0为空白  1为黑子  2为白子）
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //打印当前数组
        System.out.println("二维数组如下===================");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d \t", data);
            }
            System.out.println();
        }

        //先遍历二维数组 将有效数据记录到稀疏数组中
        //记录有效数据的个数 创建稀疏数组
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组并记录有效数字
        int[][] sparseArr = new int[sum + 1][3];
        //初始化二维数组的第一行
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum; // 统计数据的个数


        //记录是第几个非零数据 稀疏数组中的每一个内层数组都是一个数据的属性
        int sparseRow = 1;

        //第二次循环 在稀疏数组中记录数据
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    //对稀疏数组赋值
                    sparseArr[sparseRow][0] = i;
                    sparseArr[sparseRow][1] = j;
                    sparseArr[sparseRow][2] = chessArr[i][j];
                    sparseRow++;

                }
            }
        }
        //打印稀疏数组
        System.out.println("稀疏数组如下===================");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d \t", data);
            }
            System.out.println();
        }


        //将稀疏数组转化成二维数组
        int rowLen = sparseArr[0][0];
        int colLen = sparseArr[0][1];

        //记录原数组的坐标 赋值的时候用到
        int rawRow = 0;
        int rawCol = 0;

        //创建二维数组并且赋值
        int [][] rawArr = new int[rowLen][colLen];

        for (int i = 1; i <sparseArr.length ; i++) {
            rawRow= sparseArr[i][0];
            rawCol = sparseArr[i][1];
            rawArr[rawRow][rawCol] = sparseArr[i][2];
        }

        //打印复原的二维数组
        System.out.println("复原的二维数组如下===================");
        for (int[] row : rawArr) {
            for (int data : row) {
                System.out.printf("%d \t", data);
            }
            System.out.println();
        }


    }
}
