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
            2. 建表后
            alter table 表名称 modify 字段名 数据类型 not null;
        5) 删除非空约束
            alter table 表名称 modify 字段名 数据类型 NULL;#去掉not null，相当于修改某个非注解字段，该字段允许为空
            或
            alter table 表名称 modify 字段名 数据类型;#去掉not null，相当于修改某个非注解字段，该字段允许为空
    3. 唯一性约束
        1) 作用
        用来限制某个字段/某列的值不能重复。
        2) 关键字
        UNIQUE
        3) 特点
            * 同一个表可以有多个唯一约束。
            * 唯一约束可以是某一个列的值唯一，也可以多个列组合的值唯一。
            * 唯一性约束允许列值为空。
            * 在创建唯一约束的时候，如果不给唯一约束命名，就默认和列名相同。
            * MySQL会给唯一约束的列上默认创建一个唯一索引。
        4) 添加唯一约束
            1. 建表时
                create table 表名称(
                字段名 数据类型,
                字段名 数据类型 unique,
                字段名 数据类型 unique key,
                字段名 数据类型
                );

                create table 表名称(
                字段名 数据类型,
                字段名 数据类型,
                字段名 数据类型,
                [constraint 约束名] unique key(字段名)
                );
            2. 建表后指定唯一键约束**
                字段列表中如果是一个字段，表示该列的值唯一。如果是两个或更多个字段，那么复合唯一，即多个字段的组合是唯一的
                方式1：
                alter table 表名称 add unique key(字段列表);
                方式2：
                alter table 表名称 modify 字段名 字段类型 unique;
        5) 关于复合唯一约束
            create table 表名称(
            字段名 数据类型,
            字段名 数据类型,
            字段名 数据类型,
            unique key(字段列表) #字段列表中写的是多个字段名，多个字段名用逗号分隔，表示那么是复合唯一，即多
            个字段的组合是唯一的
            );
        6) 删除唯一约束
            * 添加唯一性约束的列上也会自动创建唯一索引。
            * 删除唯一约束只能通过删除唯一索引的方式删除。
            * 删除时需要指定唯一索引名，唯一索引名就和唯一约束名一样。
            * 如果创建唯一约束时未指定名称，如果是单列，就默认和列名相同；
            * 如果是组合列，那么默认和() 中排在第一个的列名相同。也可以自定义唯一性约束名。
    4. PRIMARY KEY 约束
        1) 作用
            用来唯一标识表中的一行记录。
        2) 关键字
            primary key
        3) 特点
            主键约束相当于唯一约束+非空约束的组合，主键约束列不允许重复，也不允许出现空值。
            * 一个表最多只能有一个主键约束，建立主键约束可以在列级别创建，也可以在表级别上创建。
            * 主键约束对应着表中的一列或者多列（复合主键）
            * 如果是多列组合的复合主键约束，那么这些列都不允许为空值，并且组合的值不允许重复。
            * MySQL的主键名总是PRIMARY，就算自己命名了主键约束名也没用。
            * 当创建主键约束时，系统默认会在所在的列或列组合上建立对应的主键索引（能够根据主键查询的，就根据主键查询，效率更高。如果删除主键约束了，主键约束对应的索引就自动删除了。
            * 需要注意的一点是，不要修改主键字段的值。因为主键是数据记录的唯一标识，如果修改了主键的值，就有可能会破坏数据的完整性。
        4) 添加主键约束
            1. 建表时指定主键约束
                create table 表名称(
                字段名 数据类型 primary key, #列级模式
                字段名 数据类型,
                字段名 数据类型
                );

                create table 表名称(
                字段名 数据类型,
                字段名 数据类型,
                字段名 数据类型,
                [constraint 约束名] primary key(字段名) #表级模式
                );
           2. 建表后增加主键约束
                ALTER TABLE 表名称 ADD PRIMARY KEY(字段列表);
                字段列表可以是一个字段，也可以是多个字段，如果是多个字段的话，是复合主键
        5) 关于复合主键
            create table 表名称(
            字段名 数据类型,
            字段名 数据类型,
            字段名 数据类型,
            primary key(字段名1,字段名2) #表示字段1和字段2的组合是唯一的，也可以有更多个字段
            );
        6) 删除主键约束
            alter table 表名称 drop primary key




     */
}
