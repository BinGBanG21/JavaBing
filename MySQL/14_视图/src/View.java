public class View {
    public static void main(String[] args) {

    }
    /*
    1. 常见的数据库对象
        | 对象                 | 描述                                                         |
        | -------------------- | ------------------------------------------------------------ |
        | 表(TABLE)            | 表是存储数据的逻辑单元，以行和列的形式存在，列就是字段，行就是记录 |
        | 数据字典             | 就是系统表，存放数据库相关信息的表。系统表的数据通常由数据库系统维护， 程序员通常不应该修改，只可查看 |
        | 约束 (CONSTRAINT)    | 执行数据校验的规则，用于保证数据完整性的规则                 |
        | 视图(VIEW)           | 一个或者多个数据表里的数据的逻辑显示，视图并不存储数据       |
        | 索引(INDEX)          | 用于提高查询性能，相当于书的目录                             |
        | 存储过程 (PROCEDURE) | 用于完成一次完整的业务处理，没有返回值，但可通过传出参数将多个值传给调 用环境 |
        | 存储函数 (FUNCTION)  | 用于完成一次特定的计算，具有一个返回值                       |
        | 触发器 (TRIGGER)     | 相当于一个事件监听器，当数据库发生特定事件后，触发器被触发，完成相应的处理 |
    2. 视图概述
        * 视图是一种 虚拟表 ，本身是 不具有数据 的，占用很少的内存空间，它是 SQL 中的一个重要概念。
        * 视图建立在已有表的基础上, 视图赖以建立的这些表称为基表。
        * 视图的创建和删除只影响视图本身，不影响对应的基表。但是当对视图中的数据进行增加、删除和 修改操作时，数据表中的数据会相应地发生变化，反之亦然。
        * 视图提供数据内容的语句为 SELECT 语句, 可以将视图理解为存储起来的 SELECT 语句
        * 在数据库中，视图不会保存数据，数据真正保存在数据表中。当对视图中的数据进行增加、删 除和修改操作时，数据表中的数据会相应地发生变化；反之亦然。
        * 视图，是向用户提供基表数据的另一种表现形式。通常情况下，小型项目的数据库可以不使用视 图，但是在大型项目中，以及数据表比较复杂的情况下，视图的价值就凸显出来了，它可以帮助我 们把经常查询的结果集放到虚拟表中，提升使用效率。理解和使用起来都非常方便。
    3. 创建视图
        *在 CREATE VIEW 语句中嵌入子查询
            CREATE [OR REPLACE]
            [ALGORITHM = {UNDEFINED | MERGE | TEMPTABLE}]
            VIEW 视图名称 [(字段列表)]
            AS 查询语句
            [WITH [CASCADED|LOCAL] CHECK OPTION]
        *精简版
            CREATE VIEW 视图名称
            AS 查询语句
         1) 创建单表视图
                # 方式一：
                CREATE VIEW empvu80
                AS
                SELECT employee_id, last_name, salary
                FROM employees
                WHERE department_id = 80;

                # 方式二：
                CREATE VIEW empsalary8000(emp_id, NAME, monthly_sal) # 小括号内字段个数与SELECT中字段个数相同
                AS
                SELECT employee_id, last_name, salary
                FROM employees
                WHERE salary > 8000;
        2) 创建多表联合视图
            CREATE VIEW empview
            AS
            SELECT employee_id emp_id,last_name NAME,department_name
            FROM employees e,departments d
            WHERE e.department_id = d.department_id;

            CREATE VIEW dept_sum_vu
            (name, minsal, maxsal, avgsal)
            AS
            SELECT d.department_name, MIN(e.salary), MAX(e.salary),AVG(e.salary)
            FROM employees e, departments d
            WHERE e.department_id = d.department_id
            GROUP BY d.department_name;
            利用视图对数据进行格式化
                常需要输出某个格式的内容，比如我们想输出员工姓名和对应的部门名，
                对应格式为 emp_name(department_name)，就可以使用视图来完成数据格式化的操作：

                CREATE VIEW emp_depart
                AS
                SELECT CONCAT(last_name,'(',department_name,')') AS emp_dept
                FROM employees e JOIN departments d
                WHERE e.department_id = d.department_id;
        3) 基于视图创建视图
            当我们创建好一张视图之后，还可以在它的基础上继续创建视图。
            CREATE VIEW emp_dept_ysalary
            AS
            SELECT emp_dept.ename,dname,year_salary
            FROM emp_dept INNER JOIN emp_year_salary
            ON emp_dept.ename = emp_year_salary.ename;
    4. 查看视图
        语法1：查看数据库的表对象、视图对象
        SHOW TABLES;
        语法2：查看视图的结构
        DESC / DESCRIBE 视图名称;
        语法3：查看视图的属性信息
        # 查看视图信息（显示数据表的存储引擎、版本、数据行数和数据大小等）
        SHOW TABLE STATUS LIKE '视图名称'\G
    5. 更新视图的数据
        1) 一般情况
            MySQL支持使用INSERT、UPDATE和DELETE语句对视图中的数据进行插入、更新和删除操作。当视图中的 数据发生变化时，数据表中的数据也会发生变化，反之亦然。
        2) 不可更新的视图
            要使视图可更新，视图中的行和底层基本表中的行之间必须存在 一对一 的关系。另外当视图定义出现如下情况时，视图不支持更新操作：
            * 在定义视图的时候指定了“ALGORITHM = TEMPTABLE”，视图将不支持INSERT和DELETE操作；
            * 视图中不包含基表中所有被定义为非空又未指定默认值的列，视图将不支持INSERT操作；
            * 在定义视图的SELECT语句中使用了 JOIN联合查询 ，视图将不支持INSERT和DELETE操作；
            * 在定义视图的SELECT语句后的字段列表中使用了 数学表达式 或 子查询 ，视图将不支持INSERT，也 不支持UPDATE使用了数学表达式、子查询的字段值；
            * 在定义视图的SELECT语句后的字段列表中使用 DISTINCT 、 聚合函数 、 GROUP BY 、 HAVING 、 UNION 等，视图将不支持INSERT、UPDATE、DELETE；
            * 在定义视图的SELECT语句中包含了子查询，而子查询中引用了FROM后面的表，视图将不支持 INSERT、UPDATE、DELETE；
            * 视图定义基于一个 不可更新视图 ； 常量视图。
    6. 修改、删除视图
        1) 修改视图
            方式1：使用CREATE OR REPLACE VIEW 子句修改视图
            CREATE OR REPLACE VIEW empvu80
            (id_number, name, sal, department_id)
            AS
            SELECT employee_id, first_name || ' ' || last_name, salary, department_id
            FROM employees
            WHERE department_id = 80;
            方式2：ALTER VIEW
                ALTER VIEW 视图名称
                AS
                查询语句
        2) 删除视图
            删除视图只是删除视图的定义，并不会删除基表的数据。
            删除视图的语法是：
                DROP VIEW IF EXISTS 视图名称;
    7. 总结
        1) 优点
            1. 操作简单
            将经常使用的查询操作定义为视图，可以使开发人员不需要关心视图对应的数据表的结构、表与表之间的关联关系，
            也不需要关心数据表之间的业务逻辑和查询条件，而只需要简单地操作视图即可，极大简化了开发人员对数据库的操作。
            2. 减少数据冗余
            视图跟实际数据表不一样，它存储的是查询语句。所以，在使用的时候，我们要通过定义视图的查询语 句来获取结果集。
            而视图本身不存储数据，不占用数据存储的资源，减少了数据冗余。
            3. 数据安全
            MySQL将用户对数据的 访问限制 在某些数据的结果集上，而这些数据的结果集可以使用视图来实现。
            用户不必直接查询或操作数据表。这也可以理解为视图具有隔离性 。视图相当于在用户和实际的数据表之间加了一层虚拟表。
            同时，MySQL可以根据权限将用户对数据的访问限制在某些视图上，用户不需要查询数据表，可以直接通过视图获取数据表中的信息。这在一定程度上保障了数据表中数据的安全性。
            4. 适应灵活多变的需求
            当业务系统的需求发生变化后，如果需要改动数据表的结构，则工作量相对较 大，可以使用视图来减少改动的工作量。这种方式在实际工作中使用得比较多。
            5. 能够分解复杂的查询逻辑
            数据库中如果存在复杂的查询逻辑，则可以将问题进行分解，创建多个视图 获取数据，再将创建的多个视图结合起来，完成复杂的查询逻辑。
        2) 不足
            如果我们在实际数据表的基础上创建了视图，那么，如果实际数据表的结构变更了，我们就需要及时对相关的视图进行相应的维护。
            特别是嵌套的视图（就是在视图的基础上创建视图），维护会变得比较复杂， 可读性不好 ，容易变成系统的潜在隐患。因为创建视图的 SQL 查询可能会对字段重命名，也可能包含复杂的逻辑，这些都会增加维护的成本。
            实际项目中，如果视图过多，会导致数据库维护成本的问题。



     */
}
