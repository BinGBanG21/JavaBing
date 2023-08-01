public class GroupFunc {
    public static void main(String[] args) {

    }
    /*
    聚合函数
        聚合(或聚集、分组)函数是对一组数据进行汇总的函数，输入的是一组数据的集合，输出的是单个值。
        作用与一组数据，并对一组数据返回一个值
    聚合函数的类型(常用)
        AVG()
        SUM()
          只适用于数值类型 不能处理字符串 返回为0
          SELECT AVG(salary),SUM(salary)
          FROM employees;
        MAX()
        MIN()
          可以用于处理字符串(姓名 日期)
          SELECT MAX(salary)
          FROM employees;
        COUNT()
          计算指定字段在查询结构中出现的个数(统计数量 不包含null值)
          SELECT COUNT(1) # 1表示把整体第一行所有数据看成1
          FROM employees;
          计算表中有多少条记录
          1.COUNT(*)
          2.COUNT(1)
          3.COUNT(具体字段) 不一定对
            #需求:查询公司中平均奖金率#错误的!
            SE工ECT AVG (commission pct)
            FROM employees;
            #正确的:
            SELECT SUM(commission_pct) / COUNT (IFNULL ( commission_pct,0))，
            #AVG(IFNULL(commission_pct,0))
            FROM employees;
            如何需要统计表中的记录数，使用CoUNT(*)、COUNT(1)、COUNT(具体字段)哪个效率更高呢?
            如果使用的是MyISAM存储引擎，则三者效率相同，都是O(1)
            如果使用的是InnoDB存储引擎，则三者效率:COUNT(*) = COUNT(1)> COUNT(字段)
    GROUP BY的使用
        查询各个部门的平均薪资、最高薪资
            SELECT department_id, AVG(salary)
            FROM employees
            GROUP BY department_id;
        使用多个分组 例如：看同一部门内工种一样的员工的平均薪资
            SELECT department_id,job_id,AVG(salary)
            FROM employees
            GROUP BY department_id,job_id; (颠倒顺序是一样的 查询条件是并列的)
            结论1:SELECT中出现的非组函数的字段必须声明在GROUP BY中。
                反之，GROUP BY中声明的字段可以不出现在SELECT中。
            结论2:GROUP BY声明在FROM后面、WHERE后面，ORDER BY前面、LIMIT前面
            结论3::MysQL中GROUP BY中使用 WITH ROLLUP 其实就是相当于把查询结果重复执行一下组函数
            SELECT department_id,AVG (salary)
            FROM employees
            GROUP BY department_id WITH ROLLUP;
            SELECT department_id,AVG (salary) avg_sal
            FROM employees
            GROUP BY department_idORDER BY avg_sal ASC;
            说明:当使用ROLLOP时，不能同时使用oRDER BY子句进行结果排序，即ROLLUP和ORDER BY是互相排斥的。

    HAVING关键字的使用(用于过滤数据)
        举例：查询各个部门中最高工资比10000高的部门信息
            错误的写法:
            SELECT department_id,MAX(salary)
            FROM employees
            WHERE MAX(salary) > 10000
            GROUP BY department_id;
        注意：如果过滤条件中使用了聚合函数 则必须使用HAVING来替换WHERE
             如果使用了HAVING 则HAVING必须出现在GROUP BY后面
             如果开发使用HAVING的前提是使用了GROUP BY 不然整体看作一组 没有意义
        练习:查询部门id为10,20,30,40这4个部门中最高工资比10000高的部门信息
            SELECT department_id MAX(salary)
            FROM employees
            WHERE department_id IN (10,20,30,40)
            HAVIK
     */
}
