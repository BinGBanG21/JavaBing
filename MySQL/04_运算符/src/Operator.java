public class Operator {
    public static void main(String[] args) {

    }
    /*
        1.算术运算符
            算术运算符主要用于数学运算，其可以连接运算符前后的两个数值或表达式，对数值或表达式进行加（+)、减(-)、乘(*)、除（/)和取模(%)运算。
                1．加法与减法运算符
                    SELECT 108,108 + 0,100 - 0，100 +50，100 + 50 -30，100 + 35.5，100 - 35.5
                    FROM DUAL;
                    SELECT10o+'l'     #在Java语言中，结果是:1001 但是在SQL中 只表示+法运算
                    SELECT100 + 'a'   #此时将'a'看做o处理
                    FROM DUAL;
                    SELECT100 + NULL   #只要有null参与运算 结果为NULL
                    FROM DUAL;
                2. 乘法与除法运算符
                    SELECT 100，100 * 1，180 * 1.0，108 / 1.0，108 / 2,
                    100 + 2 * 5 / 2,108 /3，100 DIV 0 # 0作被除数 结果为NULL
                    FROM DUAL;
                    取模运算:% mod
                    SELECT 12 % 3,12 % 5,12MOD -5,-12 % 5,-12 % -5
                    FROM DUAL;
                    结论：
                        一个数乘以整数1和除以整数1后仍得原数;
                        一个数乘以浮点数1和除以浮点数1后变成浮点数，数值与原数相等;
                        一个数除以整数后，不管是否能除尽，结果都为一个浮点数;
                        一个数除以另一个数，除不尽时，结果为一个浮点数，并保留到小数点后4位;
                        乘法和除法的优先级相同，进行先乘后除操作与先除后乘操作，得出的结果相匠
                        在数学运算中，o不能用作除数，在MySQL中，一个数除以o为NULL。
                    练习：查询员工id为偶数的员工信息
                        SELECT employees_id,last_name,salary
                        FROM employees
                        WHERE employees_id % 2  = 0;
        2.比较运算符
            比较运算符用来对表达式左边的操作数和右边的操作数进行比较，比较的结果为真则返回1，比较的结果为假则返回o，其他情况则返回NULL。
            比较运算符经常被用来作为SELECT查询语句的条件来使用，返回符合条件的结果记录。
                等号运算符
                  等号运算符(=）判断等号两边的值、字符串或表达式是否相等，如果相等则返回1，不相等则返回0。
                  在使用等号运算符时，遵循如下规则:
                  如果等号两边的值、字符串或表达式都为字符串，则MysQL会按照字符串进行比较Ⅰ其比较的是每个字符串中字符的ANSI编码是否相等。
                  如果等号两边的值都是整数，则MySQL会按照整数来比较两个值的大小。
                  如果等号两边的值一个是整数，另一个是字符串，则MysQL会将字符串转化为数字进行比较。。如果等号两边的值、字符串或表达式中有一个为NULL，则比较结果为NULL。
                  对比: SQL中赋值符号使用:=
                      SELECT 1 = 1，1 = '1'，1 = 0, 'a' = 'a',(5 + 3) = (2 + 6)，"' = NULL , NULL = NOLL;
                      SELECT 1 = 2,1 != 2,1 = '1',1 = 'a',0 = 'a'   #字符串存在隐式转换。如果转换数值不成功，则看做0
                      FROM DUAL;
                      SELECT 'a' = 'a ' , ' ab' = 'ab' , 'a' = 'b'  #两边都是字符串的话，则按照ANSI的比较规则进行比较。
                      FROM DUAL;
                      SELECT 1 = NULL,NULL= NULL   #只要有null参与判断，结果就为null
                      FROM DUAL;
                      SELECT last_name, salary, commission_pct
                      FROM employees
                      #where salary = 6000 ;
                      WHERE commission pct =NULL; #不会有任何结果  因为查询条件要对
                安全等于运算符
                    安全等于运算符(<=>）与等于运算符(=）的作用是相似的，唯一的区别是'(<=>）'可以用来对NULL进行判断。
                    在两个操作数均为NULL时，其返回值为1，而不为NULL;当一个操作数为NULL时，其返回值为0，而不为NULL。
                关键字
                    IS NULL         为空运算符            判断值、字符串或表达式是否为空
                    ISNOTNULL       不为空运算符           判断值、字符串或表达式是否不为空
                    LEAST           最小值运算符           在多个值中返回最小值
                    GREATEST        最大值运算符           在多个值中返回最大值
                    BETWEEN AND    两值之间的运算符         判断一个值是否在两个值之间
                    ISNULL          为空运算符             判断一个值、字符串或表达式是否为空
                    IN              属于运算符             判断一个值是否为列表中的任意一个值
                    NOT IN          不属于运算符           判断一个值是否不是一个列表中的任意一个值
                    LIKE            模糊匹配运算符          判断一个值是否符合模糊匹配规则
                    REGEXP          正则表达式运算符        判断一个值是否符合正则表达式的规则
                    RLIKE           正则表达式运算符        判断一个值是否符合正则表达式的规则
                    举例：
                        SELECT last_name , salary , commission_pct
                        FROM employees
                        WHERE NOT commission pct <=>NULL;
                        #LEAST() \GREATEST
                        SELECT LEAST ( 'g', 'b', 't '，'m ' ),GREATEST ( 'g ', 'b ','t ' , 'm ')
                        FROM DUAL;
                        SELECT LEAST(first_name,last_name),LEAST(LENGTH(first_name)，LENGTH(last_name))
                        FROM employees;
                        #BETWEEN...AND .... I
                        #查询工资在6000到8000的员工信息
                        SELECT employee_id, last_name , salary
                        FROM employees
                        WHERE salary BETWEEN6000 AND 8000 ;
                        WHERE salary >= 6000 && salary <= 8000;
                        SELECT employee_id, last_name ,salary
                        FROM employees
                        WHERE salary NOT BETWEEN6000 AND 8000;
                        #where salary < 6000 or salary > 8000 ;
                        #练习:查询部门为10,20,30部门的员工信息SELECT last_name , salary , department_id
                        FROM employees
                        #where department_id = 10 or department_id = 20 or department_id = 30;
                        WHERE department_ id IN( 10,20,30) ;
                        #练习:查询工资不是6000,7000,8000的员工信息
                        SELECT last_name , salary,department_id
                        FROM employees
                        WHERE salary NOT IN(6000,7000,8000) ;
                        #LIKE:模糊查询
                        #号 :代表不确定个数的字符(o个，1个，或多个) 并且忽略大小写
                        #练习:查询last_name中包含字符'a'的员工信息S
                        ELECT last_name
                        FROM employees
                        WHERE last_name LIKE '%a% ';
                        SELECT last_name
                        FROM employees
                        WHERE last_name LIKE '%a%e%'OR last_name LIKE '%e%a%';
                        #_代表—个不确定的字符
                        #查询第2个字符是'a'的员工信息SELECT last_name
                        FROM employees
                        WHERE last name LIKE '_a%';
                        #练习:查询第2个字符是_且第3个字符是'a'的员工信息#需要使用转义字竹:i
                        SELECT last_name
                        FROM employees
                        WHERE last_name LIKE '_\_a%';
                        OR可以和AND一起使用，但是在使用时要注意两者的优先级，由于AND的优先级高于OR
                        因此先对AND两边的操作数进行操作，再与OR中的操作数结合。

        3.逻辑运算符
        4.位运算符
        5.运算符的优先级
        拓展:使用正则表达式查询


    */
}
