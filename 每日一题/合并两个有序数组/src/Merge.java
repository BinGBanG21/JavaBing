public class Merge {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //因为是num2向num1合并 num1是扩容后的
        //所以要从后向前合并
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
        while (index >= 0 && index2 >= 0 && index1 >= 0) {
            //取较大值
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1--];
            }else {
                nums1[index] = nums2[index2--];
            }
            index--;
        }
        //如果num1数组有剩余 那么本身就在结果数组里 不用合并
        //如果num2数组 那么直接全部合并到nums1中
        if (index1<0) {  //说明nums1先结束了 
            while (index >= 0) {
                nums1[index--] = nums2[index2--];
            }
        }
    }
}
