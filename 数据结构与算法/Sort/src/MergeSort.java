/*
    归并排序
        归并结构很像一棵完全二叉树，归并排序采用递归去实现（也可采用迭代的方式去实现）。
        分阶段可以理解为就是递归拆分子序列的过程。


* */

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length]; //归并排序速度较慢 因为需要一个额外的空间
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

        //测试速度

        int[] arr2 = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr2[i] = (int) (Math.random() * 10000000);
        }
        int[] temp2 = new int[arr2.length];
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);

        sort(arr2,0,9999999,temp2);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }

    //分解  只要 l < r 那么就一直分解 直到分解到数组中只剩一个数 同时初始化temp数组
    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;  //这里的分解数组就是一直重新计算mid的值即可 因为我们以mid为基准进行合并
            //分解后 左右递归 一起合并
            sort(arr, left, mid, temp);
            //递归右边
            sort(arr, mid + 1, right, temp);
            //然后合并数组
            merge(arr, left, mid, right, temp);
        }
    }

    //合并的思路

    /**
     * @param arr   需要排序的原始数组
     * @param left  指向数组最左边的一个数
     * @param mid   排序的中间索引 要通过它去判断一方是否到头了 右侧也是从mid+1开始递增 属于分解
     * @param right 指向数组最后一个数
     * @param temp  用于储存排好序的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0; //给数组用的索引
        //当有一方没有到达自己的终点 代表需要继续排序
        //排序的思路：左右双指针 哪个小 哪个就放到数组中 然后指针和数组指针递增
        while (l <= mid && r <= right) { //证明两方都没排完
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }
        //如果推出循环 代表有一方结束 那么将另一方的剩余数依次拷贝填充到temp中
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }
        //将temp数组中的元素拷贝到arr数组中 left不要污染 元素组索引t用完重置 拷贝的时候再用
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
