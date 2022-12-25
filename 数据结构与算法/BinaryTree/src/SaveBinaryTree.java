/*
    顺序存储二叉树
        从数据存储来看，数组存储方式和树的存储方式可以相互转换，
        即数组可以转换成树，树也可以转换成数组
        我的理解是：把一个有序的数组可以看成一个数 或者说通过一定的方法转化成一个树
    顺序存储二叉树的特点
        1.顺序二叉树通常只考虑完全二叉树
        2.第n个元素的左子节点为  2 * n + 1
        3.第n个元素的右子节点为  2 * n + 2
        4.第n个元素的父节点为  (n-1) / 2
        n : 表示二叉树中的第几个元素(按0开始编号 其实n就是索引)
*
* */

public class SaveBinaryTree {
    public static void main(String[] args) {

    }
}
//顺序存储二叉树遍历
//需求: 给你一个数组 {1,2,3,4,5,6,7}，要求以二叉树前序遍历的方式进行遍历。 前序遍历的结果应当为 1,2,4,5,3,6,7
class arrBinaryTree{
    public int[] arr ;

    public arrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //一个有序数组 按照二叉树的方式遍历 可以理解有序数组转二叉树
    public void arrToBinaryTree(int[] arr){

    }
}