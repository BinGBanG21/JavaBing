import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeastInterval {
    public static void main(String[] args) {

    }

    public int leastInterval(char[] tasks, int n) {
        //由于同类型的任务有执行间隔
        //所以分为两种情况
        //1.第一种最为常见的情况
        //就是找出任务次数最多的任务 然后排间隔
        //2.如果任务的种类比出现次数最多的任务的数量还多
        //我们如果还按照第一种方式计算 就会比实际的任务时间少
        //如果种类比次数多证明我们不需要处理间隔时间 直接执行就可以了
        //我们上面的所有操作都是为了合理的利用同种任务的间隔时间

        //统计出现次数最多的任务数量
        Map<Character, Integer> map = new HashMap<>();
        //记录最多的执行次数
        int maxExec = 0;
        for (char task : tasks) {
            //没有就是初始化0 有了就+1 然后再次到map中
            int exec = map.getOrDefault(task, 0) + 1;
            map.put(task, exec);
            //更新最大执行次数
            maxExec = Math.max(maxExec, exec);
        }
        // 示例
        // A B C
        // A B C
        // A
        // A
        //矩阵的计算公式：maxExec * (n + 1) + maxCount
        //计算矩阵的最后一行 处理两种任务出现次数并列第一的情况
        int maxCount = 0;

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
