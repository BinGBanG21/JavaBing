import java.util.LinkedList;
import java.util.Queue;

public class CanFinish {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //检测有向图中是否存在环
        //创建入度表
        int[] indegrees = new int[numCourses];
        //判断结果
        int res = numCourses;
        //求出所有课程的入度数
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
        }
        //创建队列
        Queue<Integer> queue = new LinkedList<>();
        //遍历入度表 将入度数为0加入队列中
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        //循环 先弹出栈 然后入度数-- 当入度数=0 就加入队列中
        while (!queue.isEmpty()) {
            //弹出
            int pre = queue.poll();
            res--;
            //找到与pre相等的前置课程 然后入度数--
            for (int[] p : prerequisites) {
                if (p[1] == pre) {
                    indegrees[p[0]]--;
                    //减完后 如果前置为0 那么入栈
                    if (indegrees[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}
