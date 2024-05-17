public class Lin {
    public static void main(String[] args) {

    }
    /*
    1.安装
        1.1 Linux系统及工具的准备
            安装并启动好两台虚拟机： CentOS 7
                掌握克隆虚拟机的操作
                    mac地址
                    主机名
                    ip地址
                    UUID
            安装有 Xshell 和 Xftp 等访问CentOS系统的工具
            CentOS6和CentOS7在MySQL的使用中的区别
                1. 防火墙：6是iptables，7是firewalld
                2. 启动服务的命令：6是service，7是systemctl
        1.2 查看是否安装过MySQL
            用rpm安装, 检查一下RPM PACKAGE
                rpm -qa | grep -i mysql # -i 忽略大小写
            检查mysql service
                systemctl status mysqld.service
       1.3 MySQL的卸载
            1. 关闭 mysql 服务
                systemctl stop mysqld.service
            2. 查看当前 mysql 安装状况
                rpm -qa | grep -i mysql
                或
                yum list installed | grep mysql
            3. 卸载上述命令查询出的已安装程序
                yum remove mysql-xxx mysql-xxx mysql-xxx mysqk-xxxx
            4. 删除 mysql 相关文件
                查找相关文件
                    find / -name mysql
                删除上述命令查找出的相关文件
                    rm -rf xxx
            5.删除 my.cnf
                rm -rf /etc/my.cnf
    2. MySQL的Linux版安装
        方式1：rpm命令
            使用rpm命令安装扩展名为".rpm"的软件包。
        方式2：yum命令
            需联网，从 互联网获取 的yum源，直接使用yum命令安装。
        方式3：编译安装源码包
            针对 tar.gz 这样的压缩格式，要用tar命令来解压；如果是其它压缩格式，就使用其它命令。

        2.1 CentOS7下检查MySQL依赖
            1. 检查/tmp临时目录权限（必不可少）
                由于mysql安装过程中，会通过mysql用户在/tmp目录下新建tmp_db文件，所以请给/tmp较大的权限。执行
                    chmod -R 777 /tmp
            2. 安装前，检查依赖
                rpm -qa|grep libaio

        2.2 CentOS7下MySQL安装过程
            1. 将安装程序拷贝到/opt目录下
                在mysql的安装文件目录下执行：（必须按照顺序执行）
                rpm -ivh mysql-community-common-8.0.25-1.el7.x86_64.rpm
                rpm -ivh mysql-community-client-plugins-8.0.25-1.el7.x86_64.rpm
                rpm -ivh mysql-community-libs-8.0.25-1.el7.x86_64.rpm
                rpm -ivh mysql-community-client-8.0.25-1.el7.x86_64.rpm
                rpm -ivh mysql-community-server-8.0.25-1.el7.x86_64.rpm
                注意: 如在检查工作时，没有检查mysql依赖环境在安装mysql-community-server会报错
                rpm 是Redhat Package Manage缩写，通过RPM的管理，用户可以把源代码包装成以rpm为扩展名的
                文件形式，易于安装。
                -i , --install 安装软件包
                -v , --verbose 提供更多的详细信息输出
                -h , --hash 软件包安装的时候列出哈希标记 (和 -v 一起使用效果更好)，展示进度条
            2. 查看MySQL版本
                    mysql --version
                    或
                    mysqladmin --version
                执行如下命令，查看是否安装成功。需要增加 -i 不用去区分大小写，否则搜索不到。
                    rpm -qa|grep -i mysql
            3. 服务的初始化
                为了保证数据库目录与文件的所有者为 mysql 登录用户，如果你是以 root 身份运行 mysql 服务，需要执
                行下面的命令初始化：
                    mysqld --initialize --user=mysql
                说明： --initialize 选项默认以“安全”模式来初始化，则会为 root 用户生成一个密码并将 该密码标记为过
                期 ，登录后你需要设置一个新的密码。生成的 临时密码 会往日志中记录一份。
                查看密码：
                    cat /var/log/mysqld.log
            4. 启动MySQL，查看状态
                #加不加.service后缀都可以
                启动：systemctl start mysqld.service
                关闭：systemctl stop mysqld.service
                重启：systemctl restart mysqld.service
                查看状态：systemctl status mysqld.service
            5. 查看MySQL服务是否自启动
                systemctl list-unit-files|grep mysqld.service
                如不是enabled可以运行如下命令设置自启动
                    systemctl enable mysqld.service
                如果希望不进行自启动，运行如下命令设置
                    systemctl disable mysqld.service
      3. MySQL登录
            3.1 首次登录
                通过 mysql -hlocalhost -P3306 -uroot -p 进行登录，在Enter password：录入初始化密码
            3.2 修改密码
                因为初始化密码默认是过期的，所以查看数据库会报错
                修改密码
                    ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';
            3.3 设置远程登录
                1. 当前问题
                    在用SQLyog或Navicat中配置远程连接Mysql数据库时遇到如下报错信息，这是由于Mysql配置了不支持远
                    程连接引起的。
                2. 确认网络
                    1.在远程机器上使用ping ip地址 保证网络畅通
                    2.在远程机器上使用telnet命令 保证端口号开放 访问
                    telnet ip地址 端口号
                3. 关闭防火墙或开放端口
                    方式一：关闭防火墙
                        CentOS6 ：service iptables stop
                        CentOS7：
                        systemctl start firewalld.service
                        systemctl status firewalld.service
                        systemctl stop firewalld.service
                        #设置开机启用防火墙
                        systemctl enable firewalld.service
                        #设置开机禁用防火墙
                        systemctl disable firewalld.service
                    方式二：开放端口
                        查看开放的端口号
                            firewall-cmd --list-all
                        设置开放的端口号
                            firewall-cmd --add-service=http --permanent
                            firewall-cmd --add-port=3306/tcp --permanent
                        重启防火墙
                            firewall-cmd --reload
                4. Linux下修改配置
                    在Linux系统MySQL下测试：
                        use mysql;
                        select Host,User from user;
                    修改Host为通配符%
                        Host列指定了允许用户登录所使用的IP，比如user=root Host=192.168.1.1。这里的意思就是说root用户只
                        能通过192.168.1.1的客户端去访问。 user=root Host=localhost，表示只能通过本机客户端去访问。而 %
                        是个 通配符，如果Host=192.168.1.%，那么就表示只要是IP地址前缀为“192.168.1.”的客户端都可以连
                        接。如果 Host=% ，表示所有IP都有连接权限。
                        注意：在生产环境下不能为了省事将host设置为%，这样做会存在安全问题，具体的设置可以根据生产
                        环境的IP进行设置
                            update user set host = '%' where user ='root';
                        Host设置了“%”后便可以允许远程访问。
                    Host修改完成后记得执行flush privileges使配置立即生效：
                        flush privileges;



     */
}
