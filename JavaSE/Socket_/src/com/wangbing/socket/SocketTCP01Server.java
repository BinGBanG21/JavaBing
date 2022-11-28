package com.wangbing.socket;/*
 * @author WangBing
 * @version 1.0
    Socket
        1.套接字（Socket）开发网络应用程序被广泛采用，以至于成为事实上的标准。
        2.通信的两端都要有Socket，是两台机器间通信的端点
        3.网络通信其实就是Socket间的通信。
        4.Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
        5.一般主动发起通信的应用程序属客户端，等待通信请求的为服务端
     TCP 网络通信编程
        1.基于客户端—服务端的网络通信
        2.底层使用的是TCP/IP协议
        3.应用场景举例客户端发送数据，服务端接受并显示控制台
        4.基于Socket的TCP编程

 **/

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的 9999 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接..");
        //2. 当没有客户端连接 9999 端口时，程序会 阻塞, 等待连接
        // 如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket =" + socket.getClass());
        //
        //3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO 读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));//根据读取到的实际长度，显示内容. }
            //5.关闭流和 socket
            inputStream.close();
            socket.close();
            serverSocket.close();//关闭
        }
    }
}
