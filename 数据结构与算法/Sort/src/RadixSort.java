/*
    基数排序(桶排序)介绍:
        1.基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，
          顾名思义，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
        2.基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序法
        3.基数排序(Radix Sort)是桶排序的扩展
        4.基数排序是1887年赫尔曼·何乐礼发明的。它是这样实现的：将整数按位数切割成不同的数字，然后按每个位数分别比较
* */

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radix(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radix(int[] arr) {
        //定义一个二维数组 表示桶子
        int[][] buckets = new int[10][arr.length];
        //定义一个一维数组 表示每个桶放了多少个元素 一共10个桶
        int[] bucketsElementCounts = new int[10];
        //找到数组中的最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //拿到最大值的位数
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //循环个位数字 放到相应的桶中 然后在遍历桶  给arr重新赋值
            for (int j = 0; j < arr.length; j++) {
                //得到个十百千等等位数字
                int digitOfElement = arr[j] / n % 10;
                //按照个位数放到桶（二维数组）中 因为二维数组初始化为0  我们正好利用这个特点
                //如果不是这种写法 我们要初始化一个计数变量 但是那样一个桶一个变量 太多了 也不利于管理
                //buckets[digitOfElement] 表示第几个桶
                //创建counts数组时候没有赋值 所以默认第digit个数就是0
                //我们就可以利用bucketsElementCounts[digitOfElement]作为计数变量 然后直接++即可
                buckets[digitOfElement][bucketsElementCounts[digitOfElement]] = arr[j];
                bucketsElementCounts[digitOfElement]++;
            }
            //给原数组赋值用
            int index = 0;
            //走完for循环 我们就要从一维数组中拿出数 然后重新赋值给arr
            for (int k = 0; k < bucketsElementCounts.length; k++) {
                //如果当前元素不为0 我们就遍历拿数
                if (bucketsElementCounts[k] != 0) {
                    //证明有数字 我们要进行循环
                    for (int l = 0; l < bucketsElementCounts[k]; l++) {
                        //从二维数组中拿值 赋值 k也可以给二维数组用
                        arr[index++] = buckets[k][l];
                    }
                }
                //循环结束后把数组清零
                bucketsElementCounts[k] = 0;

            }
        }


    }
}
