public class MultipleQuery {
    public static void main(String[] args) {

    }
    /*
        多表查询
            多表查询，也称为关联查询，指两个或更多个表一起完成查询操作。
            前提条件:这些一起查询的表之间是有关系的(一对一、一对多)，它们之间一定是有关联字段
            这个关联字段可能建立了外键，也可能没有建立外键。比如:员工表和部门表，这两个表依靠“部门编号”进行关联。

            #查询员工名为'Abel'的人在哪个城市工作?
            SELECT*
            FROM employees
            WHERE last_name = 'Abel' ;

            SELECT*
            FROM departments
            WHERE department_id = 80;

            SELECT *
            FROM locations
            WHERE location_id = 2500;
            弊端：交互次数太多

            #2多表的查询如何实现?
            出现了笛卡尔积的错误
            #错误的实现方式:每个员工都与每个部门匹配了一遍。
            笛卡尔积（或交叉连接)的理解
            笛卡尔乘积是一个数学运算。假设我有两个集合X和Y，那么×和Y的笛卡尔积就是X和Y的所有可能组合
            也就是第一个对象来自于X，第二个对象来自于Y的所有可能。组合的个数即为两个集合中元素个数的乘积数。

            原因:缺少了表和表的连接条件
            SELECT employee_id, department_name
            FROM employees,departments;#查询出2889条记录
            SELECT *
            FROM employees;#107条记录

            SELECT2889 / 107
            FROM DUAL;

            SELECT *
            FROM departments; #27条记录

            #错误的方式
            SELECT employee_id, department_name
            FROM employees CROSs JOIN departments;

            多表查询的正确方式：需要连接条件
            SELECT employee_id, department_name
            FROM employees, departments
            #两个表的连接条件
            WHERE employees.department_id = departments.department_id;

            #如果查询语句中出现了多个表中都存在的字段，则必须指明此字段所在的表。
            SELECT employee_id,department_name , employees.department_id
            FROM employees,departments
            WHERE employees. 'department_id' = departments.department_id;
            从sql优化的角度，建议多表查询时，每个字段前都指明其所在的表。

            #可以给表起别名，在SELECT和wHERE中使用表的别名。 起了别名必须用
            SELECT emp. employee_id, dept.department_name, emp. department_id
            FROM employees emp , departments dept
            WHERE emp.department_id = dept.department_id;

            #练习:查询员工的employee_id, last_name , department_name , city
            SELECT e.employee_id,e.last_name, d.department_name, l.city,e.department_id,1.location_id
            FROM employees e,departments d,locations l
            WHERE e.`department_id = d.`department_id`
            AND d.`location_id`= l.`location_id`;


     */
}
