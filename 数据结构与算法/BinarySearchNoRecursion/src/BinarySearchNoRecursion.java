/*
    二分查找算法(非递归)
        1.前面二分查找算法，是使用递归的方式，下面我们讲解二分查找算法的非递归方式
        2.二分查找法只适用于从有序的数列中进行查找(比如数字和字母等)，将数列排序后再进行查找
        3.二分查找法的运行时间为对数时间O(㏒₂n) ，即查找到需要的目标位置最多只需要㏒₂n步
          假设从[0,99]的队列(100个数，即n=100)中寻到目标数30，则需要查找步数为㏒₂100
          即最多需要查找7次( 2^6 < 100 < 2^7) 
*
* */


public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        System.out.println(binarySearch(arr,67));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        //循环条件(循环不是递归)
        while (left <= right) {
            //mid要写在循环里面 每次循环重新计算mid的值
            int mid = (left + right) / 2;
            if (arr[mid] == target) { //要写在最前面
                return mid;
            } else if (arr[mid] > target) { //说明大了 往左走 缩小right的范围 缩小多少呢 其实就是mid右边全都不要
                right = mid - 1;
            } else if (arr[mid] < target) { //说明小了 往右走 缩小多少呢 其实就是mid左边全都不要
                left = mid + 1;
            }
        }
        //走出while没有return 说明没找到
        return -1;
    }
}
