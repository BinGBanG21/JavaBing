public class IUD {
    public static void main(String[] args) {

    }
    /*
    1. 插入数据
        1) 方式1：VALUES的方式添加
            情况1：为表的所有字段按默认顺序插入数据**
            INSERT INTO 表名
            VALUES (value1,value2,....);
            值列表中需要为表的每一个字段指定值，并且值的顺序必须和数据表中字段定义时的顺序相同。

            情况2: 指定字段名插入数据
            为表的指定字段插入数据，就是在INSERT语句中只向部分字段中插入值，而其他字段的值为表定义时的默认值
            在 INSERT 子句中随意列出列名，但是一旦列出，VALUES中要插入的value1,....value需要与 column1,...column列一一对应。
            如果类型不同，将无法插入，并且MySQL会产生错误。
            INSERT INTO departments(department_id, department_name)
            VALUES (80, 'IT');

            情况3：同时插入多条记录
            INSERT语句可以同时向数据表中插入多条记录，插入时指定多个值列表，每个值列表之间用逗号分隔 开，基本语法格式如下：
            INSERT INTO table_name
            VALUES
            (value1 [,value2, …, value]),
            (value1 [,value2, …, value]),
            ……
            (value1 [,value2, …, value]);
            或者
            INSERT INTO table_name(column1 [, column2, …, column])
            VALUES
            (value1 [,value2, …, value]),
            (value1 [,value2, …, value]),
            ……
            (value1 [,value2, …, value]);
            使用INSERT同时插入多条记录时，MySQL会返回一些在执行单行插入时没有的额外信息，这些信息的含 义如下：
            * Records：表明插入的记录条数。
            * Duplicates：表明插入时被忽略的记录，原因可能是这 些记录包含了重复的主键值。
            * Warnings：表明有问题的数据值，例如发生数据类型转换。
        2) 方式2：将查询结果插入到表中
            INSERT还可以将SELECT语句查询的结果插入到表中，此时不需要把每一条记录的值一个一个输入
            只需要使用一条INSERT语句和一条SELECT语句组成的组合语句即可快速地从一个或多个表中向一个表中插入多行
            INSET INTO 目标表名
            (tar_column1 [, tar_column2, ..., tar_column])
            SELECT
            (src_column1 [, src_column2, …, src_column])
            FROM 源表名
            [WHERE condition]
                * 在 INSERT 语句中加入子查询。
                * 不必书写 VALUES 子句。
                * 子查询中的值列表应与 INSERT 子句中的列名对应。
    2.更新数据
        使用 UPDATE 语句更新数据。语法如下：
        UPDATE table_name
        SET column1=value1, column2=value2, ..., column=value
        [WHERE condition]
            * 可以一次更新多条数据。
            * 如果需要回滚数据，需要保证在DML前，进行设置：SET AUTOCOMMIT = FALSE;
            * 使用 WHERE 子句指定需要更新的数据。
    3. 删除数据
        DELETE FROM table_name [WHERE <condition>];
        table_name指定要执行删除操作的表；“[WHERE ]”为可选参数，指定删除条件，如果没有WHERE子句，
        DELETE语句将删除表中的所有记录。




     */
}
