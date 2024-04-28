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
    3.调用存储过程
        1) 调用格式
        存储过程有多种调用方法。存储过程必须使用CALL语句调用，并且存储过程和数据库相关，如果要执行其他数据库中的存储过程，需要指定数据库名称，
        例如CALL dbname.procname。
            1、调用in模式的参数：
                CALL sp1('值');
            2、调用out模式的参数：
                SET @name;
                CALL sp1(@name);
                SELECT @name;
            3、调用inout模式的参数：
                SET @name=值;
                CALL sp1(@name);
                SELECT @name;
    4. 存储函数的使用
        1) 语法分析
            语法格式：
            CREATE FUNCTION 函数名(参数名 参数类型,...)
            RETURNS 返回值类型
            [characteristics ...]
            BEGIN
            函数体 #函数体中肯定有 RETURN 语句
            END
            说明：
            1、参数列表：指定参数为IN、OUT或INOUT只对PROCEDURE是合法的，FUNCTION中总是默认为IN参数。
            2、RETURNS type 语句表示函数返回数据的类型； RETURNS子句只能对FUNCTION做指定，对函数而言这是强制的。
              它用来指定函数的返回类型，而且函 数体必须包含一个 RETURN value 语句。
            3、characteristic 创建函数时指定的对函数的约束。取值与创建存储过程时相同，这里不再赘述。
            4、函数体也可以用BEGIN…END来表示SQL代码的开始和结束。如果函数体只有一条语句，也可以省略 BEGIN…END。
        2) 调用存储函数
            在MySQL中，存储函数的使用方法与MySQL内部函数的使用方法是一样的。换言之，用户自己定义的存储函数与MySQL内部函数是一个性质的。
            区别在于，存储函数是 用户自己定义 的，而内部函数是MySQL 的 开发者定义 的。
            SELECT 函数名(实参列表)
        3) 对比存储函数与存储过程
            |          | 关键字    | 调用语法        | 返回值            | 应用场景                         |
            | -------- | --------- | --------------- | ----------------- | --------------------------  |
            | 存储过程 | PROCEDURE | CALL 存储过程() | 理解为有0个或多个 | 一般用于更新                     |
            | 存储函数 | FUNCTION  | SELECT 函数 ()  | 只能是一个        | 一般用于查询结果为一个值并返回时 |
    5. 存储过程和函数的查看、修改、删除
        1) 查看
            MySQL存储了存储过程和函数的状态信息，用户可以使用SHOW STATUS语句或SHOW CREATE语句来查看，
            也可直接从系统的information_schema数据库中查询。
            1. 使用SHOW CREATE语句查看存储过程和函数的创建信息
            SHOW CREATE {PROCEDURE | FUNCTION} 存储过程名或函数名
            ```
            2. 使用SHOW STATUS语句查看存储过程和函数的状态信息
            SHOW {PROCEDURE | FUNCTION} STATUS [LIKE 'pattern']
            ```

            3. 从information_schema.Routines表中查看存储过程和函数的信息
            MySQL中存储过程和函数的信息存储在information_schema数据库下的Routines表中。
            可以通过查询该表的记录来查询存储过程和函数的信息。其基本语法形式如下：
            SELECT * FROM information_schema.Routines
            WHERE ROUTINE_NAME='存储过程或函数的名' [AND ROUTINE_TYPE = {'PROCEDURE|FUNCTION'}];
            ```

            说明：如果在MySQL数据库中存在存储过程和函数名称相同的情况，最好指定ROUTINE_TYPE查询条件来 指明查询的是存储过程还是函数。
        2) 修改
            修改存储过程或函数，不影响存储过程或函数功能，只是修改相关特性。使用ALTER语句实现。
            ALTER {PROCEDURE | FUNCTION} 存储过程或函数的名 [characteristic ...]

            其中，characteristic指定存储过程或函数的特性，其取值信息与创建存储过程、函数时的取值信息略有不同。
            { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
            | SQL SECURITY { DEFINER | INVOKER }
            | COMMENT 'string'

            * CONTAINS SQL ，表示子程序包含SQL语句，但不包含读或写数据的语句。
            * NO SQL ，表示子程序中不包含SQL语句。
            * READS SQL DATA ，表示子程序中包含读数据的语句。
            * MODIFIES SQL DATA ，表示子程序中包含写数据的语句。
            * SQL SECURITY { DEFINER | INVOKER } ，指明谁有权限来执行。
              * DEFINER ，表示只有定义者自己才能够执行。
              * INVOKER ，表示调用者可以执行。
            * COMMENT 'string' ，表示注释信息。
        3) 删除
            删除存储过程和函数，可以使用DROP语句，其语法结构如下：
            DROP {PROCEDURE | FUNCTION} [IF EXISTS] 存储过程或函数的名
    6. 关于存储过程使用的争议
        1) 优点
            1、存储过程可以一次编译多次使用。存储过程只在创建时进行编译，之后的使用都不需要重新编译， 这就提升了 SQL 的执行效率。
            2、可以减少开发工作量。将代码 封装 成模块，实际上是编程的核心思想之一，
               这样可以把复杂的问题 拆解成不同的模块，然后模块之间可以重复使用,在减少开发工作量的同时，还能保证代码的结构清 晰。
            3、存储过程的安全性强。我们在设定存储过程的时候可以 设置对用户的使用权限 ，这样就和视图一样具 有较强的安全性。
            4、可以减少网络传输量。因为代码封装到存储过程中，每次使用只需要调用存储过程即可，这样就减 少了网络传输量。
            5、良好的封装性。在进行相对复杂的数据库操作时，原本需要使用一条一条的 SQL 语句，可能要连接多次数据库才能完成的操作，
               现在变成了一次存储过程，只需要 连接一次即可 。

        2) 缺点
            > 阿里开发规范 【强制】禁止使用存储过程，存储过程难以调试和扩展，更没有移植性。
            1、可移植性差。存储过程不能跨数据库移植，比如在 MySQL、Oracle 和 SQL Server 里编写的存储程，在换成其他数据库时都需要重新编写。
            2、调试困难。只有少数 DBMS 支持存储过程的调试。对于复杂的存储过程来说，开发和维护都不容易。
               虽然也有一些第三方工具可以对存储过程进行调试，但要收费。
            3、存储过程的版本管理很困难。比如数据表索引发生变化了，可能会导致存储过程失效。
               开发软件的时候往往需要进行版本管理，但是存储过程本身没有版本控制，版本迭代更新的时候很麻烦。
            4、它不适合高并发的场景。高并发的场景需要减少数据库的压力，有时数据库会采用分库分表的方式，
               而且对可扩展性要求很高，在这种情况下，存储过程会变得难以维护， 增加数据库的压力 ，显然就不适用了。




     */
}
