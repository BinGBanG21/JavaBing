import java.util.LinkedList;

public class FindOrder {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //创建入度表
        int[] inDegree = new int[numCourses];

        //[1,0] 表示0指向1 也就是1出现了几次 就有几次入度
        for (int[] p : prerequisites) {
            //统计每个节点的入度数
            inDegree[p[0]]++;
        }

        //创建队列 把入度数为0的先加入到队列中
        //索引是课程号 值为入度
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //创建结果数组  和写入数组用到的索引
        int[] result = new int[numCourses];
        int index = 0;

        //循环 从队列尾部拿出入度为0的元素
        while (!queue.isEmpty()) {
            //node也就是课程号
            int node = queue.poll();
            result[index++] = node;
            //如果前置课程号=该课程号 那么入度数--
            for (int[] p : prerequisites) {
                if (p[1] == node) {
                    inDegree[p[0]]--;
                    //如果--后为0 那么加入队列中
                    if (inDegree[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }
            }
        }
        //最后验证index是否等于numCourse
        return index == numCourses ? result : new int[0];
    }
}
