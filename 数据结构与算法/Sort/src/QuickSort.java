/*
    快速排序
        快速排序（Quicksort）是对冒泡排序的一种改进。基本思想是：
        通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
        然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
*
* */


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,4,6,8,3,10,4,6};
        quick(arr,0,7);
        System.out.println(Arrays.toString(arr));



        int[] arr2 = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr2[i] = (int) (Math.random() * 10000000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);

//        shellChange(arr2);
        quick(arr2,0,9999999);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time2 = simpleDateFormat.format(date2);
        System.out.println(time2);
    }

    //基本思想
    //1.选定Pivot中心轴
    //2.将大于Pivot的数字放在Pivot的右边
    //3.将小于Pivot的数字放在Pivot的左边
    //4.分别对左右子序列重复前三步操作
    //整体思路分两种情况
    //  1) 常规情况:在l r不重合的情况下 左边找到一个比基准值大的数 理应在右边 右边找到一个比基准值小的数 理应在左边
    //     那么我们就进行交换(l r)
    //  2) 特殊情况：右边找到了一个比基准值小的数 理应在左边 但是左边还没有找到比基准值大的数 就和右指针重合
    //     那么我们就把arr[i]的值和基准值交换
    //  3) 为什么先移动右边的值：
    //     因为我们是选择第一个元素作为基准值 出现第2条的特殊情况 要和基准值进行交换
    //     先从右边找 就能保证当前值比基准值小 交换后数组的顺序也是正确的
    public static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //保存中轴值 左右索引 其实是4个指针 left right不变  l r初始值为left right 然后随循环一起改变
        int l = left;
        int r = right;
        int pivot = arr[left]; //每个数组的第一个 这里注意不要用l 因为l会变的
        int temp = 0;
        //开始循环找值交换
        while (l < r) {
            //先走r
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }

            //在最外层循环满足的情况下 这明显就是常规情况 直接交换 l r 的值
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        //因为上面两个循环一直在改 l r 那么如果走到了外面 就证明 l = r 即左指针走到和右指针重合 都没有找到比基准值小的数
        //那么我们的策略就是把这个小的值换过去 也不算浪费了此次循环了 上面已经保存了基准值 两条语句就能实现交换
        arr[left] = arr[l];
        arr[l] = pivot;
        //递归 对左右子序列进行处理 此时left和right指向是一个位置
        quick(arr, left, l - 1);
        quick(arr, r + 1, right);
    }
}
