public class Practice {
    public static void main(String[] args) {

    }
    /*
    1.查询员工12个月的工资总和，并起别名为ANNUAL SAlARY
        //因为返回的是一个表 所以加上名字id好区分一点 然后commission避免null
        SELECT employees_id, last_name, salary * (1 + IFNUll(commission_cpt, 0)) * 12 "ANNUAL SALARY"
        FROM employees;
    2.查询employees表中去除重复的job_id以后的数据
        SELECT DISTINCT job_id
        FROM employees;
    3.查询工资大于12000的员工姓名和工资
        SELECT last_name
        FROM employees
        WHERE salary > 12000;
    4.查询员工号为176的员工的姓名和部门号
        SELECT last_name, department_id
        FROM employees
        WHERE employees_id = 176;
    5.显示表departments 的结构，并查询其中的全部数据
        DESC departments;
        SELECT *
        FROM departments;
 */
}
