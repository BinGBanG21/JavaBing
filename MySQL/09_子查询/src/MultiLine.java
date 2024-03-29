public class MultiLine {
    public static void main(String[] args) {

    }
    /*
    多行子查询
        也称为集合比较子查询
        内查询返回多行
        使用多行比较操作符
    多行比较操作符
        IN              等于列表中的任意一个
        ANY             需要和单行比较操作符一起使用，和子查询返回的某一个值比较
        ALL             需要和单行比较操作符一起使用，和子查询返回的所有值比较
        SOME            实际上是ANY的别名，作用相同，一般常使用ANY

    举例
        IN
        SELECT employee id, last name
        FROM employees
        WHERE salary IN (
                        SELECT MIN(salary)
                        FROM employees
                        GROUP BY department_id
                        );
        ANY / ALL
        题目: 返回其它job_id中比job id为'IT_PROG'部门任一工资低的员工的员工号、姓名、job id 以及salary
        SELECT employee_id,last_name,job_id,salary
        FROM employees
        WHERE job_id <> 'IT_PROG'
        AND salary < ANY (
                        SELECT salary
                        FROM employees
                        WHERE job_id = 'IT_PROG'
        );
        #查询平均工资最低的部门id
        MySql中聚合函数不能嵌套使用
        思路:把查询结果看成一张表 注意表一定要有别名
        首先查询各个部门的平均工资 然后找出最低 最后使用HAVING筛选出聚合函数的结果
        方式1:
        SELECT department_id
        FROM employees
        GROUP BY department_id
        HAVING AVG(salary) = (
                                SELECT MIN(avg_sal)
                                FROM(
                                    SELECT AVG(salary)
                                    FROM employees
                                    GROUP BY department_id
                                ) t_dep_avg_sal
                            );
        方式2:ALL关键字
        SELECT department_id
        FROM employees
        GROUP BY department_id
        HAVING AVG(salary) <= ALL (
                                    SELECT AVG(salary)
                                    FROM employees
                                    GROUP BY department_id
    空值问题(注意内查询中有null值的情况)
        SELECT last_name
        FROM employees
        WHERE employee_id NOT IN (
                                    SELECT manager_id
                                    FROM employees
                                 )

     */
}
