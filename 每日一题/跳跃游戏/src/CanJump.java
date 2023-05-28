public class CanJump {
    public static void main(String[] args) {

    }

    //    public boolean canJump(int[] nums) {
//        if (nums.length == 1) {
//            return true;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            boolean flag = false;
//            //只有出现0的情况才有可能跳不过去(但是不包括 最后一个位置)
//            if (i != nums.length - 1 && nums[i] == 0) {
//                //在出现0的情况时 往回找 找到一个位置 可以跳过 0 的这个位置
//                for (int j = i - 1; j >= 0; j--) {
//                    if (nums[j] > i - j) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (!flag) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    public boolean canJump(int[] nums) {
        //只有一个元素 可以跳过
        if (nums.length == 1) {
            return true;
        }
        int coverRange = 0;
        //每次从跳跃范围内找到最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            //从当前位置i向后跳nums[i] + i
            coverRange = Math.max(coverRange, i + nums[i]);
            //注意是索引 要-1
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
