public class Related {
    public static void main(String[] args) {

    }
    /*
    相关子查询
        我们按内查询是否被执行多次，将子查询划分为 相关(或关联)子查询 和不相关(或非关联)子查询。

        子查询从数据表中查询了数据结果，如果这个 *数据结果只执行一次*
        然后这个数据结果作为主查询的条件进行执行，那么这样的子查询叫做不相关子查询。

        同样，如果子查询需要执行多次，即采用循环的方式，先从外部查询开始，每次都传入子查询进行查询
        然后再将结果反馈给外部，这种嵌套的执行方式就称为相关子查询。
    相关子查询执行流程
        如果子查询的执行依赖于外部查询，通常情况下都是因为 *子查询中的表用到了外部的表* ，并进行了条件关联
        因此每执行一次外部查询，子查询都要重新计算一次，这样的子查询就称之为 关联子查询

        相关子查询按照一行接一行的顺序执行，主查询的每一行都执行一次子查询

        题目: 查询员工中工资大于本部门平均工资的员工的last_name,salary和其department_id
        方式1：使用子查询
        SELECT last_name, salary, department_id
        FROM employees e1
        WHERE salary > (
                            SELECT department_id,AVG(salary)
                            FROM employees
                            WHERE department_id = e1.'department_id'
                        );
        方式2：再FROM中声明子查询(多表查询)
        SELECT e.last_name,e.salary,e.department_id
        FROM employees e,(
                            SELECT department_id,AVG(salary) avg_sal
                            FROM employees
                            GROUP BY department_id) t_avg_sal
        WHERE e.department_id = t_avg_sal
        AND e.salary > t_avg_sal.avg_sal
    在ORDER BY 中使用子查询:
        查询员工的id,salary,按照department _name 排序
        SELECT e.employees_id,e.salary
        FROM employees e
        ORDER BY (
                    SELECT department_name
                    FROM departments
                    WHERE e.department_id = d.department_id
                 ) ASC;
    结论：在SELECT中,除了GROUP BY 和LIMIT之外,剩下的都可以声明子查询
        SELECT ..., ..., ...(存在聚合函数)
        FROM ... (LEFT/RIGHT) JOIN ... ON 多表的连接条件
        (LEFT/RIGHT) JOIN ... ON
        WHERE 不包含聚合函数的过滤条件
        GROUP BY ..., ...,
        HAVING 包含聚合函数的过滤条件
        ORDER BY ..., ...,(ASC/DESC)
        LIMIT ..., ...

        HAVING 包含聚合函数的过滤条件
        ORDER BY ..., ...,(ASC/DESC)
        LIMIT ..., ...;

    题目:若employees表中employee id与job history表中employee id相同的数目不小于2,
        输出这些相同id的员工的employee_id,last_name和其job_id
        SELECT employee_id, last_name, job_id
        FROM employees e
        WHERE 2 <= (
                    SELECT COUNT(*)
                    FROM job_history j
                    WHERE e.'department_id' = j.'employee_id'
                   );
         WHERE 2 <= (
                    SELECT COUNT(*)
                    FROM job_history j
                    WHERE e.'department_id' = j.'employee_id'
                   );
                    WHERE 2 <= (
                    SELECT COUNT(*)
                    FROM job_history j
                    WHERE e.'department_id' = j.'employee_id'
                   );
                   WHERE 2 <= (
                    SELECT COUNT(*)
                    FROM job_history j
                    WHERE e.'department_id' = j.'employee_id'
                   );
    EXISTS 与 NOT EXISTS关键字
        关联子查询通常也会和 EXISTS操作符一起来使用，用来检查在子查询中是否存在满足条件的行。
            如果在子查询中不存在满足条件的行：
                条件返回 FALSE
                继续在子查询中查找
            如果在子查询中存在满足条件的行：
                不在子查询中继续查找
                条件返回 TRUE
            NOT EXISTS关键字表示如果不存在某种条件，则返回TRUE，否则返回FALSE。

        题目：查询公司管理者的employee_id，last_name，job_id，department_id信息
            方式一：
            SELECT employee_id, last_name, job_id, department_id
            FROM employees e1
            WHERE EXISTS (
                            SELECT *
                            FROM employees e2
                            WHERE e2.manager_id =
                            e1.employee_id
                          );
            方式二：自连接
                SELECT DISTINCT e1.employee_id, e1.last_name, e1.job_id, e1.department_id
                FROM employees e1 JOIN employees e2
                WHERE e1.employee_id = e2.manager_id;

       题目：查询departments表中，不存在于employees表中的部门的department_id和department_name
            SELECT department_id, department_name
            FROM departments d
            WHERE NOT EXISTS ( SELECT 'X'
                               FROM employees
                               WHERE department_id = d.department_id
                              );
      相关更新
        UPDATE table1 alias1
        SET column = (
                      SELECT expression
                      FROM table2 alias2
                      WHERE alias1.column = alias2.column
                      );
      相关删除
        DELETE FROM table1 alias1
        WHERE column operator (
                                SELECT expression
                                FROM table2 alias2
                                WHERE alias1.column = alias2.column
                                );

        使用相关子查询依据一个表中的数据删除另一个表的数据。

        题目：删除表employees中，其与emp_history表皆有的数据

        DELETE FROM employees e
        WHERE employee_id in (
                              SELECT employee_id
                              FROM emp_history
                              WHERE employee_id = e.employee_id
                              );

        总结：
            题目中可以使用子查询，也可以使用自连接。一般情况建议使用自连接，因为在许多 DBMS 的处理过
            程中，对于自连接的处理速度要比子查询快得多。
            可以这样理解：子查询实际上是通过未知表进行查询后的条件判断，而自连接是通过已知的自身数据表
            进行条件判断，因此在大部分 DBMS 中都对自连接处理进行了优化。
     */
}
