/*
    赫夫曼编码
        1.赫夫曼编码也翻译为哈夫曼编码(Huffman Coding)，又称霍夫曼编码，是一种编码方式, 属于一种程序算法
        2.赫夫曼编码是赫哈夫曼树在电讯通信中的经典的应用之一。
        3.赫夫曼编码广泛地用于数据文件压缩。其压缩率通常在20%～90%之间
        4.赫夫曼码是可变字长编码(VLC)的一种。Huffman于1952年提出一种编码方法，称之为最佳编码
    原理剖析
        通信领域中信息的处理方式1-定长编码
        i like like like java do you like a java       // 共40个字符(包括空格)
        105 32 108 105 107 101 32 108 105 107 101 32 108 105 107 101 32 106 97 118
        97 32 100 111 32 121 111 117 32 108 105 107 101 32 97 32 106 97 118 97  //对应Ascii码
        01101001 00100000 01101100 01101001 01101011 01100101 00100000 01101100
        01101001 01101011 01100101 00100000 01101100 01101001 01101011 01100101
        00100000 01101010 01100001 01110110 01100001 00100000 01100100 01101111
        00100000 01111001 01101111 01110101 00100000 01101100 01101001 01101011
        01100101 00100000 01100001 00100000 01101010 01100001 01110110 01100001 //对应的二进制
        按照二进制来传递信息，总的长度是  359   (包括空格)
    通信领域中信息的处理方式2-变长编码
        like like like java do you like a java       // 共40个字符(包括空格)
        d:1 y:1 u:1 j:2  v:2  o:2  l:4  k:4  e:4 i:5  a:5   :9  // 各个字符对应的个数
        0=  ,  1=a, 10=i, 11=e, 100=k, 101=l, 110=o, 111=v, 1000=j, 1001=u, 1010=y, 1011=d
        说明：按照各个字符出现的次数进行编码，原则是出现次数越多的，则编码越小，比如 空格出现了9 次， 编码为0 ,其它依次类推.
        按照上面给各个字符规定的编码，则我们在传输  "i like like like java do you like a java" 数据时，编码就是 10010110100...
        字符的编码都不能是其他字符编码的前缀，符合此要求的编码叫做前缀编码， 即不能匹配到重复的编码
    通信领域中信息的处理方式3-赫夫曼编码
        i like like like java do you like a java       // 共40个字符(包括空格)
        d:1 y:1 u:1 j:2  v:2  o:2  l:4  k:4  e:4 i:5  a:5   :9  // 各个字符对应的个数
        按照上面字符出现的次数构建一颗赫夫曼树, 次数作为权值
        根据赫夫曼树，给各个字符
        规定编码 ， 向左的路径为0
        向右的路径为1 ， 编码如下:
        o: 1000   u: 10010  d: 100110  y: 100111  i: 101
        a : 110     k: 1110    e: 1111       j: 0000       v: 0001
        l: 001          : 01
        按照上面的赫夫曼编码，我们的"i like like like java do you like a java"
        字符串对应的编码为 (注意这里我们使用的无损压缩)
        101010011011110111101001101111011110100110111101111010000110000111001100111100001100
        1111000100100100110111101111011100100001100001110
        长度为 ： 133
        说明:
        原来长度是  359 , 压缩了  (359-133) / 359 = 62.9%
        此编码满足前缀编码, 即字符的编码都不能是其他字符编码的前缀。不会造成匹配的多义性
        这个赫夫曼树根据排序方法不同，也可能不太一样，这样对应的赫夫曼编码也不完全一样，但是wpl 是一样的，都是最小的
        比如: 如果我们让每次生成的新的二叉树总是排在权值相同的二叉树的最后一个
* */

import java.util.*;

public class HuffmanCoding {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        //得到byte数组
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length);
        List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);
        Node root = createHuffmanTree(nodes);
        root.preOrder();
    }

    public static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历字节数组  统计每个字母出现的次数 => 使用map
        Map<Byte, Integer> bMap = new HashMap<>();
        //使用map统计后 把节点加入到List中并返回
        for (Byte aByte : bytes) {
            Integer count = bMap.get(aByte);
            if (count == null) {
                bMap.put(aByte, 1);
            } else {
                bMap.put(aByte, count++);
            }
        }
        //遍历map 生成node节点
        for (Map.Entry<Byte, Integer> entry : bMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //创建huffmanTree
    public static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            //从小到大排序
            Collections.sort(nodes);
            //拿出前两个节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //组合成树
            Node parent = new Node(null, leftNode.weight + rightNode.weight);

            //设置树的左右节点
            parent.left = leftNode;
            parent.right = rightNode;

            //将parent加入到nodes中 并且删除已经用过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        //最后返回root节点
        return nodes.get(0);

    }

    //前序遍历
    public void preOrder(Node root) {
        if (root == null) {
            System.out.println("空树");
        } else {
            root.preOrder();
        }
    }

    //生成赫夫曼编码和赫夫曼编码后的数据 Tree想左为0 向右为1
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //生成huffman路径需要拼接路径 使用stringBuffer储存结点路径
    static StringBuffer stringBuffer = new StringBuffer();

    //获得huffman编码

    /**
     * 将传入的node节点的所有叶子节点的huffman编码拿到 并且放入集合中
     *
     * @param node         传入的节点
     * @param code         向左为0 向右为1
     * @param stringBuffer 用于拼接的字符串
     */
    public static void getCodes(Node node, String code, StringBuffer stringBuffer) {
        //整个方法其实主要就是拼接codes
        StringBuffer stringBuffer1 = new StringBuffer(stringBuffer);
        stringBuffer1.append(code);
        if (node != null) { //如果传入的节点不为空 那么我们就递归处理 左0右1
            if (node.data == null) { //说明不是叶子节点
                getCodes(node.left, "0", stringBuffer1);
                getCodes(node.right, "1", stringBuffer1);
            } else { //说明是叶子节点 路径已经形成了 放入即可
                huffmanCodes.put(node.data, stringBuffer1.toString());
            }
        }
    }

    //创建node节点
    static class Node implements Comparable<Node> {
        Byte data;  // 'a' => 97
        int weight;
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        //为了方便排序 继承接口 重写方法
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        //前序遍历
        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }
}
