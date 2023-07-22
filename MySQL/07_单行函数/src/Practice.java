public class Practice {
    public static void main(String[] args) {

    }
    /*
        #1.显示系统时间(注:日期+时间)
            SELECT NOW(),SYSDATE(),CURRENT_TIMESTAMP(),LOCALTIME(),LOCAL_TIMESTAMP()
            FORM DUAL;
        #2.查询员工号，姓名，工资，以及工资提高百分之20%后的结果(new salary)
            SELECT employees_id,last_name,salary,salary * 1.2 "new salary"
            FROM employees;
        #3.将员工的姓名按首字母排序，并写出姓名的长度(length)
            SELECT last_name,LENGTH(last_name)  "name_len"
            FROM employees
            ORDER BY last_name ASC;
        #4.查询员工id ,last_name , salary，并作为一个列输出，别名为OUT_PUT
            SELECT CONCAT(employees_id,','last_name,','salary) "OUT_PUT"
            FROM employees;
        #5.查询公司各员工工作的年数、工作的天数，并按工作年数的降序排序
            SELECT last_name, DATEDIFF(CURDATE(),hire_date)/ 365 "work_day",DATEDIFF(CURDATE(),hire_date) "work_years"
            FROM employees
            ORDER BY work_years DESC;
        #6.查询员工姓名，hire_date , department_id，满足以下条件:雇用时间在1997年之后，department_id 为80或90或110,commission_pct不为空

        #7.查询公司中入职超过10000天的员工姓名、入职时间

        #8.做一个查询，产生下面的结果
        <last_name> earns <salary> monthly but wants <salary*3>I

     */
}
