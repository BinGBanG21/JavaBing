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
        WHERE job_id = (
        SELECT job_id
       SELECT job_idSELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_idSELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
       SELECT job_id
        )
     */
}
