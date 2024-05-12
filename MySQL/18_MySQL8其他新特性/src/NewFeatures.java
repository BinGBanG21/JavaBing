public class NewFeatures {
    public static void main(String[] args) {

    }
    /*
    1) MySQL8.0 新增特性
        1. 更简便的NoSQL支持 NoSQL泛指非关系型数据库和数据存储。随着互联网平台的规模飞速发展，
           传统 的关系型数据库已经越来越不能满足需求。从5.6版本开始，MySQL就开始支持简单的NoSQL存储功能。
           MySQL 8对这一功能做了优化，以更灵活的方式实现NoSQL功能，不再依赖模式（schema）。
        2. 更好的索引 在查询中，正确地使用索引可以提高查询的效率。MySQL 8中新增了 隐藏索引 和 降序索 引 。
           隐藏索引可以用来测试去掉索引对查询性能的影响。在查询中混合存在多列索引时，使用降序索引 可以提高查询的性能。
        3. 更完善的JSON支持 MySQL从5.7开始支持原生JSON数据的存储，MySQL 8对这一功能做了优化，增加 了聚合函数 JSON_ARRAYAGG() 和 JSON_OBJECTAGG()
           将参数聚合为JSON数组或对象，新增了行内 操作符 ->>，是列路径运算符 ->的增强，对JSON排序做了提升，并优化了JSON的更新操作。
        4. 安全和账户管理 MySQL 8中新增了 caching_sha2_password 授权插件、角色、密码历史记录和FIPS 模式支持，
           这些特性提高了数据库的安全性和性能，使数据库管理员能够更灵活地进行账户管理工作。
        5. InnoDB的变化 InnoDB是MySQL默认的存储引擎 ，是事务型数据库的首选引擎，支持事务安全表 （ACID），支持行锁定和外键。在MySQL 8 版本中，InnoDB在自增、索引、加密、死锁、共享锁等方面 做了大量的 改进和优化 ，并且支持原子数据定义语言（DDL），
           提高了数据安全性，对事务提供更好的 支持。
        6. 数据字典 在之前的MySQL版本中，字典数据都存储在元数据文件和非事务表中。从MySQL 8开始新增 了事务数据字典，在这个字典里存储着数据库对象信息，这些数据字典存储在内部事务表中。
        7. 原子数据定义语句 MySQL 8开始支持原子数据定义语句（Automic DDL），即 原子DDL 。目前，只有 InnoDB存储引擎支持原子DDL。原子数据定义语句（DDL）将与DDL操作相关的数据字典更新、存储引擎 操作、二进制日志写入结合到一个单独的原子事务中，这使得即使服务器崩溃，事务也会提交或回滚。
           使用支持原子操作的存储引擎所创建的表，在执行DROP TABLE、CREATE TABLE、ALTER TABLE、 RENAME TABLE、TRUNCATE TABLE、CREATE TABLESPACE、DROP TABLESPACE等操作时，都支持原子操 作，即事务要么完全操作成功，要么失败后回滚，不再进行部分提交。
           对于从MySQL 5.7复制到MySQL 8 版本中的语句，可以添加 IF EXISTS 或 IF NOT EXISTS 语句来避免发生错误。
        8. 资源管理 MySQL 8开始支持创建和管理资源组，允许将服务器内运行的线程分配给特定的分组，以便 线程根据组内可用资源执行。组属性能够控制组内资源，启用或限制组内资源消耗。数据库管理员能够 根据不同的工作负载适当地更改这些属性。
           目前，CPU时间是可控资源，由“虚拟CPU”这个概念来表 示，此术语包含CPU的核心数，超线程，硬件线程等等。
           服务器在启动时确定可用的虚拟CPU数量。拥有 对应权限的数据库管理员可以将这些CPU与资源组关联，并为资源组分配线程。 资源组组件为MySQL中的资源组管理提供了SQL接口。资源组的属性用于定义资源组。MySQL中存在两个默认组，系统组和用户 组，默认的组不能被删除，其属性也不能被更改。
           对于用户自定义的组，资源组创建时可初始化所有的 属性，除去名字和类型，其他属性都可在创建之后进行更改。
           在一些平台下，或进行了某些MySQL的配 置时，资源管理的功能将受到限制，甚至不可用。例如，如果安装了线程池插件，或者使用的是macOS 系统，资源管理将处于不可用状态。在FreeBSD和Solaris系统中，资源线程优先级将失效。在Linux系统 中，只有配置了CAP_SYS_NICE属性，资源管理优先级才能发挥作用。
        9. 字符集支持 MySQL 8中默认的字符集由 latin1 更改为 utf8mb4 ，并首次增加了日语所特定使用的集 合，utf8mb4_ja_0900_as_cs。
        10.优化器增强 MySQL优化器开始支持隐藏索引和降序索引。隐藏索引不会被优化器使用，验证索引的必 要性时不需要删除索引，先将索引隐藏，如果优化器性能无影响就可以真正地删除索引。降序索引允许 优化器对多个列进行排序，并且允许排序顺序不一致。
        11.公用表表达式 公用表表达式（Common Table Expressions）简称为CTE，MySQL现在支持递归和非递 归两种形式的CTE。CTE通过在SELECT语句或其他特定语句前 使用WITH语句对临时结果集 进行命名。
           WITH cte_name (col_name1,col_name2 ...) AS (Subquery)
           SELECT * FROM cte_name;
        12.窗口函数 MySQL 8开始支持窗口函数。在之前的版本中已存在的大部分 聚合函数 在MySQL 8中也可以 作为窗口函数来使用。
        13.正则表达式支持 MySQL在8.0.4以后的版本中采用支持Unicode的国际化组件库实现正则表达式操作， 这种方式不仅能提供完全的Unicode支持，而且是多字节安全编码。MySQL增加了REGEXP_LIKE()、 EGEXP_INSTR()、REGEXP_REPLACE()和 REGEXP_SUBSTR()等函数来提升性能。
           另外，regexp_stack_limit和 regexp_time_limit 系统变量能够通过匹配引擎来控制资源消耗。
        14.内部临时表 TempTable存储引擎取代MEMORY存储引擎成为内部临时表的默认存储引擎 。TempTable存储 引擎为VARCHAR和VARBINARY列提供高效存储。internal_tmp_mem_storage_engine会话变量定义了内部 临时表的存储引擎，可选的值有两个，TempTable和MEMORY，其中TempTable为默认的存储引擎。
           temptable_max_ram系统配置项定义了TempTable存储引擎可使用的最大内存数量。
        15.日志记录 在MySQL 8中错误日志子系统由一系列MySQL组件构成。这些组件的构成由系统变量 log_error_services来配置，能够实现日志事件的过滤和写入。 WITH cte_name (col_name1,col_name2 ...) AS (Subquery) SELECT * FROM cte_name;
        16.备份锁 新的备份锁允许在线备份期间执行数据操作语句，同时阻止可能造成快照不一致的操作。新 备份锁由 LOCK INSTANCE FOR BACKUP 和 UNLOCK INSTANCE 语法提供支持，执行这些操作需要备份管理 员特权。
        17.增强的MySQL复制 MySQL 8复制支持对 JSON文档 进行部分更新的 二进制日志记录 ，该记录 使用紧凑 的二进制格式 ，从而节省记录完整JSON文档的空间。当使用基于语句的日志记录时，这种紧凑的日志记 录会自动完成，并且可以通过将新的binlog_row_value_options系统变量值设置为PARTIAL_JSON来启用。
    2. 新特性1：窗口函数
        1) 窗口函数分类
            MySQL从8.0版本开始支持窗口函数。窗口函数的作用类似于在查询中对数据进行分组，不同的是，分组操作会把分组的结果聚合成一条记录，而窗口函数是将结果置于每一条数据记录中。
            窗口函数可以分为 静态窗口函数 和 动态窗口函数 。
            * 静态窗口函数的窗口大小是固定的，不会因为记录的不同而不同；
            * 动态窗口函数的窗口大小会随着记录的不同而变化。
            MySQL官方网站窗口函数的网址为https://dev.mysql.com/doc/refman/8.0/en/window-function-descriptio ns.html#function_row-number。
            窗口函数总体上可以分为序号函数、分布函数、前后函数、首尾函数和其他函数
        2) 语法结构
            窗口函数的语法结构是：
            函数 OVER（[PARTITION BY 字段名 ORDER BY 字段名 ASC|DESC]）
            函数 OVER 窗口名 … WINDOW 窗口名 AS （[PARTITION BY 字段名 ORDER BY 字段名 ASC|DESC]）
            * OVER 关键字指定函数窗口的范围。
              * 如果省略后面括号中的内容，则窗口会包含满足WHERE条件的所有记录，窗口函数会基于所有满足WHERE条件的记录进行计算。
              * 如果OVER关键字后面的括号不为空，则可以使用如下语法设置窗口。
            * 窗口名：为窗口设置一个别名，用来标识窗口。
            * PARTITION BY子句：指定窗口函数按照哪些字段进行分组。分组后，窗口函数可以在每个分组中分别执行。
            * ORDER BY子句：指定窗口函数按照哪些字段进行排序。执行排序操作使窗口函数按照排序后的数据记录的顺序进行编号。
            * FRAME子句：为分区中的某个子集定义规则，可以用来作为滑动窗口使用。
        3) 具体分类
            1) 序号函数
                1. ROW_NUMBER()函数
                    ROW_NUMBER()函数能够对数据中的序号进行顺序显示。
                2．RANK()函数
                    使用RANK()函数能够对序号进行并列排序，并且会跳过重复的序号，比如序号为1、1、3。
                3．DENSE_RANK()函数
                    DENSE_RANK()函数对序号进行并列排序，并且不会跳过重复的序号，比如序号为1、1、2。
            2) 分布函数
                1．PERCENT_RANK()函数
                    PERCENT_RANK()函数是等级值百分比函数。按照如下方式进行计算
                    (rank - 1) / (rows - 1)
                    其中，rank的值为使用RANK()函数产生的序号，rows的值为当前窗口的总记录数
                2．CUME_DIST()函数
                    CUME_DIST()函数主要用于查询小于或等于某个值的比例。
            3) 前后函数
                    1．LAG(expr,n)函数
                        LAG(expr,n)函数返回当前行的前n行的expr的值。
                    2．LEAD(expr,n)函数
                        LEAD(expr,n)函数返回当前行的后n行的expr的值。
            4) 首尾函数
                    1．FIRST_VALUE(expr)函数
                        FIRST_VALUE(expr)函数返回第一个expr的值。
                      LAST_VALUE(expr)函数
                        LAST_VALUE(expr)函数返回最后一个expr的值。
    3. 新特性2：公用表表达式
        公用表表达式（或通用表表达式）简称为CTE（Common Table Expressions）。CTE是一个命名的临时结 果集，作用范围是当前语句。
        CTE可以理解成一个可以复用的子查询，当然跟子查询还是有点区别的， CTE可以引用其他CTE，但子查询不能引用其他子查询。
        所以，可以考虑代替子查询。
        1) 普通公用表表达式
            普通公用表表达式的语法结构是：
            WITH CTE名称
            AS （子查询）
            SELECT|DELETE|UPDATE 语句;
            普通公用表表达式类似于子查询，不过，跟子查询不同的是，它可以被多次引用，而且可以被其他的普 通公用表表达式所引用。
        2)  递归公用表表达式
            递归公用表表达式也是一种公用表表达式，只不过，除了普通公用表表达式的特点以外，它还有自己的特点，就是可以调用自己。
            WITH RECURSIVE
            CTE名称 AS （子查询）
            SELECT|DELETE|UPDATE 语句;
            递归公用表表达式由 2 部分组成，分别是种子查询和递归查询，中间通过关键字 UNION [ALL]进行连接。
            这里的种子查询，意思就是获得递归的初始值。这个查询只会运行一次，以创建初始数据集，之后递归 查询会一直执行，
            直到没有任何新的查询数据产生，递归返回。



     */
}
