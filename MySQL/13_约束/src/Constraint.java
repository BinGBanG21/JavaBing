public class Constraint {
    public static void main(String[] args) {

    }
    /*
    1. 约束的分类
        * 根据约束数据列的限制，约束可分为：
          + 单列约束：每个约束只约束一列
          + 多列约束：每个约束可约束多列数据
        * 根据约束的作用范围，约束可分为：
          + 列级约束：只能作用在一个列上，跟在列的定义后面
          + 表级约束：可以作用在多个列上，不与列一起，而是单独定义
        * 根据约束起的作用，约束可分为：
          + NOT NULL 非空约束，规定某个字段不能为空
          + UNIQUE 唯一约束，规定某个字段在整个表中是唯一的
          + PRIMARY KEY 主键(非空且唯一)约束
          + FOREIGN KEY 外键约束
          + CHECK 检查约束
          + DEFAULT 默认值约束
    2. 非空约束
        1) 作用
            限定某个字段/ 某列的值不允许为空
        2) 关键字
            NOT NULL
        3) 特点
            * 默认，所有的类型的值都可以是NULL，包括INT、FLOAT等数据类型
            * 非空约束只能出现在表对象的列上，只能某个列单独限定非空，不能组合非空
            * 一个表可以有很多列都分别限定了非空
            * 空字符串''不等于NULL，0也不等于NULL
        4) 添加非空约束
            1. 建表时
            CREATE TABLE 表名称(
            字段名 数据类型,
            字段名 数据类型 NOT NULL,
            字段名 数据类型 NOT NULL
            );
            2. 建表后**
            alter table 表名称 modify 字段名 数据类型 not null;
        5) 删除非空约束
            alter table 表名称 modify 字段名 数据类型 NULL;#去掉not null，相当于修改某个非注解字段，该字段允许为空
            或
            alter table 表名称 modify 字段名 数据类型;#去掉not null，相当于修改某个非注解字段，该字段允许为空
    3. 唯一性约束



     */
}
