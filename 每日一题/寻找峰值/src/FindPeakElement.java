public class FindPeakElement {
    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        //二分查找 因为开头结尾都补了负无穷
        //所以拿到mid 和相邻两个点做判断 往高处走
        //如果恰好小于相邻的两个点 那么走左右都可以
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
