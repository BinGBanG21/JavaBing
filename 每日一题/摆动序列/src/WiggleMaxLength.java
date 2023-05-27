public class WiggleMaxLength {
    public static void main(String[] args) {

    }

    //    public int wiggleMaxLength(int[] nums) {
//        int n = nums.length;
//        if (n < 2) {
//            return n;
//        }
//        int prevdiff = nums[1] - nums[0];
//        int ret = prevdiff != 0 ? 2 : 1;
//        for (int i = 2; i < n; i++) {
//            int diff = nums[i] - nums[i - 1];
//            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
//                ret++;
//                prevdiff = diff;
//            }
//        }
//        return ret;
//    }
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        //有一个元素或者含两个不等元素的序列也视作摆动序列
        //如果只有一个元素 直接返回
        if (n < 2) {
            return n;
        }
        //思路：三个点 计算两两的差值
        //初始化为0 是因为两个数字的情况 我们统一处理
        //类似虚拟头节点 数组的第一个元素复制一个 那么preDiff = 0;
        int preDiff = 0;
        //后面会变 多少都行
        int curDiff = 0;
        //如果两个数字 那么最长摆动序列的长度为1 摆动为0
        //一共两种特殊情况
        //上升 - 持平 -下降  上升 - 持平 - 上升
        int result = 1;
        //默认最右侧有一个摆动 左边我们加了虚拟元素 然后计算
        for (int i = 0; i < n - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            //差值一正一负 即为摆动
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                result++;
                //重新赋值preDiff 写在判断条件里的原因是因为防止 上升 - 持平 - 上升
                preDiff = curDiff;
            }
        }
        return result;
    }
}
