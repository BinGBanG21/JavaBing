/*
    多线程基础
        程序
            是为完成特定任务、用某种语言编写的一组指令的集合。简单的说就是我们写的代码
        线程与进程
            进程
                1.进程是指运行中的程序，比如我们使用QQ，就启动了一个进程，操作系统就会为该进程分配内存空间。
                  当我们使用迅雷，又启动了一个进程，操作系统将为迅雷分配新的内存空间。
                2.进程是程序的一次执行过程，或是正在运行的一个程序。
                  他是动态过程∶有它自身的产生、存在和消亡的过程
            线程
                1.线程由进程创建的，是进程的一个实体
                2.一个进程可以拥有多个线程
            其他概念
                单线程与多线程
                    1.单线程∶同一个时刻，只允许执行一个线程
                    2.多线程∶同一个时刻，可以执行多个线程，比如∶一个qq进程，可以同时打开多个聊天窗口，一个迅雷进程，可以同时下载多个文件
                并发与并行
                    3.并发同一个时刻，多个任务交替执行，造成一种“貌似同时”的错觉，简单的说，单核cpu实现的多任务就是并发。
                    4.并行同一个时刻，多个任务同时执行。多核cpu可以实现并行。
                    并发和并行可能同时发生
       线程基本使用
            创建线程的两种方式
                在java中线程来使用有两种方法。
                    1.继承Thread类，重写run方法
                    2.实现Runnable接口，重写run方法
       继承 Thread vs 实现 Runnable 的区别
            1. 从java的设计来看，通过继承Thread或者实现Runnable接口来创建线程本质上没有区别
               从jdk帮助文档我们可以看到Thread类本身就实现了Runnable接口
            2. 实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制，建议使用Runnable
       线程终止
            1.当线程完成任务后，会自动退出。
            2. 还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式
       线程常用方法
            1.setName       //设置线程名称，使之与参数name相同
            2.getName       //返回该线程的名称
            3.start         //使该线程开始执行；Java 虚拟机底层调用该线程的start0方法
            4.run           //调用线程对象run方法；
            5.setPriority   //更改线程的优先级
            6.getPriority   //获取线程的优先级
            7.sleep         //在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）
            8.interrupt     //中断线程
       注意事项和细节
            1.start 底层会创建新的线程，调用run，run就是一个简单的方法调用，不会启动新线程
            2.线程优先级的范围
            3.interrupt，中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程
            4.sleep∶线程的静态方法，使当前线程休眠
            5.yield∶线程的礼让。让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
            6.join∶线程的插队。插队的线程一旦插队成功，则肯定执行完毕，先执行完插入的线程所有的任务
       用户线程和守护线程
            1.用户线程也叫工作线程，当线程的任务执行完或通知方式结束
            2.守护线程∶一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
            3.常见的守护线程垃圾回收机制
       线程的生命周期
            JDK 中用 Thread.State 枚举表示了线程的几种状态
            线程可以处于以下状态之一∶
                ● NEW               尚未启动的线程处于此状态。
                ● RUNNABLE          在Java虚拟机中执行的线程处于此状态。
                ● BLOCKED           被阻塞等待监视器锁定的线程处于此状态。
                ● WAITING           正在等待另一个线程执行特定动作的线程处于此状态。
                ● TIMED WAITING     正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。
                ● TERMINATED        已退出的线程处于此状态。
        线程同步机制
            1.在多线程编程，一些敏感数据不允许被多个线程同时访问，
              此时就使用同步访问技术，保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性。
            2.也可以这里理解∶ 线程同步， 即当有一个线程在对内存进行操作时， 其他线程都不可以对这个内存地址进行操作，
              直到该线程完成操作，其他线程才能对该内存地址进行操作。
        同步具体方法-Synchronized
            1.同步代码块
            synchronized（对象）{/得到对象的锁，才能操作同步代码
                //需要被同步代码；
            }
            2. synchronized还可以放在方法声明中， 表示整个方法·为同步方法
            public synchronized void m (String name){
                 //需要被同步的代码
            }

* */

public class Thread_base {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpus = runtime.availableProcessors();
        System.out.println(cpus);
    }
}
