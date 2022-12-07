/*
    队列（Queue）
        队列是一个有序列表，可以用数组或是链表来实现。
        遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出
    实现思路
        队列本身是有序列表，若使用数组的结构来存储队列的数据，需要一个变量 maxSize 来表示该队列的最大容量。
        因为队列的输出、输入是分别从前后端来处理，因此需要两个变量 front及 rear分别记录队列前后端的下标
        front 会随着数据输出而改变，而 rear则是随着数据输入而改变
        当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤：
         1.将尾指针往后移：rear+1 ,当front == rear 【空】
         2.若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear所指的数组元素中，否则无法存入数据。
           rear  == maxSize - 1[队列满]


* */


import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        QueueArray arrayQueue = new QueueArray(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你要添加的数据");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res =arrayQueue.getQueueData();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res =arrayQueue.headQueue();
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

class QueueArray {
    private int[] queue; //使用数组模拟队列
    private int front; //指向数组中第一个元素的前一个元素的索引 因为索引是从0开始 如果指向0 添加元素不好操作
    private int rear; //指向数组中最后一个的索引
    private int maxSize; //队列的容量


    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        //创建数组
        queue = new int[maxSize];
        //初始化指针
        front = -1;
        rear = -1;

    }

    //判断队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        this.queue[rear] = data;
        System.out.println("添加数据成功");

    }

    //从队列中取出数据
    public int getQueueData() {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了，不能删除");
        }
        front++;
        return this.queue[front];
        //java中的数组就是这样的 如果想删除元素 那么只能手动缩容 就是重新创建一个数组 然后把想要的数据拷贝过去 再把原数组赋值为null

    }

    //显示队列的所有数据
    public void showQueue() {
        //队列为空 无法判断
        if (isEmpty()) {
            System.out.println("当前队列为空");
        } else {
//            for (int i = 0; i < this.queue.length; i++) {
//                System.out.println();
//                System.out.printf("arr[%d]=%d", i, queue[i]);
//                System.out.println();
//            }
            for (int i : this.queue) {
                System.out.println(i);
            }
        }

    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        return this.queue[++front];
    }
}