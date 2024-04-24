public class SaveAndFunc {
    public static void main(String[] args) {

    }
    /*
    1. 存储过程概述
        1) 理解
            含义：存储过程的英文是 Stored Procedure 。它的思想很简单，就是一组经过 预先编译的 SQL 语句 的封装。
            执行过程：存储过程预先存储在 MySQL 服务器上，需要执行的时候，客户端只需要向服务器端发出调用存储过程的命令
                     服务器端就可以把预先存储好的这一系列 SQL 语句全部执行。
            好处：
            * 1、简化操作，提高了sql语句的重用性，减少了开发程序员的压力。
            * 2、减少操作过程中的失误，提高效率。
            * 3、减少网络传输量（客户端不需要把所有的 SQL 语句通过网络发给服务器）。
            * 4、减少了 SQL 语句暴露在 网上的风险，也提高了数据查询的安全性。
            和视图、函数的对比：
                它和视图有着同样的优点，清晰、安全，还可以减少网络传输量。不过它和视图不同，视图是虚拟表 ，通常不对底层数据表直接操作
                而存储过程是程序化的 SQL，可以 直接操作底层数据表 ，相比于面向集合的操作方式，能够实现一些更复杂的数据处理。
                一旦存储过程被创建出来，使用它就像使用函数一样简单，我们直接通过调用存储过程名即可。相较于函数，存储过程是 没有返回值 的。
       2) 分类
            存储过程的参数类型可以是IN、OUT和INOUT。根据这点分类如下：
            1、没有参数（无参数无返回）
            2、仅仅带 IN 类型（有参数无返回）
            3、仅仅带 OUT 类型（无参数有返回）
            4、既带 IN 又带 OUT（有参数有返回）
            5、带 INOUT（有参数有返回）
            注意：IN、OUT、INOUT 都可以在一个存储过程中带多个。
    2. 创建存储过程
        1) 语法分析
            语法：
            CREATE PROCEDURE 存储过程名(IN|OUT|INOUT 参数名 参数类型,...)
            [characteristics ...]
            BEGIN
            存储过程体
            END

            说明：
            1、参数前面的符号的意思
                * IN ：当前参数为输入参数，也就是表示入参；
                  存储过程只是读取这个参数的值。如果没有定义参数种类， 默认就是 IN ，表示输入参数。
                * OUT ：当前参数为输出参数，也就是表示出参；
                  执行完成之后，调用这个存储过程的客户端或者应用程序就可以读取这个参数返回的值了。
                * INOUT ：当前参数既可以为输入参数，也可以为输出参数。
            2、形参类型可以是 MySQL数据库中的任意类型。
            3、characteristics 表示创建存储过程时指定的对存储过程的约束条件，其取值信息如下：
                LANGUAGE SQL
                | [NOT] DETERMINISTIC
                | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
                | SQL SECURITY { DEFINER | INVOKER }
                | COMMENT 'string'

                * LANGUAGE SQL ：说明存储过程执行体是由SQL语句组成的，当前系统支持的语言为SQL。
                * [NOT] DETERMINISTIC ：指明存储过程执行的结果是否确定。DETERMINISTIC表示结果是确定 的。每次执行存储过程时，相同的输入会得到相同的输出。NOT DETERMINISTIC表示结果是不确定 的，相同的输入可能得到不同的输出。如果没有指定任意一个值，默认为NOT DETERMINISTIC。
                * { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA } ：指明子程序使 用SQL语句的限制。
                  + CONTAINS SQL表示当前存储过程的子程序包含SQL语句，但是并不包含读写数据的SQL语句；
                  + NO SQL表示当前存储过程的子程序中不包含任何SQL语句；
                  + READS SQL DATA表示当前存储过程的子程序中包含读数据的SQL语句；
                  + MODIFIES SQL DATA表示当前存储过程的子程序中包含写数据的SQL语句。
                  + 默认情况下，系统会指定为CONTAINS SQL。
                * SQL SECURITY { DEFINER | INVOKER } ：执行当前存储过程的权限，即指明哪些用户能够执行当前存储过程。
                  + DEFINER 表示只有当前存储过程的创建者或者定义者才能执行当前存储过程；
                  + INVOKER 表示拥有当前存储过程的访问权限的用户能够执行当前存储过程。
                * COMMENT 'string' ：注释信息，可以用来描述存储过程。
            4、存储过程体中可以有多条 SQL 语句，如果仅仅一条SQL 语句，则可以省略 BEGIN 和 END
                1. BEGIN…END：BEGIN…END 中间包含了多个语句，每个语句都以（;）号为结束符。
                2. DECLARE：DECLARE 用来声明变量，使用的位置在于 BEGIN…END 语句中间，而且需要在其他语句使用之前进行变量的声明。
                3. SET：赋值语句，用于对变量进行赋值。
                4. SELECT… INTO：把从数据表中查询的结果存放到变量中，也就是为变量赋值。
            5、需要设置新的结束标记
                DELIMITER 新的结束标记




     */
}
