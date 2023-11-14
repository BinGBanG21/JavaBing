public class MissingNumber {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        //算出所有数字的和 - nums的和
        int numsTotal = 0;
        for (int num : nums) {
            numsTotal += num;
        }
        int n = nums.length;
        int total = n * (n + 1) / 2;
        return total - numsTotal;
    }
}
