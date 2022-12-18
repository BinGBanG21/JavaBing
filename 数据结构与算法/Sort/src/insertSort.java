/*
    插入排序
        插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。
    排序思路
        插入排序（Insertion Sorting）的基本思想是：
        把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素
        排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。

* */

import java.text.SimpleDateFormat;
import java.util.Date;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = {123, 26, 90, 45, 57};
//        insert(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"  ");
//        }

        int[] arr2 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr2[i] = (int) (Math.random() * 1000000);
        }


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);

        insert(arr2);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; //待插入的值
            int insertIndex = i - 1; //带插入的索引 即arr[i]前面的下标
            //注意：比较的时候  不要用arr[i] 因为会向后移动 arr[i]的值会变
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //索引大于0 并且 值小于待插入的值 那么就向前继续找 同时把当前比较的值向后移动
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //走出循环 表示arr[i]的值比当前的比较值大 那么放在比较值的后面
            if (insertIndex +1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
