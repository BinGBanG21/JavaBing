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
    HAVING关键字的使用
     */
}
