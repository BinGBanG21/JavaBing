/*
    简单插入排序存在的问题
        我们看简单的插入排序可能存在的问题.
        数组 arr = {2,3,4,5,6,1} 这时需要插入的数 1(最小), 这样的过程是：
        {2,3,4,5,6,6}
        {2,3,4,5,5,6}
        {2,3,4,4,5,6}
        {2,3,3,4,5,6}
        {2,2,3,4,5,6}
        {1,2,3,4,5,6}
        结论: 当需要插入的数是较小的数时，后移的次数明显增多，对效率有影响.
    希尔排序
        希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
        希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序.
    希尔排序法基本思路
        希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
        随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
* */

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 8, 9, 5, 4, 6, 0};
        shellChange(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr2[i] = (int) (Math.random() * 100000);
        }


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);

//        shellChange(arr2);
        shellMove(arr2);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }

    public static void shellChange(int[] arr) {
        int temp = 0;
        //首先对原数组进行分组 其实gap只要大于0 那么就一直长度/2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //这里是对5组数据的处理 可以理解成 0 - i 因为是/2的 所以用length是一样的
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //整体思路是一样的 就是不要发现一个就交换一个 找到当前的索引一次性插入值
    public static void shellMove(int[] arr) {
        //先对原数组进行分组
        for (int gap = arr.length; gap > 0; gap /= 2) {
            //因为每次都是/2 所以从gap开始 逐个对分组进行排序
            for (int i = gap; i < arr.length; i++) {
                //希尔排序 记录索引和值 然后找到 一次性插入 没找到就移动
                int j = i; //当前值的索引
                int temp = arr[i]; //当前值
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                //出了while循环表示找到了值 就插入 因为在上面我们是移动过来的
                //所以只需要给目标位置的后一位赋值即可 在移动的过程中数组始终是一直有两个j值的
                arr[j] = temp;
            }
        }
    }
}
