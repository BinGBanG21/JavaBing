/*
    二分查找
        二分查找必须是一个有序的数组
    二分查找的思路分析
        1.首先确定该数组的中间的下标mid= (left +right) / 2
        2.然后让需要查找的数findVal和arr[mid]比较
            2.1 findVal>arr[mid]，说明你要查找的数在mid的右边,因此需要递归的向右查找
            2.2 findVal<arr[mid],说明你要查找的数在mid的左边,因此需要递归的向左查找
            2.3 findVal==arr[mid]说明找到，就返回
        递归的结束条件
            1)找到就结束递归
            2)递归完整个数组，仍然没有找到findVal，也需要结束递归 => 当left> right就需要退出

 * */

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};


    }

    public static ArrayList<Integer> binary(int[] arr, int left, int right, int findVal) {
        if (left > right) { //说明没有找到 left = mid + 1; right = mid -1 ;
            return new ArrayList<Integer>();
        }
        //二分查找其实就是用中间值比较 然后移动left和right
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        //进行判断 改变left和right的值并递归
        if (arr[mid] > findVal) {
            //向左递归
            return binary(arr, left, mid - 1, findVal);
        } else if (arr[mid] < findVal) { //向右递归
            return binary(arr, mid + 1, right, findVal);
        } else {
            //思路分析
            //1.在找到mid索引值,不要马上返回
            //2.向mid索引值的左边扫描，将所有满足1000，的元素的下标，加入到集合ArrayList
            //3.向mid索引值的右边扫描，将所有满足1000，的元素的下标，加入到集合ArrayList
            //4.将Arraylist返回
            //return mid;
            ArrayList<Integer> list = new ArrayList<>();
            //先往左边找
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            //在把中间值mid放入list中记录
            list.add(mid);
            temp = mid + 1;
            //然后向右扫描
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
