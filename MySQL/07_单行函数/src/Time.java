public class Time {
    public static void main(String[] args) {

    }
    /*
        获取时间、日期
            函数                        用法
            CURDATE()                  返回当前的时间 只包含年、月、日
            CURTIME()                  返回当前的时间 只包含时、分、秒
            NOW()                      返回当前系统的日期和时间
            UTC_DATE                   返回世界标准日期
            UTC_TIME                   返回世界标准时间
        日期与时间戳的转换
            UNIX_TIMESTAMP()            以UNIX时间戳的形式返回当前时间。
            UNIX_TIMESTAMP(date)        SELECT UNIX将时间date以UNIX时间戳的形式返回。
            FROM__UNIXTIME(timestamp)   将UNIX时间戳的时间转换为普通格式的时间
        获取月份、星期、星期数、天数等函数
            YEAR(date) / MONTH(date)/ DAY(date)         返回具体的日期值
            HOUR(time) / MINUTE(time) / SECOND(time)    返回具体的时间值
            MONTHNAME(date)                             返回月份:January,...
            DAYNAME(date)                               返回星期几:MONDAY，TUESDAY....SUNDAY
            WEEKDAY(date)                               返回周几，注意，周1是0，周2是1，。。。周日是6
            QUARTER(date)                               返回日期对应的季度，范围为1~4
            WEEK(date), WEEKOFYEAR(date)                返回一年中的第几周
            DAYOFYEAR(date)                             返回日期是一年中的第几天
            DAYOFMONTH(date)                            返回日期位于所在月份的第几天
            DAYOFWEEK(date)                             返回周几，注意:周日是1，周一是2，。。。周六是7
        日期的操作函数
            EXTRACT(type FROM date)                     返回指定日期中特定的部分，type指定返回的值
        时间和秒钟的转换函数
            TIME_TO_SEC(time)                           将time转化为秒并返回结果值。转化的公式为:小时*3688+分钟*68+秒
            SEC_TO_TIME(seconds)                        将seconds描述转化为包含小时、分钟和秒的时间
        计算日期和时间的函数
            DATE_ADD(datetime INTERVAL exp -+type)      返回与给定日期时间相差INTERVAL时间段的日期时间
            DATE_SUB()                                  返回与date相差INTERVAL时间间隔的日期
            SELECT DATE_ADD(NOW ()，INTERVAL 1 DAY) AS coll,DATE_ADD('2021-10-21 23:32:12'，INTERVAL 1 SECOND
            ADDDATE ( '2021-10-21 23:32:12'，INTERVAL 1 SECOND)As col3,
            DATE_ADD ( '2021-10-21 23:32:12'，INTERVAL'1_1' MINUTE_SECOND) as col4,
            DATE_ADD(Npw ()，INTERVAL -1 YEAR)AS col5,   #可以是负数
            DATE―ADD(NOw ()，INTERVAL '1_1' YEAR MONTH) As col6   #需要单引号FROM DUAL;

        日期的格式化与解析
            格式化:日期--->字符串
            解析:字符串---->日期
            日期的显式格式化和解析
            之前为隐式的格式化或解析
            DATE_FORMAT(date,fmt)                       按照字符串fmt格式化日期date值
            TIME_FORMAT(time,fmt)                       按照字符串fmt格式化时间time值
            GET_FORMAT(date_type,format_type)           返回日期字符串的显示格式
            STR_TO_DATE(str, fmt)                       按照字符串fmt对str进行解析，解析为一个日期



     */
}
