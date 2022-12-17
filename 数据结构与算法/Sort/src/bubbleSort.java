/*
    冒泡排序
        冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）,依次比较相邻元素的值
        若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
        因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下来没有进行过交换，就说明序列有序
        因此要在排序过程中设置一个标志flag判断元素是否进行过交换。从而减少不必要的比较。
    小结冒泡排序规则
        1)一共进行数组的大小-1次大的循环
        2)每一趟排序的次数在逐渐的减少
        3)如果我们发现在某趟排序中，没有发生一次交换，可以提前结束冒泡排序。这个就是优化

* */

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        //冒泡排序：每次找最值
        //找出一次循环种最大的数 放在后面 每次是两个数比较 所以5个数比较4次就行
        //用于交换的临时变量
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            //如果某次循环中没有发生变量交换 说明顺序已正确
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { //升序排序 如果当前数比后面数大 那就向后移
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.printf("第" + (i + 1) + "次循环的数组\n");
            System.out.println(Arrays.toString(arr));
            if (!flag) { //顺序正确就直接退出循环
                break;
            } else {
                //变量在循环中才能被改变 所以每走完一次循环就判断改没改
                //循环走完变量没变 就代表排序完成 如果变了要改回来 方便下次判断
                flag = false;
            }
        }
    }
}
