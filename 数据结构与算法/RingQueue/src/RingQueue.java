/*
    队列的问题分析并优化
        1)目前数组使用一次就不能用，没有达到复用的效果(因为最后的索引都没有还原)
        2)将这个数组使用算法，改进成一个环形的队列(取模):
          这里%一下rear可以获得rear在环形队列上的真实位置
    思路如下:
        1. front变量的含义做一个调整:front就指向队列的第一个元素
           也就是说arr[front]就是队列的第一个元素
           front的初始值=0
        2. rear变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置.
           因为希望空出一个空间做为约定.rear的初始值=0
        3. 当队列满时，条件是(rear +1) % maxSize = front【满】
        4.对队列为空的条件，rear== front空
        5.当我们这样分析，队列中有效的数据的个数(rear + maxSize - front) % maxSize // rear= 1 front=0
        6.我们就可以在原来的队列上修改得到，一个环形队列

   注意:为什么rear要指向队列中最后一项的后一个位置
        循环队列中，当队列为空时，有front=rear；而当所有队列空间全占满时，也有front=rear。
        所以，为了区别这两种情况，规定循环队列最多只能有MaxSize-1个队列元素（也就是空一个位置，
        当循环队列中只剩下一个空存储单元时，队列就已经满了。
        因此，队列判空的条件是front=rear，而队列判满的条件是front=（rear+1)%MaxSize。


* */

import java.util.Scanner;

public class RingQueue {
    public static void main(String[] args) {
        CircleArray CircleArray = new CircleArray(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    CircleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你要添加的数据");
                    int value = scanner.nextInt();
                    CircleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res =CircleArray.getQueueData();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res =CircleArray.headQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;

            }
        }
        System.out.println("程序已退出~");
    }
}

class CircleArray {
    private int[] queue; //使用数组模拟队列
    private int front; //front就指向队列的第一个元素
    private int rear; //rear指向队列的最后一个元素的后一个位置
    private int maxSize; //队列的容量


    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        //创建数组
        queue = new int[maxSize];
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //向队列中添加数据
    public void addQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加");
        }
        //如果不满
        queue[rear] = data;
        //同时指针向后移动 注意要考虑越界的情况 因为是环形 所以要%maxSize
        rear = (rear + 1) % maxSize;

    }

    //从队列中取出数据
    public int getQueueData() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了，不能删除");
        }
        //如果队列没有满 则开始取数据
        //1.先把数据保存起来 因为如果先移动front的值 就拿不到数据了 肯定要根据front返回数据 不能arr[0]
        int value = queue[front];
        //移动front的值 并且% 防止无限+1越界
        front = (front +1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //队列为空 无法判断
        if (isEmpty()) {
            System.out.println("当前队列为空");
        } else {
            for (int i = front; i < size(); i++) {
                System.out.println();
                System.out.printf("arr[%d]=%d", i % maxSize, queue[i % maxSize]);
                System.out.println();
            }

        }

    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        return this.queue[front];
    }


    //求出当前队列有效数据的个数
    public int size(){
        //防止rear环形后小于front
        return (rear + maxSize -front) % maxSize;
    }
}