import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {
    public static void main(String[] args) {

    }

    public int[][] reconstructQueue(int[][] people) {
        //先按身高从大到小排序 因为说了是前面的 如果身高相同 就按第二个值从小到大排序
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        //然后按照第二个值进行排序
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] person : people) {
            que.add(person[1], person);
        }
        return que.toArray(new int[people.length][]);
    }
}
