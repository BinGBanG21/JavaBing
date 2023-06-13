public class SELECT {
    public static void main(String[] args) {

    }
    /*
    SELECT语句
        基本的SELECT语句:
            SELECT字段1,字段2,... FROM表名SELECT 1 +1,3 * 2;
            SELECT 1 + 1,3 * 2
            FROM DUAL; #dual:伪表
        表中的所有的字段(或列)
            SELECT * FROM employees;
            SELECT employee_id, last_name,salary
            FROM employees;
        列的别名
            重命名一个列
            便于计算
            紧跟列名，也可以在列名和别名之间加入关键字AS，别名使用双引号，以便在别名中包含空格或特殊的字符并区分大小写。
            AS可以省略
            建议别名简短，见名知意。
            举例:
            SELECT last_name AS name,commission_pct comm
            FROM employees;
            as:全称:alias（别名),可以省略
            列的别名可以使用一对"”引起来。
                SELECT employee_id emp_id,last _name AS lname , department_id "部门id" ,salary + 12 "annual sal"
                FROM employees;
            去除重复行
                默认情况下，查询会返回全部行，包括重复行。
                查询员工表中有哪些部门
                    //没去重
                    SELECT department_id
                    FROM employees;
                    //去重
                    SELECT DISTINCT department_id
                    FROM employees;
                    错误的:
                    SELECT salary,DISTINCT department_id
                    FROM employees;
                    仅仅是没有报错，但是没有实际意义。
                    SELECT DISTINCT department_id,salary
                    FROM employees; 总结：修饰限制的关键字一般都放在前面
            空值参与运算
                所有运算符或列值遇到null值，运算的结果都为null
                空值null不等同于0  可以理解成一个占位符 当时不知道多少
                在参与运算时 只要有null  结果就为null
                    SELECT employee_id , salary , commission_pct,
                    12 * salary * ( 1 + commission_pct) "annual_sal"
                    FROM employees ;
                这里一定要注意，在MySQL里面，空值不等于空字符串。一个空字符串的长度是o，而一个空值的长度是空。
                而且，在MySQL里面，空值是占用空间的。
                空值参与运算:结果一定也为空。
                    SELECT employee_id,salary "月工资" ,salary * (1 ＋ commission _pct) * 12 "年工资" ,commission_pct
                    FROM employees;
                    SELECT employee_id,salary "月工资", salary * (1 ＋IFNULL (commission pct,0))* 12 "年工资" , commission_pct
                    FROM employees;
                着重号 ``
                    SELECT * FROM `orHer`;
                查询常数(会给所有结果添加 尚硅谷 123)
                    SELECT '尚硅谷',123,employee_id, last_name
                    FROM employees;
                显示表结构
                    DESCRIBE employees; #显示了表中字段的详细信息
                    简写 DESC
            过滤数据
                语法:
                   SELECT字段1, 字段2FROM表名
                   WHERE过滤条件
                       使用WHERE子句，将不满足条件的行过滤掉oWHERE子句紧随FROM子句
                        查询90号部门的员工信息
                        SELECT *
                        FROM employees
                        #过滤条件 一定要声明在from的后面 必须挨着
                        WHERE department_id = 90;
                        查询last_name为'King'的员工信息
                        SELECT *
                        FROM employees
                        WHERE last_name = 'King';




    */
}
