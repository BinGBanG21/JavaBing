
/*
    图基本介绍
        为什么要有图
            1.前面我们学了线性表和树
            2.线性表局限于一个直接前驱和一个直接后继的关系
            3.树也只能有一个直接前驱也就是父节点
            4.当我们需要表示多对多的关系时，我们就用到了图
        图是一种数据结构，其中结点可以具有零个或多个相邻元素。两个结点之间的连接称为边。 结点也可以称为顶点。
            顶点(vertex)
            边(edge)
            路径
            无向图:顶点之间的连接没有方向，比如A-B,即可以是 A-> B 也可以 B->A .
            有向图:顶点之间的连接有方向，比如A-B,只能是 A-> B 不能是 B->A .
            带权图:边带权值的图 也叫网.
        图的表示方式有两种：二维数组表示（邻接矩阵）；链表表示（邻接表）
            邻接矩阵
                邻接矩阵是表示图形中顶点之间相邻关系的矩阵，对于n个顶点的图而言，矩阵是的row和col表示的是1....n个点。
            邻接表
                邻接矩阵需要为每个顶点都分配n个边的空间，其实有很多边都是不存在,会造成空间的一定损失.
                邻接表的实现只关心存在的边，不关心不存在的边。因此没有空间浪费，邻接表由数组+链表组成
    图遍历
        所谓图的遍历，即是对结点的访问。一个图有那么多个结点，如何遍历这些结点，需要特定策略，
        一般有两种访问策略: (1)深度优先遍历 (2)广度优先遍历
        图的深度优先搜索(Depth First Search) 。
            1.深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问第一个邻接结点，
              然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点，
              可以这样理解：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
            2.我们可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。
        深度优先遍历算法步骤
            1.在访问图中某一起始顶点v后，由v出发，访问它的任一邻接顶点w;再从w出发，访问与w邻接但还未被访问过的顶点W2
            2.然后再从W2出发，进行类似的访问，..
            3.如此进行下去，直至到达所有的邻接顶点都被访问过的顶点u为止。接着，退回一步，退到前一次刚访问过的顶点
              看是否还有其它没有被访问的邻接顶点。
            4.如果有，则访问此顶点，之后再从此顶点出发，进行与前述类似的访问;
            5.如果没有，就再退回一步进行搜索。重复上述过程，直到连通图中所有顶点都被访问过为止。

        广度优先遍历基本思想
            图的广度优先搜索(Broad First Search)：
            类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点
        广度优先遍历算法步骤
            1.访问初始结点v并标记结点v为已访问。
            2.结点v入队列
            3.当队列非空时，继续执行，否则算法结束。
            4.出队列，取得队头结点u。
            5.查找结点u的第一个邻接结点w。
            6.若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
              6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
              6.2 结点w入队列
              6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。

* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public static void main(String[] args) {
        //节点个数
        int n = 5;


        //创建图对象
        Graph graph = new Graph(n);
        //节点
        String[] vertexs = {"A", "B", "C", "D", "E"};
        //循环数组 添加节点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
//        graph.dfs();
        graph.bfs();
    }

    //创建一个ArrayList 用于保存节点信息
    private ArrayList<String> vertexList;
    //创建一个二维数组 保存图对应的邻结矩阵
    private int[][] edges;
    //表示边的数目
    private int numsOfEdges;
    //记录某个节点是否被访问'
    private boolean[] isVisited;

    //初始化构造器 确定节点数量 同时生成二维数组
    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numsOfEdges = 0;
        isVisited = new boolean[n];
    }


    //拿到邻接点的下标

    /**
     * 其实就是我们根据边的关系生成的二维数组
     *
     * @param i 可以理解为行 也就是我们的ArrayList中的节点
     * @return 如果和其他节点能连通 那么就返回那个节点在ArrayList中的索引
     */
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //跳过节点继续查找
    //根据前一个邻接节点的下标获取下一个邻接节点(回溯 就是当前走不通了 然后跳过这个继续走)
    //不只是下一个节点 他是跳过当前节点 一直往后找
    public int getNextNeighbor(int v1, int v2) {
        //如果节点被访问了 那我们就跳到当前节点的下一个节点开始查找
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //首先拿到一个节点 为起点 (可以理解为对一个节点进行深度优先搜索)
    public void dfs(boolean[] isVisited, int i) {
        //把起点打印
        System.out.print(vertexList.get(i) + " =>");
        //把已访问过的节点设置为true
        isVisited[i] = true;
        //在二维数组(也就是我们关系表中 判断和那条线是连接的 拿到连接节点的索引)
        int w = getFirstNeighbor(i);
        //判断当前节点能否走 因为我们找不到return -1 所以只要能找到且没有被访问 我们就以当前节点为起点继续找
        //也就是递归dfs
        while (w != -1) {
            if (!isVisited[w]) { //两个点有连线 且没有被访问
                //那就打印当前这个点 然后继续向下访问 也就是dfs
                dfs(isVisited, w);
            }
            //如果节点被访问了 那我们就跳到当前节点的下一个节点开始查找(这里发生回溯)
            //其实就是当前走不通了 然后跳过这个 从起点尝试往下下个节点走
            w = getNextNeighbor(i, w);
            //整体逻辑走完 只是走了二维数组的一行 所以要遍历每一个节点 都这样做
        }
    }

    //对dfs进行一个重载
    public void dfs() {
        for (int i = 0; i < getNumsOfEdges(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个节点进行广度优先遍历
    public void bfs(boolean[] isVisited, int i) {
        int u; //头节点 也就是起点
        int w; //邻接节点w
        LinkedList<Integer> queue = new LinkedList<>(); //队列 用于管理节点
        //走到了这里 就说明已访问节点了
        System.out.print(getValueByIndex(i) + " -> ");
        //把节点标记为已访问
        isVisited[i] = true;
        //把节点加入队列 然后循环队列 取出队列中以访问的节点 去访问他的邻接节点
        queue.addLast(i);
        //循环访问
        while (!queue.isEmpty()) {
            //取出头节点的下标
            u = queue.removeFirst();
            //根据头节点下标 找u的邻接节点
            w = getFirstNeighbor(u);
            //如果w不为-1说明有邻接节点 找到后如果没有被访问 那我们就访问 然后拿到邻接节点 继续访问
            while (w > -1) {
                if (!isVisited[w]) { //如果邻接节点没有被访问 那么访问
                    System.out.print(getValueByIndex(w) + " -> ");
                    //把访问过的节点设置为true
                    isVisited[w] = true;
                    //然后加入队列
                    queue.addLast(w);
                }
                //如果访问过 就跳过当前节点访问
                //以u为起点 跳过一个节点 然后将下下节点赋值给w 有就输出 没有就在跳下下个节点判断 体现广度优先
                w = getNextNeighbor(u, w);

            }
        }
    }

    //遍历所有节点 进行广度优先搜索
    public void bfs() {
        for (int i = 0; i < getNumsOfEdges(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * 添加边
     *
     * @param v1     节点的下标 即第几个顶点
     * @param v2     同v1
     * @param weight 0 1  0不通 1通
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
        numsOfEdges++;
    }

    //统计图中节点的个数
    public int getNumsOfVertex() {
        return vertexList.size();
    }

    //统计图中边的书目
    public int getNumsOfEdges() {
        return numsOfEdges;
    }

    //返回i节点对应的数据(方便打印图的关系) 0 -> "A" 1 -> "B"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1 v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵(其实就是遍历二维数组)
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }


}

