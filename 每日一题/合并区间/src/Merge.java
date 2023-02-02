import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static void main(String[] args) {

    }
    public int[][] merge(int[][] intervals) {
        //越界处理
        if(intervals.length == 0){
            return new int[0][2];
        }
        //先对数组按照左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1 , int[] interval2){
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for(int i = 0; i < intervals.length; ++i){
            //左端点都是升序排列 只看右端点
            //从merged中取会更加方便
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size() -1)[1] < left){
                merged.add(new int[]{left,right});
            }else{ //否则更改右边最大值
                merged.get(merged.size() -1)[1] = Math.max(merged.get(merged.size() - 1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
