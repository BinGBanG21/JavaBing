public class SortedSquares {
    public static void main(String[] args) {

    }

    //    public int[] sortedSquares(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        int[] result = new int[nums.length];
//        int index = nums.length - 1;
//        while (left <= right) {
//            if (nums[left] * nums[left] < nums[right] * nums[right]) {
//                result[index--] = nums[right] * nums[right];
//                right--;
//            } else {
//                result[index--] = nums[left] * nums[left];
//                left++;
//            }
//        }
//        return result;
//    }
    public int[] sortedSquares(int[] nums) {
        //首先数组是有序的 且存在负数 所以最大值一定在数组的两端
        //故采用双指针的方式 一头一尾 比较 然后逆序给数组赋值 从而由小到大输出数组
        int[] newArr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int cur = nums.length - 1; //用于数组的赋值
        //循环的终止条件 left <= right
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                newArr[cur] = nums[left] * nums[left];
                left++;
            } else {
                newArr[cur] = nums[right] * nums[right];
                right--;
            }
            cur--;
        }
        return newArr;
    }
}
