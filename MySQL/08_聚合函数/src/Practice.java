public class Practice {
    public static void main(String[] args) {

    }
    /*
    1.where子句可否使用组函数进行过滤?
        不可以
    2.查询公司员工工资的最大值，最小值，平均值，总和
        SELECT MAX(salary) max_sal, MIN(salary) min_sal,AVG(salary) avg_sal,SUM(salary) sum_sal
        FROM employees;
    3.查询各job_id的员工工资的最大值，最小值，平均值，总和
        SELECT job_id,MAX(salary) max_sal, MIN(salary) min_sal,AVG(salary) avg_sal,SUM(salary) sum_sal
        FROM employees
        GROUP BY job_id;
    4.选择具有各个job_id的员工人数
        SELECT job_id,COUNT(1)
        FROM employees;
        GROUP BY job_id;
    5.查询员工最高工资和最低工资的差距(DIFFERENCE）
        SELECT MAX(salary) - MIN(salary) "DIFFERENCE"
        FROM employees;
    6.查询各个管理者手下员工的最低工资，其中最低工资不能低于6000，没有管理者的员工不计算在内
        SELECT manager_id,MIN(salary)
        FROM employees
        WHERE manager_id IS NOT NULL
        GROUP BY manager_id;
        HAVING MIN(salary) >= 6000;
    7.查询所有部门的名字，location_id，员工数量和平均工资，并按平均工资降序
        SELECT department_id,location_id,COUNT(employees_id),AVG(salary)
        FORM departments d JOIN employees e
        ON d.department_id = e.department_id
        GROUP BY department_id,location_id;
    8.杳询每个工种、每个部门的部门名、工种名和最低工资
        SELECT department_name,job_id,MIN(salary)
        FROM employees e RIGHT JOIN department d
        ON e.department_id = d.department_id
        ORDER BY department_id,job_id;




     */
}
