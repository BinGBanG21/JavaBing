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

    5. 自增列：AUTO_INCREMENT
        1) 作用
            某个字段的值自增
        2) 关键字
            auto_increment
        3) 特点
            （1）一个表最多只能有一个自增长列
            （2）当需要产生唯一标识符或顺序值时，可设置自增长
            （3）自增长列约束的列必须是键列（主键列，唯一键列）
            （4）自增约束的列的数据类型必须是整数类型
            （5）如果自增列指定了 0 和 null，会在当前最大值的基础上自增；如果自增列手动指定了具体值，直接赋值为具体值。
        4) 如何指定自增约束
            1.建表时
                create table 表名称(
                字段名 数据类型 primary key auto_increment,
                字段名 数据类型 unique key not null,
                字段名 数据类型 unique key,
                字段名 数据类型 not null default 默认值,
                );
                create table 表名称(
                字段名 数据类型 default 默认值 ,
                字段名 数据类型 unique key auto_increment,
                字段名 数据类型 not null default 默认值,
                primary key(字段名)
                );
            2.建表后
                alter table 表名称 modify 字段名 数据类型 auto_increment;
        5) 删除自增约束
            #alter table 表名称 modify 字段名 数据类型 auto_increment;#给这个字段增加自增约束
            alter table 表名称 modify 字段名 数据类型; #去掉auto_increment相当于删除

        6) MySQL 8.0新特性—自增变量的持久化
            在MySQL 5.7系统中，对于自增主键的分配规则，是由InnoDB数据字典 内部一个 计数器 来决定的，而该计数器只在 内存中维护 ，并不会持久化到磁盘中。当数据库重启时，该 计数器会被初始化。
            在MySQL 8.0将自增主键的计数器持久化到 重做日志 中。每次计数器发生改变，都会将其写入重做日志 中。如果数据库重启，InnoDB会根据重做日志中的信息来初始化计数器的内存值。

    6. FOREIGN KEY 约束
        1) 作用
            限定某个表的某个字段的引用完整性。
        2) 关键字
            FOREIGN KEY
        3) 主表和从表/父表和子表
            主表（父表）：被引用的表，被参考的表
            从表（子表）：引用别人的表，参考别人的表
        4) 特点
            （1）从表的外键列，必须引用/参考主表的主键或唯一约束的列为什么？因为被依赖/被参考的值必须是唯一的
            （2）在创建外键约束时，如果不给外键约束命名，默认名不是列名，而是自动产生一个外键名（例如 student_ibfk_1;），也可以指定外键约束名。
            （3）创建(CREATE)表时就指定外键约束的话，**先创建主表**，再创建从表
            （4）删表时，先删从表（或先删除外键约束），再删除主表
            （5）当主表的记录被从表参照时，主表的记录将不允许删除，如果要删除数据，需要先删除从表中依赖该记录的数据，然后才可以删除主表的数据
            （6）在“从表”中指定外键约束，并且一个表可以建立多个外键约束
            （7）从表的外键列与主表被参照的列名字可以不相同，但是数据类型必须一样，逻辑意义一致。
                如果类型不一样，创建子表时，就会出现错误“ERROR 1005 (HY000): Can't create table'database.tablename'(errno: 150)”。 例如：都是表示部门编号，都是int类型。
            （8）当创建外键约束时，系统默认会在所在的列上建立对应的普通索引。但是索引名是外键的约束名。（根据外键查询效率很高）
            （9）删除外键约束后，必须手动删除对应的索引
        5) 添加外键约束
            1. 建表时
                create table 主表名称(
                字段1 数据类型 primary key,
                字段2 数据类型
                );

                create table 从表名称(
                字段1 数据类型 primary key,
                字段2 数据类型,
                [CONSTRAINT <外键约束名称>] FOREIGN KEY（从表的某个字段) references 主表名(被参考字段)
                );
                #(从表的某个字段)的数据类型必须与主表名(被参考字段)的数据类型一致，逻辑意义也一样
                #(从表的某个字段)的字段名可以与主表名(被参考字段)的字段名一样，也可以不一样
                -- FOREIGN KEY: 在表级指定子表中的列
                -- REFERENCES: 标示在父表中的列
            2. 建表后
              一般情况下，表与表的关联都是提前设计好了的，因此，会在创建表的时候就把外键约束定义好。
              不过，如果需要修改表的设计（比如添加新的字段，增加新的关联关系），但没有预先定义外键约束，那么，就要用修改表的方式来补充定义。
               ALTER TABLE 从表名
               ADD [CONSTRAINT 约束名] FOREIGN KEY (从表的字段)
               REFERENCES 主表名(被引用字段) ;
        6) 约束等级
            * `Cascade方式 `：在父表上update/delete记录时，同步update/delete掉子表的匹配记录
            * `Set null方式` ：在父表上update/delete记录时，将子表上匹配记录的列设为null，但是要注意子 表的外键列不能为not null
            * `No action方式` ：如果子表中有匹配的记录，则不允许对父表对应候选键进行update/delete操作
            * `Restrict方式` ：同no action， 都是立即检查外键约束
            * `Set default方式` （在可视化工具SQLyog中可能显示空白）：父表有变更时，子表将外键列设置 成一个默认的值，但Innodb不能识别x
            如果没有指定等级，就相当于Restrict方式。 对于外键约束，最好是采用: ON UPDATE CASCADE ON DELETE RESTRICT 的方式。
        7) 删除外键约束
            (1)第一步先查看约束名和删除外键约束
            SELECT * FROM information_schema.table_constraints WHERE table_name = '表名称';  #查看某个表的约束名
            ALTER TABLE 从表名 DROP FOREIGN KEY 外键约束名;

            （2）第二步查看索引名和删除索引。（注意，只能手动删除）
            SHOW INDEX FROM 表名称; #查看某个表的索引名
            ALTER TABLE 从表名 DROP INDEX 索引名;
    7. CHECK 约束
        1) 作用
            检查某个字段的值是否符号xx要求，一般指的是值的范围
        2) 关键字
         CHECK
        3) 说明
            MySQL5.7 可以使用check约束，但check约束对数据验证没有任何作用。添加数据时，没有任何错误或警告
            但是MySQL 8.0中可以使用check约束了。
            create table employee(
            eid int primary key,
            ename varchar(5),
            gender char check ('男' or '女')
            );
    8. DEFAULT约束
        1) 作用
            给某个字段/某列指定默认值，一旦设置默认值，在插入数据时，如果此字段没有显式赋值，则赋值为默认值。
        2) 关键字
            DEFAULT
        3) 添加默认值
            1. 建表时
                create table 表名称(
                字段名 数据类型 primary key,
                字段名 数据类型 unique key not null,
                字段名 数据类型 unique key,
                字段名 数据类型 not null default 默认值,
                );
            2. 建表后
                alter table 表名称 modify 字段名 数据类型 default 默认值;
                如果这个字段原来有非空约束，你还保留非空约束，那么在加默认值约束时，还得保留非空约束，否则非空约束就被删除了
                同理，在给某个字段加非空约束也一样，如果这个字段原来有默认值约束，你想保留，也要在modify语句中保留默认值约束，否则就删除了
                alter table 表名称 modify 字段名 数据类型 default 默认值 not null;
        4) 删除默认值
            alter table 表名称 modify 字段名 数据类型; #删除默认值约束，也不保留非空约束
            alter table 表名称 modify 字段名 数据类型 not null; #删除默认值约束，保留非空约束

     */
}
