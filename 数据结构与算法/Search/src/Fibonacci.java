/*
    斐波那契(黄金分割法)查找
        波那契数列 {1, 1, 2, 3, 5, 8, 13, 21, 34, 55 } 发现斐波那契数列的两个相邻数的比例，无限接近 黄金分割值0.618
    斐波那契(黄金分割法)原理
        斐波那契查找原理与前两种相似，仅仅改变了中间结点（mid）的位置
        mid不再是中间或插值得到，而是位于黄金分割点附近，即mid=low+F(k-1)-1
    对F(k-1)-1的理解：
        由斐波那契数列 F[k]=F[k-1]+F[k-2] 的性质，可以得到（F[k]-1）=（F[k-1]-1）+（F[k-2]-1）+1。
        该式说明：只要顺序表的长度为F[k]-1，则可以将该表分成长度为F[k-1]-1和F[k-2]-1的两段，
        从而中间位置为mid=low+F(k-1)-1
        类似的，每一子段也可以用相同的方式分割,但顺序表长度n不一定刚好等于F[k]-1
        所以需要将原来的顺序表长度n增加至F[k]-1。这里的k值只要能使得F[k]-1恰好大于或等于n即可
        顺序表长度增加后，新增的位置（从n+1到F[k]-1位置,都赋为n位置的值即可。
* */

public class Fibonacci {
    public static  int maxSize = 20;
    public static void main(String[] args) {

    }

    //因为斐波那契查找中的关键就是mid =low + F(k-1) -1 需要用到一个斐波那契数列 所以我们要先有一个斐波那契数列
    public static int[] fib(int maxSize){
        int[] arr = new int[maxSize];
        arr[0] =1;
        arr[1] = 2;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return  arr;
    }



}
