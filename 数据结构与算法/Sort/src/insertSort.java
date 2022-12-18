/*
    插入排序
        插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。
    排序思路
        插入排序（Insertion Sorting）的基本思想是：
        把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素
        排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。

* */

public class insertSort {
    public static void main(String[] args) {
        int[]arr = {123,26,57,45,90};
    }
    public static void insert(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int insertVal = arr[i]; //待插入的值
        }
    }
}
