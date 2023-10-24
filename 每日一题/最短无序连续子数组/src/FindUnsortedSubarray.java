public class FindUnsortedSubarray {
    public static void main(String[] args) {

    }

    public int findUnsortedSubarray(int[] nums) {
        //我们可以把数组分成3段 左右两段都是升序 中间是序列
        //由题意知 把中间无序数组排序后 那么整个数组都为升序
        //所以我们可以找到左数组的有边界 右数组的左边界
        //然后长度为 索引相减+1
        int len = nums.length;
        //最大值 最小值
        int max = nums[0];
        int min = nums[len - 1];
        //数组只有一个元素时 输出为0 所以end为-1
        int start = 0, end = -1;
        //循环 找出最大值最小值
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {  //找左数组的最大值 边界
                end = i;          //找到就记录 也就是中段数组的起点
            } else {
                max = nums[i];   //如果
            }

            if (nums[len - i - 1] > min) {  //应该一直降序 如果升序了 就证明是中段数组的结尾
                start = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - start + 1;
    }
}
