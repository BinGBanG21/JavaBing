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
     */
}
