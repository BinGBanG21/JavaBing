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
                反之,GROUP BY中声明的字段可以不出现在SELECT中。
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
            方式1 (执行效率高于方式2)
            SELECT department_id,MAX(salary)
            FROM employees
            WHERE department_id IN (10,20,30,40)
            GROUP BY department_id
            HAVING MAX(salary) > 10000;
            方式2
            SELECT department_id,MAX(salary)
            FROM employees
            GROUP BY department_id
            HAVING MAX(salary) > 10000 AND department_id IN (10,20,30,40);
        结论:当过滤条件中有聚合函数时，则此过滤条件必须声明在HAVING中。
            当过滤条件中没有聚合函数时，则此过滤条件声明在WHERE中或HAVING中都可以。
            但是，建议大家声明在WHERE中,因为效率更高
    WHERE与HAVING的对比
        区别1:WHERE可以直接使用表中的字段作为筛选条件，但不能使用分组中的计算函数作为筛选条件;
             HAVING必须要与GROUP BY配合使用，可以把分组计算的函数和分组字段作为筛选条件。
        区别2:如果需要通过连接从关联表中获取需要的数据，WHERE 是先筛选后连接，而HAVING是先连接后筛选。
    开发中的选择
        WHERE 和HAVING也不是互相排斥的，我们可以在一个查询里面同时使用WHERE和HAVING。
        包含分组统计函数的条件用HAVING，普通条件用WHERE。
        这样，我们就既利用了WHERE条件的高效快速，又发挥了HAVING 可以使用包含分组统计函数的查询条件的优点。
        当数据量特别大的时候，运行效率会有很大的差别。
    SQL底层执行原理
        SELECT语句的完整结构
            SELECT ..., ..., ...,(存在聚合函数)
            FROM ... (LEFT/RIGHT)JOIN... ON...
            (LEFT/RIGHT)JOIN... ON...
            WHERE ...(不包含聚合函数的过滤条件)
            GROUP BY.... #分组
            HAVING...(包含聚合函数的过滤条件)
            ORDER BY... ASC/DESC
            LIMIT...;
    SQL语句的执行过程
        FROM -> LEFT/RIGHT -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY - LIMIT
        因为执行顺序来看 WHERE 在 HAVING前面 所以不包含聚合函数的过滤条件写在WHERE中会比较好
        包括别名在SELECT中起的别名 可以在ORDER BY中使用 不能在WHERE中使用
        总结：
            SELECT是先执行FROM这一步的。在这个阶段，如果是多张表联查，还会经历下面的几个步骤:
                1.首先先通过CRoSS JOIN求笛卡尔积，相当于得到虚拟表vt (virtual table) 1-1;
                2.通过ON进行筛选，在虚拟表vt1-1的基础上进行筛选，得到虚拟表vt1-2;
                3.添加外部行。如果我们使用的是左连接、右链接或者全连接，就会涉及到外部行，也就是在虚拟表vt1-2的基础上增加外部行，得到虚拟表vt1-3。
                  当然如果我们操作的是两张以上的表，还会重复上面的步骤，直到所有表都被处理完为止。这个过程得到是我们的原始数据。


     */
}
