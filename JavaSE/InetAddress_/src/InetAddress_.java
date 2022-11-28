/*
    InetAddress 类
        相关方法
            1.获取本机InetAddress对象getLocalHost
            2.根据指定主机名/域名获取ip地址对象getByName
            3.获取InetAddress对象的主机名getHostName
            4.获取InetAddress对象的地址getHostAddress

* */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_ {
    public static void main(String[] args) {
        try {
            //获取本机 InetAddress 对象 getLocalHost
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            //根据指定主机名/域名获取 ip 地址对象 getByName
            InetAddress host2 = InetAddress.getByName("ThinkPad-PC");
            System.out.println(host2);
            InetAddress host3 = InetAddress.getByName("www.baidu.com");
            System.out.println(host3);
            //获取 InetAddress 对象的主机名 getHostName
            String host3Name = host3.getHostName();
            System.out.println(host3Name);
            //获取 InetAddress 对象的地址 getHostAddress
            String host3Address = host3.getHostAddress();
            System.out.println(host3Address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
