/*

* */

public class LineSearch {
    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 3, 9, 2, 7,};
    }

    public static int search(int[] arr, int search) {
        int index= 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                index = i;
            } else {
                System.out.println("传入的值有误或不存在");
                index = -1;
            }
        }
        return index;
    }

}
