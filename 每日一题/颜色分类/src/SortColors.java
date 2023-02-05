public class SortColors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        // 0: [p0 i)  1: [i p2) 2 (p2 len -1]
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        //i 与 p2 重合后还要跑一边 不然不知道换过来的p2是多少
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, p2, i);
                p2--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
