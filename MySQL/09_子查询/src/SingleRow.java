public class SingleRow {
    public static void main(String[] args) {

    }
    /*
    单行比较操作符
        > <  = >= <= !=
        子查询的编写技巧(或步骤) :1.从里往外写   2.从外往里写
        题目: 查询工资大于149号员工工资的员工的信息
        SELECT employees_id,last_name,salary
        FROM employees
        WHERE salary > (
                        SELECT employees_id,last_name,salary
                        FROM employees
                        WHERE employees_id = 149
                        );
        题目：返回job id与141号员工相同，salary比143号员工多的 员工姓名，job id和工资
        SELECT last_name, job_id,salary
        FROM employees
        WHERE job_id = (
                        SELECT last_name, job_id,salary
                        FROM employees
                        WHERE employees_id = 141
                        )
        AND salary > (
                       SELECT salary
                       FROM employees
                       WHERE employees_id = 143
                     );
        题目: 返回公司工资最少的员工的last name,job id和salary
        SELECT last_name, job_id,salary
        FROM employees
        WHERE salary = (
                        SELECT MIN(salary)
                        FROM employees;
                        );

        题目: 查询与141号或174号员工的manager_id和department_id相同的其他员工
             的employee_id，manager_id, department_id
        SELECT employee_id,manager_id,department_id
        FROM employees
        WHERE manager_id = (
                            SELECT manager_id
                            FROM employees
                            WHERE employee_id IN (141,174)
                            )
        OR department_id = (
                            SELECT department_id
                            FROM employees
                            WHERE employee_id IN (141,174)
                            );
        AND employee_id != 141;

        题目：查询最低工资大于50号部门最低工资的部门id和其最低工资
        SELECT department_id,MIN(salary)
        FROM employees
        WHERE department_id IS NOT NULL
        GROUP BY department_id
        HAVING MIN(salary) > (
                                SELECT MIN(salary)
                                FROM employees
                                WHERE department_id = 50
                            );
        题目:显式员工的employee id,last name和location。
        其中，若员工department id与location id为1800的department id相同
        则location为'canada'，其余则为'USA'
        SELECT employee_id,last_name,CASE department_id WHEN(SELECT department_id FROM employees WHERE location = 1800) THEN 'Canada'
                                                               ELSE 'UST' "location"
        FROM employees;


        子查询中的空值问题

        非法使用子查询
        =属于单行比较操作符 后面子查询的结果为多个 所以报错(Subquery returns more than 1 row)
        SELECT employee id, last name
        FROM employees
        WHERE salary =(
                        SElECT MIN(salary)
                        FROM employees
                        GROUP BY department id);


     */
}
