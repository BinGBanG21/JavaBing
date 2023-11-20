import java.util.*;

public class GetSkyline {
    public static void main(String[] args) {

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        //扫描线算法
        //假设有一条线 一次扫描建筑物的左边缘线
        //维护一个大顶堆
        //遇到左边缘线时 我们将建筑物的高度压入堆中
        //遇到右边缘线时 我们将建筑物的高度从栈中弹出
        //一旦堆中的最大值发生了变化 我们就遇到了关键点
        //关键点：当前线段的X坐标及堆顶元素的最大值

        List<List<Integer>> points = new ArrayList<>();
        //把建筑物的左右边缘线预处理 先左后右 左边高度为负数 右边正常

        for (int[] b : buildings) {
            points.add(Arrays.asList(b[0], -b[2]));
            points.add(Arrays.asList(b[1], b[2]));
        }

        //对线段进行排序 优先横坐标升序 如果横坐标相同 那么按照高度升序
        points.sort(
                (O1, O2) -> {
                    int x1 = O1.get(0), y1 = O1.get(1);
                    int x2 = O2.get(0), y2 = O2.get(1);
                    if (x1 != x2) {
                        return x1 - x2;
                    } else {
                        return y1 - y2;
                    }
                }
        );

        //创建大顶堆 放入0
        Queue<Integer> queue = new PriorityQueue<>((O1, O2) -> O2 - O1);
        queue.offer(0);
        //记录大顶堆的最大值
        int preMax = 0;

        //创建结果数组
        List<List<Integer>> res = new ArrayList<>();
        //循环边缘线 得到高度
        for (List<Integer> p : points) {
            int x = p.get(0), y = p.get(1);
            //如果是左边缘 那么加入堆中
            if (y < 0) {
                queue.offer(-y);
            } else {
                //如果是右边缘 从堆中移除
                queue.remove(y);
            }
            //查看最大值是否发生变化
            int curMax = queue.peek();

            if (curMax != preMax) {
                res.add(Arrays.asList(x, curMax));
                //更新最大值
                preMax = curMax;
            }
        }
        return res;
    }
}
