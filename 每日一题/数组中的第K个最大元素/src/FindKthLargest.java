public class FindKthLargest {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        //找到目标索引
        int target = nums.length - k;
        //记录当前的索引
        int cur = -1;

        while (cur != target) {
            cur = partition(left, right, nums);
            //如果当前索引比目标索引大 那么向右边找
            if (cur > target) {
                right = cur - 1;
            } else if (cur < target) {
                left = cur + 1;
            }
        }
        return nums[cur];
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int left, int right, int[] nums) {
        //如果数组中只有一个元素 那么直接返回索引
        if (left == right) {
            return left;
        }
        //随机拿到元素 不可以直接拿开头或者结尾的元素
        int randIndex = left + (int) (Math.random() * (right - left + 1));
        //拿到值 先把这个元素放在最右边 方便分割数组
        int val = nums[randIndex];
        swap(randIndex, right, nums);

        //开始分割数组
        int l = left, r = right - 1;
        //l找比val大的数 r找比val小的数 进行交换
        while (l < r) {
            while (l < r && nums[l] <= val) {
                l++;
            }
            while (l < r && nums[r] > val) {
                r--;
            }
            swap(l, r, nums);
        }
        //最后停止位置的元素比val大 我们再交换 小的话就不用交换
        if (nums[l] > val) {
            swap(l, right, nums);
            return l;
        }
        return right;
    }
}
