import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/*
    日期类（Date,Calendar）
    >前面两代日期类的不足分析
        JDK1.0中包含了一个java.util.Date类，但是它的大多数方法已经在JDK1.1引入Calendar类之后被弃用了。
        而Calendar也存在如下问题∶
            1）可变性∶像日期和时间这样的类应该是不可变的。
            2）偏移性∶Date中的年份是从1900开始的，而月份都从0开始。
            3）格式化格式化只对Date有用，Calendar则不行。
            4）此外，它们也不是线程安全的；不能处理闰秒等（每隔2天，多出1s）。
    >LocalDate（日期/年月日）、LocalTime（时间/时分秒）、LocalDateTime（日期时间/年月日时分秒）JDK8加入
        LocalDate只包含日期，可以获取日期字段LocalTime只包含时间，可以获取时间字段
        LocalDateTime包含日期+时间，可以获取日期和时间字段
     第三代日期类常用方法
        ·使用DateTimeFormatter来格式化日期
        ·LocalDateTime类
        ·MonthDay类∶检查重复事件
        ·是否是闰年
        ·增加日期的某个部分
        ·使用plus方法测试增加时间的某个部分
        ·使用minus方法测试查看一年前和一年后的日期
* */
public class Date01 {
    public static void main(String[] args) {
        //1. 获取当前系统时间
        //2. 这里的 Date 类是在 java.util 包
        //3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
        Date d1 = new Date(); //获取当前系统时间
        System.out.println("当前日期=" + d1);
        Date d2 = new Date(9234567); //通过指定毫秒数得到时间
        System.out.println("d2=" + d2); //获取某个时间对应的毫秒数

        //1. 创建 SimpleDateFormat 对象，可以指定相应的格式
        //2. 这里的格式使用的字母是规定好，不能乱写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日 hh:mm:ss E");
        String format = sdf.format(d1); // format:将日期转换成指定格式的字符串
        System.out.println("当前日期=" + format);

        //1. 可以把一个格式化的 String 转成对应的 Date
        //2. 得到 Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        //3. 在把 String -> Date ， 使用的 sdf 格式需要和你给的 String 的格式一样，否则会抛出转换异常
        String s = "1996 年 01 月 01 日 10:20:30 星期一";
        Date parse = null;
        try {
            parse = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("parse=" + sdf.format(parse));


        //1. Calendar 是一个抽象类， 并且构造器是 private
        //2. 可以通过 getInstance() 来获取实例
        //3. 提供大量的方法和字段提供给程序员
        //4. Calendar 没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        //5. 如果我们需要按照 24 小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        //2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        // 这里为什么要 + 1, 因为 Calendar 返回月时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calender 没有专门的格式化方法，所以使用时需要自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));


        //第三代日期
        //1. 使用 now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);
        //2. 使用 DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter 对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format1);
        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());
        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒
        //提供 plus 和 minus 方法可以对当前时间进行加或者减
        //看看 890 天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890 天后=" + dateTimeFormatter.format(localDateTime));
        //看看在 3456 分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456 分钟前 日期=" + dateTimeFormatter.format(localDateTime2));
    }
}
