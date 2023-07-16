public class ProcessControl {
    public static void main(String[] args) {

    }
    /*
    流程控制函数
        流程处理函数可以根据不同的条件，执行不同的处理流程，可以在SQL语句中实现不同的条件选择。
        MySQL中的流程处理函数主要包括lF()、IFNULL()和CASE()函数。
        IF(value,value1,value2)                         如果value的值为TRUE，返回value1，否则返回value2
        IFNULL(value1, value2)                          如果value1不为NULL，返回value1，否则返回value2
        CASE WHEN条件1 THEN结果1 WHEN条件2                  相当于Java的if...else if...else...
        THEN结果2... [ELSEresultn] END
        CASE expr WHEN常量值1THEN值1                      相当于Java的switch...case...
        WHEN常量值1 THEN值1 ....[ELSE值n]END

        查询部门号为10,20，30的员工信息,
        若部门号为10,则打印其工资的1.1倍,
        20号部,则打印其工资的1.2倍,
        30号部门,打印其工资的1.3 倍数,
        其他部门,打印其工资的1.4 倍数

        SELECT employees_id, last_name,department_id,salary,
        CASE department_id WHEN 1O THEN salary * 1.1
                           WHEN 20 THEN salary * 1.2
                           WHEN 30 THEN salary * 1.3
                           ELSE salary * 1.4
                           END "details"
        FROM employees
        WHERE department_id IN (10,20,30);


     */
}
