import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        //创建结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //循环 1行1个 2行2个
        for (int i = 0; i < numRows; i++) {
            //每一行的结果
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                //三角的两边都是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    //当前值等于他上一列和坐上列的和
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
