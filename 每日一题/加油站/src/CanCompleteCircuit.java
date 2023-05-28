public class CanCompleteCircuit {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //结果索引
        int index = 0;
        //总油量
        int sum = 0;
        //当前剩余油量总和
        int curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            //如果当前油量<0 那么尝试从下一个起始位置开始跑
            if (curSum < 0) {
                index = i + 1;
                //重置当前油量
                curSum = 0;
            }
        }
        //如果总油量为负数 那么跑不完
        if (sum < 0) {
            return -1;
        }
        return index;
    }
}
