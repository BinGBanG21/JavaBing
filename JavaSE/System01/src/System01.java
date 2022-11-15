import java.math.BigInteger;
import java.util.Arrays;

/*
    System 类常见方法
        1）exit退出当前程序
        2）arraycopy∶复制数组元素，比较适合底层调用，一般使用Arrays.copyof完成复制数组.
           int[]src={1,2,3};int[]dest=new Int[3];
           System.arraycopy(src, 0, dest, 0, 3);
        3）currentTimeMillens∶返回当前时间距离1970-1-1的毫秒数
        4）gc∶运行垃圾回收机制System.gc（）；
    BigInteger 和 BigDecimal
        应用场景
        1）BigInteger适合保存比较大的整型
        2）BigDecimal适合保存精度更高的浮点型（小数）



* */
public class System01 {
    public static void main(String[] args) {
        //exit 退出当前程序
        System.out.println("ok1");

        //1. exit(0) 表示程序退出
        //2. 0 表示一个状态 , 正常的状态
        System.exit(0);
        System.out.println("ok2");
        //arraycopy ：复制数组元素，比较适合底层调用，
        // 一般使用 Arrays.copyOf 完成复制数组
        int[] src = {1, 2, 3};
        int[] dest = new int[3];// dest 当前是 {0,0,0}

        //1. 五个参数的含义
        //2. // 源数组
        // * @param     src         the source array.
        //   srcPos： 从源数组的哪个索引位置开始拷贝
        // * @param     srcPos      starting position in the source array.
        //   dest : 目标数组，即把源数组的数据拷贝到哪个数组
        // * @param     dest        the destination array.
        //   destPos: 把源数组的数据拷贝到 目标数组的哪个索引
        // * @param     destPos     starting position in the destination data.
        //   length: 从源数组拷贝多少个数据到目标数组
        // * @param     length      the number of array elements to be copied.
        //   System.arraycopy(src, 0, dest, 0, src.length);
        //   int[] src={1,2,3};
        System.out.println("dest=" + Arrays.toString(dest));//[1, 2, 3]
        //currentTimeMillens:返回当前时间距离 1970-1-1 的毫秒数

        System.out.println(System.currentTimeMillis());

        //当我们编程中，需要处理很大的整数，long 不够用
        //可以使用 BigInteger 的类来搞定
        // long l = 23788888899999999999999999999l;
        // System.out.println("l=" + l);
        BigInteger bigInteger = new BigInteger("23788888899999999999999999999");
        BigInteger bigInteger2 = new BigInteger("10099999999999999999999999999999999999999999999999999999999999999999999999999999999");
        System.out.println(bigInteger);
        //说明
        //1. 在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
        //2. 可以创建一个 要操作的 BigInteger 然后进行相应操作
        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);//
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        System.out.println(subtract);//减
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        System.out.println(multiply);//乘
        BigInteger divide = bigInteger.divide(bigInteger2);
        System.out.println(divide);//除
    }
}
