import java.util.Arrays;

/*
    应用场景-修路问题
        有胜利乡有7个村庄(A, B, C, D, E, F, G) ，现在需要修路把7个村庄连通
        各个村庄的距离用边线表示(权) ，比如 A – B 距离 5公里
        问：如何修路保证各个村庄都能连通，并且总的修建公路总里程最短?
        思路: 将10条边，连接即可，但是总的里程数不是最小.
        正确的思路，就是尽可能的选择少的路线，并且每条路线最小，保证总里程数最少.
    最小生成树
        1.修路问题本质就是就是最小生成树问题， 先介绍一下最小生成树(Minimum Cost Spanning Tree)，简称MST。
        2.给定一个带权的无向连通图,如何选取一棵生成树,使树上所有边上权的总和为最小,这叫最小生成树
        3.N个顶点，一定有N-1条边
        4.包含全部顶点
    普里姆算法介绍
        1.普利姆(Prim)算法求最小生成树，也就是在包含n个顶点的连通图中，找出只有(n-1)条边包含所有n个顶点的连通子图，也就是所谓的极小连通子图
        2.普利姆的算法如下:
            1)设G=(V,E)是连通网，T=(U,D)是最小生成树，V,U是顶点集合，E,D是边的集合
            2)若从顶点u开始构造最小生成树，则从集合V中取出顶点u放入集合U中，标记顶点v的visited[u]=1
            3)若集合U中顶点ui与集合V-U中的顶点vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，将顶点vj加入集合U中
            4)将边（ui,vj）加入集合D中，标记visited[vj]=1
            5)重复步骤②，直到U与V相等，即所有顶点都被标记为访问过，此时D中有n-1条边

* */
public class Prim {
    public static void main(String[] args) {
        //初始化地图
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {100, 5, 7, 100, 100, 100, 2},
                {5, 100, 100, 9, 100, 100, 3},
                {7, 100, 100, 100, 8, 100, 100},
                {100, 9, 100, 100, 100, 4, 100},
                {100, 100, 8, 100, 100, 5, 4},
                {100, 100, 100, 4, 5, 100, 6},
                {2, 3, 100, 100, 4, 6, 100},
        };
        //创建Pgraph对象
        Pgraph graph = new Pgraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }

}

//创建最小生成树
class MinTree {

    //初始化二维数组 和节点数量
    public void createGraph(Pgraph graph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < weight.length; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示联接矩阵
    public void showGraph(Pgraph graph) {
        //打印二维数组
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //Prim算法 得到最小生成树
    public void prim(Pgraph graph, int v) {
        //记录访问情况的数组 0没访问 1访问
        int visited[] = new int[graph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 100; //将minWeight设置成一个较大的数
        for (int k = 1; k < graph.verxs; k++) { //边的数量 = 顶点数量 -1
            for (int i = 0; i < graph.verxs; i++) { //i表示正在访问的顶点
                for (int j = 0; j < graph.verxs; j++) {
                    //如果当前节点访问过 连结节点没访问 并且权值<最小权值 那么就赋值
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已访问过的节点和未访问过的节点的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边 <" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将节点标记为已访问 minWeight重置
            visited[h2] = 1;
            minWeight = 100;
        }
    }
}

class Pgraph {
    int verxs; //图中节点个数
    char[] data; //节点的数据(具体字符)
    int[][] weight; //表示节点之间权重的二维数组

    //初始化

    public Pgraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
