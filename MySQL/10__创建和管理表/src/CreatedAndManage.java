public class CreatedAndManage {
    public static void main(String[] args) {

    }
    /*
        1. 基础知识
          1) 标识符命名规则
            * 数据库名、表名不得超过30个字符，变量名限制为29个
            * 必须只能包含 A–Z, a–z, 0–9, _共63个字符
            * 数据库名、表名、字段名等对象名中间不要包含空格
            * 同一个MySQL软件中，数据库不能同名；同一个库中，表不能重名；同一个表中，字段不能重名
            * 必须保证你的字段没有和保留字、数据库系统或常用方法冲突。如果坚持使用，请在SQL语句中使 用`（着重号）引起来
            * 保持字段名和类型的一致性：在命名字段并为其指定数据类型的时候一定要保证一致性，假如数据 类型在一个表里是整数，
            那在另一个表里可就别变成字符型了
          2) MySQL中的数据类型
            | INT           | 从-2^31到2^31-1的整型数据。存储大小为 4个字节                 |
            | CHAR(size)    | FLOAT、DOUBLE                                           |
            | VARCHAR(size) | DECIMAL                                                 |
            | FLOAT(M,D)    | BIT                                                     |
            | DOUBLE(M,D)   | YEAR、TIME、DATE、DATETIME、TIMESTAMP                     |
            | DECIMAL(M,D)  | CHAR、VARCHAR、TINYTEXT、TEXT、MEDIUMTEXT、LONGTEXT       |
            | DATE          | ENUM                                                    |
            | BLOB          | SET                                                     |
            | TEXT          | BINARY、VARBINARY、TINYBLOB、BLOB、MEDIUMBLOB、LONGBLOB   |
       2. 创建和管理数据库
            1) 创建数据库
                * 方式1：创建数据库
                  CREATE DATABASE 数据库名;
                * 方式2：创建数据库并指定字符集
                  CREATE DATABASE 数据库名 CHARACTER SET 字符集;
                * 方式3：判断数据库是否已经存在，不存在则创建数据库（ 推荐 ）
                  CREATE DATABASE IF NOT EXISTS 数据库名;
                如果MySQL中已经存在相关的数据库，则忽略创建语句，不再创建数据库。
       3.创建表
           1) 创建方式1
            * 语法格式：
                CREATE TABLE [IF NOT EXISTS] 表名(
                字段1, 数据类型 [约束条件] [默认值],
                字段2, 数据类型 [约束条件] [默认值],
                字段3, 数据类型 [约束条件] [默认值],
                ……
                [表约束条件]
                );
                > 加上了IF NOT EXISTS关键字，则表示：如果当前数据库中不存在要创建的数据表，则创建数据表；
                  如果当前数据库中已经存在要创建的数据表，则忽略建表语句，不再创建数据表。

         2) 创建方式2
            * 使用 AS subquery 选项，将创建表和插入数据结合起来
                CREATE TABLE 表名
                    [(column, column, ...)]
                AS subquery;
            * 指定的列和子查询中的列要一一对应
            * 通过列名和默认值定义列
                CREATE TABLE dept80
                AS
                SELECT employee_id, last_name, salary*12 ANNSAL, hire_date
                FROM employees

        3) 查看数据表结构
            在MySQL中创建好数据表之后，可以查看数据表的结构。MySQL支持使用 DESCRIBE/DESC 语句查看数据 表结构，
            也支持使用 SHOW CREATE TABLE 语句查看数据表结构。
            语法格式如下：
            SHOW CREATE TABLE 表名\G
            ```
            使用SHOW CREATE TABLE语句不仅可以查看表创建时的详细语句，还可以查看存储引擎和字符编码。
    4. 修改表
        修改表指的是修改数据库中已经存在的数据表的结构。
        使用 ALTER TABLE 语句可以实现：
            + 向已有的表中添加列
            + 修改现有表中的列
            + 删除现有表中的列
            + 重命名现有表中的列
        1) 追加一个列
            语法格式如下：
            ALTER TABLE 表名 ADD 【COLUMN】 字段名 字段类型 【FIRST|AFTER 字段名】;
        2) 修改一个列
                * 可以修改列的数据类型，长度、默认值和位置
                * 修改字段数据类型、长度、默认值、位置的语法格式如下：
            ALTER TABLE 表名 MODIFY 【COLUMN】 字段名1 字段类型 【DEFAULT 默认值】【FIRST|AFTER 字段名2】;
                * 对默认值的修改只影响今后对表的修改
                * 此外，还可以通过此种方式修改列的约束。
        3) 重命名一个列
            使用 CHANGE old_column new_column dataType子句重命名列。语法格式如下：
            ALTER TABLE 表名 CHANGE 【column】 列名 新列名 新数据类型;
        4) 删除一个列
           删除表中某个字段的语法格式如下：
            ALTER TABLE 表名 DROP 【COLUMN】字段名
        5) 更改表名
            * 方式一：使用RENAME
                RENAME TABLE emp
                TO myemp;
            * 方式二：
                ALTER table dept
                RENAME [TO] detail_dept; -- [TO]可以省略
            * 必须是对象的拥有者
    5. 删除表
        * 在MySQL中，当一张数据表 没有与其他任何数据表形成关联关系 时，可以将当前数据表直接删除。
        * 数据和结构都被删除
        * 所有正在运行的相关事务被提交
        * 所有相关索引被删除
        * 语法格式：
            DROP TABLE [IF EXISTS] 数据表1 [, 数据表2, …, 数据表n];
            IF EXISTS 的含义为：如果当前数据库中存在相应的数据表，则删除数据表；
            如果当前数据库中不存 在相应的数据表，则忽略删除语句，不再执行删除数据表的操作。
    6. 清空表
        TRUNCATE TABLE语句：
            * 删除表中所有的数据
            * 释放表的存储空间
            注:TRUNCATE语句不能回滚，而使用 DELETE 语句删除数据，可以回滚
               



     */
}
