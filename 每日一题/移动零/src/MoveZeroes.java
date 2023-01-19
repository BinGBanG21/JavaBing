public class MoveZeroes {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
    }

    public void swap(int[] nums, int fast, int slow) {
        int temp = nums[fast];
        nums[fast] = nums[slow];
        nums[slow] = temp;
    }
}
