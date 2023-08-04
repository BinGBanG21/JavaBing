public class SubQuery {
    public static void main(String[] args) {

    }
    /*
    子查询
        指一个查询语句嵌套在另一个查询语句内部的查询
        需求：谁的工资比Abel的高
        方式1：
            SELECT last_name
            FROM employees
            WHERE last_name = 'Abel';

            SELECT last_name
            FROM employees
            WHERE salary > 11000;
        方式2：自连接(其中一个表只有一个值 然后进行不等值连接)
            SELECT e2.last_name,e2.salary
            FROM employees e1 JOIN employees e2
            ON e1.employees_id = e2.employees_id
            WHERE e1.last_name = 'Abel'
            AND e2.salary > e1.salary;
       方式3：子查询
            SELECT last_name,salary
            FROM employees
            WHERE salary > (
                            SELECT last_name
                            FROM employees
                            WHERE last_name = 'Abel'
                            );
    规范的称谓：外查询(主查询)、内查询(子查询)
        子查询(内查询)在主查询之前一次执行完成
        子查询的结果被主查询（外查询)使用
            注意事项
                子查询要包含在括号内
                将子查询放在比较条件的右侧
                单行操作符对应单行子查询，多行操作符对应多行子查询
    子查询的分类
        分类方式1:
            单行子查询多行子查询我们按内查询的结果返回一条还是多条记录，将子查询分为单行子查询、多行子查询。
        分类方式2:
            我们按内查询是否被执行步次，将子查询划分为相关(或关联、子查询会变)子查询和不相关(或非关联)子查询。
            举例：
                相关子查询的需求:查询工资大于本部门平均工资的员工信息。
                不相关子查询的需求:查询工资大于本公司平均工资的员工信息。
        子查询从数据表中查询了数据结果，如果这个数据结果只执行一次，然后这个数据结果作为主查询的条件进行执行，那么这样的子查询叫做不相关子查询。
        同样，如果子查询需要执行多次，即采用循环的方式，先从外部查询开始，每次都传入子查询进行查询，然后再将结果反馈给外部，这种嵌套的执行方式就称为相关子查询。


     */

}
