import java.util.Arrays;

public class FindMinArrowShots {
    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        //首先对气球按左边界进行排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        //记录箭的数量 最少需要1支箭
        int count = 1;
        //找出重叠的气球 看有区间
        for (int i = 1; i < points.length; i++) {
            //气球不重叠 必须使用一只箭射爆
            if (points[i - 1][1] < points[i][0]) {
                count++;
            } else {
                //如果上一个气球的右边界>=当前气球的左边界 则可以一只箭射爆
                // 那么更新当前气球的右边界为上个气球的右边界 然后那最小的右边界和下个气球的左边界进行判断
                // 继续看能不能射爆更多
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
