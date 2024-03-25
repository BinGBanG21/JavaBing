public class DataType {
    public static void main(String[] args) {

    }
    /*
    1. MySQL中的数据类型
        | 类型             | 举例                                                         |
        | ---------------- | ------------------------------------------------------------ |
        | 整数类型         | TINYINT、SMALLINT、MEDIUMINT、INT(或INTEGER)、BIGINT             |
        | 浮点类型         | FLOAT、DOUBLE                                                  |
        | 定点数类型       | DECIMAL                                                        |
        | 位类型           | BIT                                                           |
        | 日期时间类型     | YEAR、TIME、DATE、DATETIME、TIMESTAMP                            |
        | 文本字符串类型   | CHAR、VARCHAR、TINYTEXT、TEXT、MEDIUMTEXT、LONGTEXT               |
        | 枚举类型         | ENUM                                                           |
        | 集合类型         | SET                                                            |
        | 二进制字符串类型 | BINARY、VARBINARY、TINYBLOB、BLOB、MEDIUMBLOB、LONGBLOB            |
        | JSON类型         | JSON对象、JSON数组                                               |
        | 空间数据类型     | 单值类型：GEOMETRY、POINT、LINESTRING、POLYGON；
        | 集合类型：MULTIPOINT、MULTILINESTRING、MULTIPOLYGON、 GEOMETRYCOLLECTION             |

        常见数据类型的属性，如下：
        | MySQL关键字        | 含义                                                 |
        | ------------------ | ---------------------------------------------------- |
        | NULL               | TINYINT、SMALLINT、MEDIUMINT、INT(或INTEGER)、BIGINT |
        | NOT NULL           | FLOAT、DOUBLE                                        |
        | DEFAULT            | DECIMAL                                              |
        | PRIMARY KEY        | BIT                                                  |
        | AUTO_INCREMENT     | YEAR、TIME、DATE、DATETIME、TIMESTAMP                |
        | UNSIGNED           | CHAR、VARCHAR、TINYTEXT、TEXT、MEDIUMTEXT、LONGTEXT  |
        | CHARACTER SET name | ENUM                                                 |
    2. 整数类型
        1) 类型介绍
        整数类型一共有 5 种，包括 TINYINT、SMALLINT、MEDIUMINT、INT（INTEGER）和 BIGINT。
        它们的区别如下表所示：
        | 整数类型     | 字节 | 有符号数取值范围                         | 无符号数取值范围       |
        | ------------ | ---- | ---------------------------------------- | ---------------------- |
        | TINYINT      | 1    | -128~127                                 | 0~255                  |
        | SMALLINT     | 2    | -32768~32767                             | 0~65535                |
        | MEDIUMINT    | 3    | -8388608~8388607                         | 0~16777215             |
        | INT、INTEGER | 4    | -2147483648~2147483647                   | 0~4294967295           |
        | BIGINT       | 8    | -9223372036854775808~9223372036854775807 | 0~18446744073709551615 |

        2) 可选属性
        整数类型的可选属性有三个：
        * M
        M : 表示显示宽度，M的取值范围是(0, 255)。例如，int(5)：当数据宽度小于5位的时候在数字前面需要用 字符填满宽度。
        该项功能需要配合“ ZEROFILL ”使用，表示用“0”填满宽度，否则指定显示宽度无效。 如果设置了显示宽度，那么插入的数据宽度超过显示宽度限制，会不会截断或插入失败？
        不会对插入的数据有任何影响，还是按照类型的实际宽度进行保存，即 显示宽度与类型可以存储的 值范围无关 。
        从MySQL 8.0.17开始，整数数据类型不推荐使用显示宽度属性。 整型数据类型可以在定义表结构时指定所需要的显示宽度，
        如果不指定，则系统为每一种类型指定默认 的宽度值。
        * UNSIGNED
        UNSIGNED : 无符号类型（非负），所有的整数类型都有一个可选的属性UNSIGNED（无符号属性），无 符号整数类型的最小取值为0。
        所以，如果需要在MySQL数据库中保存非负整数值时，可以将整数类型设 置为无符号类型。 int类型默认显示宽度为int(11)，无符号int类型默认显示宽度为int(10)。
        * ZEROFILL
        ZEROFILL : 0填充,（如果某列是ZEROFILL，那么MySQL会自动为当前列添加UNSIGNED属性），如果指 定了ZEROFILL只是表示不够M位时，
        用0在左边填充，如果超过M位，只要不超过数据存储范围即可。
        原在 int(M) 中，M 的值跟 int(M) 所占多少存储空间并无任何关系。
        int(3)、int(4)、int(8) 在磁盘上都 是占用 4 bytes 的存储空间。也就是说，int(M)，
        必须和UNSIGNED ZEROFILL一起使用才有意义。如果整 数值超过M位，就按照实际位数存储。只是无须再用字符 0 进行填充。
    3. 浮点类型
        1) 类型介绍
        浮点数和定点数类型的特点是可以 处理小数 ，你可以把整数看成小数的一个特例。因此，浮点数和定点 数的使用场景，比整数大多了。 MySQL支持的浮点数类型，分别是 FLOAT、DOUBLE、REAL。
        * FLOAT 表示单精度浮点数；
        * DOUBLE 表示双精度浮点数；
        * REAL默认就是 DOUBLE。如果你把 SQL 模式设定为启用“ REAL_AS_FLOAT ”，那么，MySQL 就认为 REAL 是 FLOAT。
            如果要启用“REAL_AS_FLOAT”，可以通过以下 SQL 语句实现：
            SET sql_mode = “REAL_AS_FLOAT”;
        2) 数据精度说明
            对于浮点类型，在MySQL中单精度值使用 4 个字节，双精度值使用 8 个字节。
            MySQL允许使用 非标准语法 （其他数据库未必支持，因此如果涉及到数据迁移，则最好不要这么 用）： FLOAT(M,D) 或 DOUBLE(M,D) 。这里，M称为 精度 ，D称为 标度 。(M,D)中 M=整数位+小数 位，D=小数位。 D<=M<=255，0<=D<=30。
            例如，定义为FLOAT(5,2)的一个列可以显示为-999.99-999.99。如果超过这个范围会报错。
            * FLOAT和DOUBLE类型在不指定(M,D)时，默认会按照实际的精度（由实际的硬件和操作系统决定） 来显示。
            * 说明：浮点类型，也可以加 UNSIGNED ，但是不会改变数据范围，例如：FLOAT(3,2) UNSIGNED仍然 只能表示0-9.99的范围。
            * 不管是否显式设置了精度(M,D)，这里MySQL的处理方案如下：
              * 如果存储时，整数部分超出了范围，MySQL就会报错，不允许存这样的值
              * 如果存储时，小数点部分若超出范围，就分以下情况：
                + 若四舍五入后，整数部分没有超出范围，则只警告，但能成功操作并四舍五入删除多余 的小数位后保存。例如在FLOAT(5,2)列内插入999.009，近似结果是999.01。
                + 若四舍五入后，整数部分超出范围，则MySQL报错，并拒绝处理。如FLOAT(5,2)列内插入 999.995和-999.995都会报错
        3) 精度误差说明
            MySQL用4个字节存储 FLOAT 类型数据，用8个字节来存储 DOUBLE 类型数据。无论哪个，都是采用二进制的方式来进行存储的。
            比如9.625,用二进制来表达，就是1001.101,或者表达成 1.001101×2^3。
            如果尾数不是 0 或 5（比如 9.624),你就无法用一个二进制数来精确表达。进而，就只好在取值允许的范 围内进行四舍五入。
    4. 定点数类型
        MySQL中的定点数类型只有 DECIMAL 一种类型。
        使用 DECIMAL(M,D) 的方式表示高精度小数。其中，M被称为精度，D被称为标度。0<=M<=65， 0<=D<=30，D
            * DECIMAL(M,D)的最大取值范围与DOUBLE类型一样，但是有效的数据范围是由M和D决定的。 DECIMAL 的存储空间并不是固定的，由精度值M决定，总共占用的存储空间为M+2个字节。也就是 说，在一些对精度要求不高的场景下，比起占用同样字节长度的定点数，浮点数表达的数值范围可 以更大一些。
            * 定点数在MySQL内部是以 字符串 的形式进行存储，这就决定了它一定是精准的。
            * 当DECIMAL类型不指定精度和标度时，其默认为DECIMAL(10,0)。当数据的精度超出了定点数类型的 精度范围时，则MySQL同样会进行四舍五入处理。
            * 浮点数 vs 定点数
              * 浮点数相对于定点数的优点是在长度一定的情况下，浮点类型取值范围大，但是不精准，适用 于需要取值范围大，又可以容忍微小误差的科学计算场景（比如计算化学、分子建模、流体动 力学等）
              * 定点数类型取值范围相对小，但是精准，没有误差，适合于对精度要求极高的场景 （比如涉 及金额计算的场景）



        */

}
