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


    */
}
