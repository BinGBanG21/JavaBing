public class SearchRange {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        //如果数组中有这个数 那么找到他最后一个位置 并且返回
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    public int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //双指针 二分
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            //证明第一位置绝不是在右边
            if (target == nums[mid]) {
                right = mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        //走出while循环 左右指针都指向一个
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //双指针 二分
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            //证明第一位置绝不是在右边
            if (target == nums[mid]) {
                left = mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
