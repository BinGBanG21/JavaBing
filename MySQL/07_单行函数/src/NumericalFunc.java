public class NumericalFunc {
    public static void main(String[] args) {

    }
    /*
     数值函数
            函数                             用法
            ABS(x)                          返回x的绝对值
            SIGN(X)                         返回x的符号。正数返回1，负数返回-1，0返回0
            PI()                            返回圆周率的值
            CEIL(x)，CEILING(x)             返回大于或等于某个值的最小整数
            FLOOR(x)                        返回小于或等于某个值的最大整数
            LEAST(e1,e2,e3...)              返回列表中的最小值
            GREATEST(e1,e2,e3...)           返回列表中的最大值
            MOD(x,y)                        返回x除以Y后的余数
            RAND()                          返回O~1的随机值
            RAND(x)                         返回0~1的随机值，其中x的值用作种子值，相同的x值会产生相同的随机数
            ROUND(x)                        返回一个对x的值进行四舍五入后，最接近于x的整数
            ROUND(x,y)                      返回一个对x的值进行四舍五入后最接近x的值，并保留到小数点后面Y位
            TRUNCATE(x,y)                   返回数字x截断为y位小数的结果
            SQRT(x)                         返回x的平方根。当x的值为负数时，返回NULL
    三角函数
            SIN(x)                          返回x的正弦值，其中，参数x为弧度值
            ASIN(x)                         返回x的反正弦值，即获取正弦为x的值。如果x的值不在-1到1之间，则返回NULL
            COS(x)                          返回x的余弦值，其中，参数x为弧度值
            ACOS(x)                         返回x的反余弦值，即获取余弦为x的值。如果x的值不在-1到1之间，则返回NULL
            TAN(x)                          返回x的正切值，其中，参数x为弧度值
            ATAN(x)                         返回x的反正切值，即返回正切值为x的值
            ATAN2(m,n)                      返回两个参数的反正切值
            COT(x)                          返回x的余切值，其中，x为弧度值
            x需要换算成弧度值  不能直接写度数（1弧度是57°多）
            RADIANS(x)          将角度转化为弧度，其中，参数x为角度值
            DEGREES(x)          将弧度转化为角度，其中，参数x为弧度值
    字符串函数
            ASCII(S)                            返回字符串s中的第一个字符的ASClI码值
            CHAR_LENGTH(s)                      返回字符串s的字符数。作用与CHARACTER_LENGTH(s)相同
            LENGTH(s)                           返回字符串s的字节数，和字符集有关
            CONCAT(s1,s2......n)                连接s1,s2...n为一个字符串
            CONCAT_WS(x,s1,s2......sn)          同CONCAT(s1,s2,...函数，但是每个字符串之间要加上x
            INSERT(str, idx, len,replacestr)    将字符串str从第idx位置开始，len个字符长的子串替换为字符串replacestr 注意sql中字符串位置是由1开始的
            REPLACE(str, a, b)                  用字符串b替换字符串str中所有出现的字符串a
            UPPER(s)或 UCASE(s)                 将字符串s的所有字母转成大写字母
            LOWER(s)或 LCASE(s)                  将字符串s的所有字母转成小写字母
            LEFT(str,n)                         返回字符串str最左边的n个字符
            RIGHT(str,n)                        返回字符串str最右边的n个字符
            LPAD(str, len, pad)                 用字符串pad对str最左边进行填充，直到str的长度为len个字符
            RPAD(str ,len, pad)                 用字符串pad对str最右边进行填充，直到str的长度为len个字符
            LTRIM(s)                            去掉字符串s左侧的空格
            RTRIM(s)                            去掉字符串s右侧的空格
            TRIM(s)                             去掉字符串s开始与结尾的空格
            TRIM(s1 FROM s)                     去掉字符串s开始与结尾的s1
            TRIM(LEADING s1 FROM s)             去掉字符串s开始处的s1
            TRIM(TRAILING s1 FROM s)            去掉字符串s结尾处的s1
            REPEAT(str, n)                      返回str重复n次的结果
            SPACE(n)                            返回n个空格
            STRCMP(s1,s2)                       比较字符串s1,s2的ASCII码值的大小
            SUBSTR(s,index,len)                 返回从字符串s的index位置其len个字符，作用与SUBSTRING(s,n,len)、MID(s,n,len)相同
            LOCATE(substr,str)                  返回字符串substr在字符串str中首次出现的位置，作用于POSITION(substr IN str)、INSTR(str,substr)相同。未找到，返回0
            ELT(m,s1,s2,...,sn)                 返回指定位置的字符串，如果m=1，则返回s1，如果m=2，则返回s2，如果m=n，则返回sn
            FIELD(s,s1,s2,....n)                返回字符串s在字符串列表中第一次出现的位置
            FIND_IN_SET(s1,s2)                  返回字符串s1在字符串s2中出现的位置。其中，字符串s2是一个以逗号分隔的字符串
            FIND
            FIND

     */
}
