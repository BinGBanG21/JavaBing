/*
    选择排序
        1.选择排序一共有数组大小-1轮排序
        2.每1轮排序，又是一个循环,循环的规则(代码)
            2.1先假定当前这个数是最小数
            2.2然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
            2.3当遍历到数组的最后时，就得到本轮最小数和下标

* */

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 92, 18, 20, 57, 1001};
        int[] arr2 = selectSort1(arr);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        int[] arr3 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr3[i] = (int) (Math.random() * 1000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);

        selectSort1(arr3);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }

    public static int[] selectSort1(int[] arr) {
        //假设i最小值 每次选最小值 6个数选5次 所以-1
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            //然后循环i后面的数字 和i进行比较 如果比当前数字小 那么先记下来索引 遍历完在交换 以免刚刚交换完发现后面数字还有小的
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) { //说明最小值不是最小
                    min = arr[j]; //重置min值
                    minIndex = j; //重置minIndex

                }
                //循环完成 确定了最小值再交换
                //如果假定了的最小值就是当前循环的最小值 说明假定是正确的 那就不需要交换
                if (minIndex != j) {
                    arr[minIndex] = arr[i];
                }
            }

        }
        return arr;
    }
}
