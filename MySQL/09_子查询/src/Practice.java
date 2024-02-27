public class Practice {
    public static void main(String[] args) {

    }
    /*
     1.查询和 Zlotkey 相同部门的员工姓名和工资
        SELECT last_name, salary
        FROM employees
        WHERE department_id = (
            SELECT department_id
            FROM employees
            WHERE last_name = 'Zlotkey'
        );
    2.查询工资比公司平均工资高的员工的员工号，姓名和工资。
        SELECT employee_id, last_name, salary
        FROM employees
        WHERE salary > (
            SELECT AVG(salary)
            FROM employee
        );
    3.选择工资大于所有JOB_ID = 'SA_MAN' 的员工的工资的员工的last_name, job_id, salary
        SELECT last_name, job_id, salary
        FROM employees
        WHERE salary > ALL (
            SELECT salary
            FROM employees
            WHERE job_id = 'SA_MAN'
        );
    4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id IN (
            SELECT DISTINCT department_id
            FROM employees
            WHERE last_name LIKE '%u%'
        );
    5.查询在部门的location_id为1700的部门工作的员工的员工号
        SELECT employee_id
        FROM employees
        WHERE department_id IN (
            SELECT department_id
            FROM departments
            WHERE location_id = 1700
        );
    6.查询管理者是King的员工姓名和工资
        SELECT last_name, salary
        FROM employees
        WHERE manage_id IN (
            SELECT employee_id
            FROM employees
            WHERE last_name = 'King'
        );
    7.查询工资最低的员工信息 (last_name, salary)
        SELECT last_name, salary
        FROM employees
        WHERE salary = (
            SELECT MIN(salary)
            FROM employees
        );
    8.查询平均工资最低的部门信息
        # 方式一
            SELECT *
            FROM departments
            WHERE department_id = (
                SELECT department_id
                FROM employees
                GROUP BY department_id
                HAVING AVG(salary) = (
                    SELECT MIN(avg_sal)
                    FROM (
                        SELECT AVG(salary) avg_sal
                        FROM employees
                        GROUP BY department_id
                    ) t_dept_avg_sal
                )
            );

        # 方式二
        SELECT *
        FROM departments
        WHERE department_id = (
            SELECT department_id
            FROM employees
            GROUP BY department_id
            HAVING AVG(salary) <= ALL (
                SELECT AVG(salary) avg_sal
                FROM employees
                GROUP BY department_id
            )
        );

        # 方式三: LIMIT
        SELECT *
        FROM departments
        WHERE department_id IN (
            SELECT department_id
            FROM employees
            GROUP BY department_id
            HAVING AVG(salary) = (
                SELECT AVG(salary) avg_sal
                FROM employees
                GROUP BY department_id
                ORDER BY avg_sal ASC
                LIMIT 1
            )
        );

        # 方式四
        SELECT d.*
        FROM departments d, (
            SELECT department_id, AVG(salary) avg_sal
            FROM employees
            GROUP BY department_id
            ORDER BY avg_sal ASC
            LIMIT 0,1
        ) t_dept_avg_sal
        WHERE d.`department_id` = t_dept_avg_sal.`department_id`;

    9.查询平均工资最低的部门信息和该部门的平均工资 (相关子查询)
        SELECT d.*, (SELECT AVG(salary) FROM employees WHERE department_id = d.`department_id`) avg_sal
        FROM departments d, (
            SELECT department_id, AVG(salary) avg_sal
            FROM employees
            GROUP BY department_id
            ORDER BY avg_sal ASC
            LIMIT 0,1
        ) t_dept_avg_sal
        WHERE d.`department_id` = t_dept_avg_sal.`department_id`;
    10.查询平均工资最高的job信息
        SELECT *
        FROM jobs
        WHERE job_id = (
            SELECT job_id
            FROM employees
            GROUP BY job_id
            HAVING AVG(salary) = (
                SELECT MAX(avg_sal)
                FROM (
                    SELECT AVG(salary) avg_sal
                    FROM employees
                    GROUP BY job_id
                ) t_job_avg_sal
            )
        );
    11.查询平均工资高于公司平均工资的部门有哪些？
        SELECT department_id
        FROM employees
        WHERE department_id IS NOT NULL
        GROUP BY department_id
        HAVING AVG(salary) > (
            SELECT AVG(salary)
            FROM employees
        );
    12.查询出公司中所有manager的详细信息
        # 方式1：自连接
            SELECT DISTINCT *
            FROM employees emp, employees manager
            WHERE emp.`manager_id` = manager.`employee_id`;

            SELECT DISTINCT *
            FROM employees emp JOIN employees manager
            ON emp.`manager_id` = manager.`employee_id`;

        # 方式2：子查询
            SELECT *
            FROM employees
            WHERE employee_id IN (
                SELECT manager_id
                FROM employees
            );

        # 方式3：EXISTS
            SELECT *
            FROM employees manager
            WHERE EXISTS (
                SELECT *
                FROM employees emp
                WHERE manager.`employee_id` = emp.`manager_id`
            );
    13.各个部门中，最高工资中最低的那个部门的最低工资是多少？
        # 方式一：
            SELECT MIN(salary)
            FROM employees
            WHERE department_id = (
                SELECT department_id
                FROM employees
                GROUP BY department_id
                HAVING MAX(salary) = (
                    SELECT MIN(max_sal)
                    FROM (
                        SELECT MAX(salary) max_sal
                        FROM employees
                        GROUP BY department_id
                    ) t_dept_max_sal
                )
            );

        # 方式二：
            SELECT MIN(salary)
            FROM employees
            WHERE department_id = (
                SELECT department_id
                FROM employees
                GROUP BY department_id
                HAVING MAX(salary) <= ALL (
                    SELECT MAX(salary)
                    FROM employees
                    GROUP BY department_id
                )
            );

        # 方式三：
            SELECT MIN(salary)
            FROM employees
            WHERE department_id = (
                SELECT department_id
                FROM employees
                GROUP BY department_id
                HAVING MAX(salary) = (
                    SELECT MAX(salary) max_sal
                    FROM employees
                    GROUP BY department_id
                    ORDER BY max_sal ASC
                    LIMIT 0,1
                )
            );

        # 方式四：
            FROM employees e, (
                SELECT department_id, MAX(salary) max_sal
                FROM employees
                GROUP BY department_id
                ORDER BY max_sal ASC
                LIMIT 0,1
            ) t_dept_max_sal
            WHERE e.`department_id` = t_dept_max_sal.`department_id`;




    */
}
