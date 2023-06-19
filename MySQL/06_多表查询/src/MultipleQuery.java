public class MultipleQuery {
    public static void main(String[] args) {

    }
    /*
        多表查询
            多表查询，也称为关联查询，指两个或更多个表一起完成查询操作。
            前提条件:这些一起查询的表之间是有关系的(一对一、一对多)，它们之间一定是有关联字段
            这个关联字段可能建立了外键，也可能没有建立外键。比如:员工表和部门表，这两个表依靠“部门编号”进行关联。

            #查询员工名为'Abel'的人在哪个城市工作?
            SELECT*
            FROM employees
            WHERE last_name = 'Abel' ;

            SELECT*
            FROM departments
            WHERE department_id = 80;

            SELECT *
            FROM locations
            WHERE location_id = 2500;
            弊端：交互次数太多

            #2多表的查询如何实现?
            出现了笛卡尔积的错误
            #错误的实现方式:每个员工都与每个部门匹配了一遍。
            笛卡尔积（或交叉连接)的理解
            笛卡尔乘积是一个数学运算。假设我有两个集合X和Y，那么×和Y的笛卡尔积就是X和Y的所有可能组合
            也就是第一个对象来自于X，第二个对象来自于Y的所有可能。组合的个数即为两个集合中元素个数的乘积数。

            原因:缺少了表和表的连接条件
            SELECT employee_id, department_name
            FROM employees,departments;#查询出2889条记录
            SELECT *
            FROM employees;#107条记录

            SELECT2889 / 107
            FROM DUAL;

            SELECT *
            FROM departments; #27条记录

            #错误的方式
            SELECT employee_id, department_name
            FROM employees CROSs JOIN departments;

            多表查询的正确方式：需要连接条件
            SELECT employee_id, department_name
            FROM employees, departments
            #两个表的连接条件
            WHERE employees.department_id = departments.department_id;

            #如果查询语句中出现了多个表中都存在的字段，则必须指明此字段所在的表。
            SELECT employee_id,department_name , employees.department_id
            FROM employees,departments
            WHERE employees. 'department_id' = departments.department_id;
            从sql优化的角度，建议多表查询时，每个字段前都指明其所在的表。

            #可以给表起别名，在SELECT和wHERE中使用表的别名。 起了别名必须用
            SELECT emp. employee_id, dept.department_name, emp. department_id
            FROM employees emp , departments dept
            WHERE emp.department_id = dept.department_id;

            #练习:查询员工的employee_id, last_name , department_name , city
            SELECT e.employee_id,e.last_name, d.department_name, l.city,e.department_id,1.location_id
            FROM employees e,departments d,locations l
            WHERE e.`department_id = d.`department_id`
            AND d.`location_id`= l.`location_id`;
            结论:如果有n个表实现多表的查询，则需要至少n-1个连接条件
        多表查询的分类
            角度1:等值连接vs非等值连接
                #非等值连接的例子:
                SELECT*
                FROM job_grades;
                SELECT e.last_name,e.salary,j.grade_level
                FROM employees e,job_grades j

            角度2:自连接vs非自连接
                #where e. 'salary`between j. 'lowest sal` and j.`highest sal`;
                WHERE e. 'salary` >= j. 'lowest_sal’AND e. 'salary ' <= j. highest_sal ;
                #自连接vs非自连接例子
                SELECT * FROM employees;
                #练习:查询员工id,员工姓名及其管理者的id和姓名
                SELECT emp.employee_id, emp.last_name , mgr.employee_id,mgr.last_name
                FROM employees emp ,employees mgr
                WHERE emp.`manager_id` = mgr.`employee_id`;

            角度3:内连接vs外连接(类似交集并集)
                内连接:合并具有同一列的两个以上的表的行，结果集中不包含一个表与另一个表不匹配的行
                外连接:合并具有同一列的两个以上的表的行，结果集中除了包含一个表与另一个表匹配的行之外，还查询到了左表或右表中不匹配的行。
                外连接分类：左外连接 右外连接 满外连接
                如果是左外连接，则连接条件中左边的表也称为主表，右边的表称为从表。
                如果是右外连接，则连接条件中右边的表也称为主表，左边的表称为从表。

                练习:查询所有的员工的last_name , department_name信息
                #SQL92语法实现外连接:使用 +  -—- MySQL不支持sQL92语法中外连接的写法!
                SELECT employee_id, department_name
                FROM employees e, departments d
                WHERE e.department_id = d.department_id(+);

                #SQL99语法中使用JOIN ...ON的方式实现多表的查询。这种方式也能解决外连接的问题。MySQL是支持此种方式的
                SELECT employee_id, department_name
                FROM employees e (INNER)JOIN departments d
                ON e.department_id = d.department_id(+);

                SELECT last_name , department_name , city
                FROM employees e JOIN departments d
                ON e.`department_id` = d. `department_id`
                JOIN locations l
                ON d.`location_id =l.`location_id`;

                #SQL99语法实现左外连接
                SELECT employee_id, department_name
                FROM employees e LEFT (OUTER) JOIN departments d
                ON e.department_id = d.department_id(+);
                #SQL99语法实现右外连接

                #满外连接 MySQL不支持 FULL
                SELECT employee_id, department_name
                FROM employees e FULL OUTER JOIN departments d
                ON e.department_id = d.department_id(+);

            UNION的使用
                合并查询结果
                利用UNION关键字，可以给出多条SELECT语句，并将它们的结果组合成单个结果集。
                合并时，两个表对应的列数和数据类型必须相同，并且相互对应。
                各个SELECT语句之间使用UNION或UNION ALL关键字分隔。
                语法格式:
                SELECT column , . ..
                FROM table1
                UNION [ALL]
                SELECT column , . . .
                FROM table2
                UNION操作符返回两个查询的结果集的并集，去除重复记录。
            UNION ALL操作符
                UNION ALL操作符返回两个查询的结果集的并集。对于两个结果集的重复部分，不去重。
                UNION ALL相比于UNION效率更高
            7中JOIN的实现
                内连接
                SELECT employees_id,department_name
                FROM employees e JOIN department d
                ON e.department_id = d.department_id;
                左外连接
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                右外连接
                SELECT employees_id,department_name
                FROM employees e RIGHT JOIN department d
                ON e.department_id = d.department_id;
                左外连接-相同的部分（即-使用WHERE）
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                WHERE d.department_id IS NULL;
                右外连接-相同的部分（即-使用WHERE）
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                WHERE e.department_id IS NULL;
                满外连接-方式1（左外连接+右外连接(去重重复的)）
                SELECT employees_id,department_name
                FROM employees e JOIN department d
                ON e.department_id = d.department_id;
                UNION ALL
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                WHERE e.department_id IS NULL;
                满外连接-方式2（右外连接+左外连接(去重重复的)）
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                WHERE e.department_id IS NULL;
                UNION ALL
                SELECT employees_id,department_name
                FROM employees e JOIN department d
                ON e.department_id = d.department_id;
                满外连接-去重
                左外连接去重+右外连接去重
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                WHERE e.department_id IS NULL;
                UNION ALL
                SELECT employees_id,department_name
                FROM employees e LEFT JOIN department d
                ON e.department_id = d.department_id;
                WHERE d.department_id IS NULL;
     */
}
