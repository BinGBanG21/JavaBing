import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static void main(String[] args) {

    }

    //    public int[][] merge(int[][] intervals) {
//        //越界处理
//        if(intervals.length == 0){
//            return new int[0][2];
//        }
//        //先对数组按照左端点进行排序
//        Arrays.sort(intervals, new Comparator<int[]>(){
//            public int compare(int[] interval1 , int[] interval2){
//                return interval1[0] - interval2[0];
//            }
//        });
//        List<int[]> merged = new ArrayList<int[]>();
//        for(int i = 0; i < intervals.length; ++i){
//            //左端点都是升序排列 只看右端点
//            //从merged中取会更加方便
//            int left = intervals[i][0];
//            int right = intervals[i][1];
//            if(merged.size() == 0 || merged.get(merged.size() -1)[1] < left){
//                merged.add(new int[]{left,right});
//            }else{ //否则更改右边最大值
//                merged.get(merged.size() -1)[1] = Math.max(merged.get(merged.size() - 1)[1],right);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);
//    }
    public int[][] merge(int[][] intervals) {
        //越界处理
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //创建结果
        List<int[]> result = new LinkedList<>();
        //起始还是找重叠区间 先对数组进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果当前区间的左边界大于上个区间的右边界 没有重复 收集结果
            if (intervals[i][0] > intervals[i - 1][1]) {
                result.add(new int[]{left, right});
                //更新left right
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                //如果重复 那么更新当前数组的右边界
                intervals[i][1] = Math.max(right, intervals[i][1]);
            }
        }
        //添加最后一段区间
        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][]);
    }
}
