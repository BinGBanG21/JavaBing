public class IncreasingTriplet {
    public static void main(String[] args) {

    }

    public boolean increasingTriplet(int[] nums) {
        //贪心算法 尽量找到2个最小的元素 然后再找第三个元素
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        //假定数组第一个元素为最小元素 第二个元素取最大值
        int first = nums[0], sencond = Integer.MAX_VALUE;
        //从第二个元素开始查找
        for (int i = 1; i < n; i++) {
            //退出条件
            if (nums[i] > sencond) {
                return true;
            } else if (nums[i] > first) {
                sencond = nums[i];
            } else if (nums[i] < first) {
                //把当前值给first 继续向后找
                //这样我们在查找的过程中 始终有2个数升序
                first = nums[i];
            }
        }
        return false;
    }
}
