
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
            1.访问初始结点v，并标记结点v为已访问。
            2.查找结点v的第一个邻接结点w。
            3.若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
            4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
            5.查找结点v的w邻接结点的下一个邻接结点，转到步骤3。


* */


import java.util.ArrayList;
import java.util.Arrays;

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

    //根据前一个邻接节点的下标获取下一个邻接节点(回溯 就是当前走不通了 然后跳过这个继续走)
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    public void  test(){
        return;
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

