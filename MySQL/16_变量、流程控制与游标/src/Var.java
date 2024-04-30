public class Var {
    public static void main(String[] args) {

    }
    /*
    1. 变量
        在MySQL数据库的存储过程和函数中，可以使用变量来存储查询或计算的中间结果数据，或者输出最终 的结果数据。
        在 MySQL 数据库中，变量分为 系统变量 以及 用户自定义变量 。

        1) 系统变量

            系统变量分类
            变量由系统定义，不是用户定义，属于 服务器 层面。启动MySQL服务，生成MySQL服务实例期间， MySQL将为MySQL服务器内存中的系统变量赋值，这些系统变量定义了当前MySQL服务实例的属性、特征
            这些系统变量的值要么是 编译MySQL时参数 的默认值，要么是配置文件
            系统变量分为全局系统变量（需要添加 global 关键字）以及会话系统变量（需要添加 session 关键字）
            有时也把全局系统变量简称为全局变量，有时也把会话系统变量称为local变量。如果不写，默认会话级别。
            静态变量（在 MySQL 服务实例运行期间它们的值不能使用 set 动态修改）属于特殊的全局系统变量。
            每一个MySQL客户机成功连接MySQL服务器后，都会产生与之对应的会话。
            会话期间，MySQL服务实例会在MySQL服务器内存中生成与该会话对应的会话系统变量，这些会话系统变量的初始值是全局系统变量值的复制。

            查看系统变量
            查看所有或部分系统变量
                #查看所有全局变量
                SHOW GLOBAL VARIABLES;
                #查看所有会话变量
                SHOW SESSION VARIABLES;
                或
                SHOW VARIABLES;
            查看满足条件的部分系统变量。
                SHOW GLOBAL VARIABLES LIKE '%标识符%';
                #查看满足条件的部分会话变量
                SHOW SESSION VARIABLES LIKE '%标识符%';
            查看指定系统变量
                作为 MySQL 编码规范，MySQL 中的系统变量以 两个“@” 开头，其中“@@global”仅用于标记全局系统变量，“@@session”仅用于标记会话系统变量。
                “@@”首先标记会话系统变量，如果会话系统变量不存在， 则标记全局系统变量
            查看指定的系统变量的值
                SELECT @@global.变量名;
                #查看指定的会话变量的值
                SELECT @@session.变量名;
                #或者
                SELECT @@变量名;
            修改系统变量的值
                有些时候，数据库管理员需要修改系统变量的默认值，以便修改当前会话或者MySQL服务实例的属性、 特征。具体方法：
                方式1：修改MySQL 配置文件 ，继而修改MySQL系统变量的值（该方法需要重启MySQL服务）
                方式2：在MySQL服务运行期间，使用“set”命令重新设置系统变量的值
            为某个系统变量赋值
                #方式1：
                SET @@global.变量名=变量值;
                #方式2：
                SET GLOBAL 变量名=变量值;
                #为某个会话变量赋值
                #方式1：
                SET @@session.变量名=变量值;
                #方式2：
                SET SESSION 变量名=变量值;

        2) 用户变量
            用户变量分类
                用户变量是用户自己定义的，作为 MySQL 编码规范，MySQL 中的用户变量以一个“@” 开头。
                根据作用范围不同，又分为 会话用户变量 和 局部变量 。
                * 会话用户变量：作用域和会话变量一样，只对 当前连接 会话有效。
                * 局部变量：只在 BEGIN 和 END 语句块中有效。局部变量只能在 存储过程和函数 中使用。





     */
}
