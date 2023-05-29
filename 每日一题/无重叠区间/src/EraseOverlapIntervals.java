import java.util.Arrays;

public class EraseOverlapIntervals {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        //还是找重叠区间 首先对数组进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            //如果当前区间的左边界<上个区间的右边界 那么我们就看下一组 并且更新当前区间的右边界
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            } else {
                count++;
            }
        }
        return intervals.length - count;
    }

}
