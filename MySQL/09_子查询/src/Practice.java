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
    */
}
