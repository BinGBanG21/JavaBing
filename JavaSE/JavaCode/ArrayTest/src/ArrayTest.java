public class ArrayTest {
    public static void main(String[] args) {
        MyTools mt = new MyTools();
        int[] arr = {1,23,44,21,46};
        mt.bubble(arr);
        for (int j : arr) {
            System.out.print(j);
        }
    }
}
class MyTools {
    int temp = 0;
    public void bubble(int[] arr){
        for (int i = 0; i < arr.length; i++) { //外层循环的次数为length-1（5个数只需要排4次）-i(已经排好的不用再排了)
            for (int j = 0; j <arr.length - i - 1 ; j++) {
                if (arr[j] > arr[j+1]){ //进行变量交换
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}