public class Jump {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int jump(int[] nums) {
        //起点
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int jumpCount = 0;
        //当前的覆盖范围
        int curCover = 0;
        //当前范围内的最大覆盖范围
        int maxCover = 0;
        for (int i = 0; i < nums.length; i++) {
            //首先计算该起点的最大覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
            //最大覆盖范围超过了数组长度 那么能走到
            if (maxCover >= nums.length - 1) {
                jumpCount++;
                break;
            }
            //在本次的覆盖范围内遍历 找到本次范围内的下次最大覆盖范围
            //当走完本次的覆盖范围 取最大值为当前更新范围 记1步
            if (i == curCover) {
                curCover = maxCover;
                jumpCount++;
            }
        }
        return jumpCount;
    }
}
