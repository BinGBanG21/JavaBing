package com.wangbing.regexp;/*
 * @author WangBing
 * @version 1.0
    正则表达式基本介绍
        1.一个正则表达式，就是用某种模式去匹配字符串的一个公式。很多人因为它们看上去比较古怪而且复杂所以不敢去使用
          不过，经过练习后，就觉得这些复杂的表达式写起来还是相当简单的，而且，一旦你弄懂它们
          你就能把数小时辛苦而且易错的文本处理工作缩短在几分钟（甚至几秒钟）内完成
        2. 正则表达式不是只有java才有，实际上很多编程语言都支持正则表达式进行字符串操作!
 **/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory {
    public static void main(String[] args) {
        String content = "1998 年 12 月 8 日，第二代 Java 平台的企业版 J2EE 发布。1999 年 6 月，Sun 公司发布了" +
                "第二代 Java 平台（简称为 Java2）的 3 个版本：J2ME（Java2 Micro Edition，Java2 平台的微型" +
                "版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2 平台的" +
                "标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2 平台的企业版），应" +
                "用 3443 于基于 Java 的应用服务器。Java 2 平台的发布，是 Java 发展过程中最重要的一个" +
                "里程碑，标志着 Java 的应用开始普及 9889 ";
        //目标：匹配所有四个数字
        //说明
        //1. \\d 表示一个任意的数字
        String regStr = "(\\d\\d)(\\d\\d)";
        //2. 创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        //3. 创建匹配器
        //说明：创建匹配器 matcher， 按照 正则表达式的规则 去匹配 content 字符串
        Matcher matcher = pattern.matcher(content);
        //4.开始匹配

        // matcher.find() 完成的任务 （考虑分组）
        // 什么是分组，比如 (\d\d)(\d\d) ,正则表达式中有() 表示分组,第 1 个()表示第 1 组,第 2 个()表示第 2 组... * 1. 根据指定的规则 ,定位满足规则的子字符串(比如(19)(98))
        // 2. 找到后，将 子字符串的开始的索引记录到 matcher 对象的属性 int[] groups;
        // 2.1 groups[0] = 0 , 把该子字符串的结束的索引+1 的值记录到 groups[1] = 4
        //2.2 记录 1 组()匹配到的字符串 groups[2] = 0 groups[3] = 2
        // 2.3 记录 2 组()匹配到的字符串 groups[4] = 2 groups[5] = 4
        // 2.4.如果有更多的分组..... * 3. 同时记录 oldLast 的值为 子字符串的结束的 索引+1 的值即 35, 即下次执行 find 时，就从 35 开始匹配
        //
        // matcher.group(0) 分析
        //
        // 源码:
        //public String group(int group) {
        //if (first < 0)
        //throw new IllegalStateException("No match found");
        // f (group < 0 || group > groupCount())
        //throw new IndexOutOfBoundsException("No group " + group);
        //if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
        //return null;
        //return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
        //}
        // 1. 根据 groups[0]=31 和 groups[1]=35 的记录的位置，从 content 开始截取子字符串返回
        // 就是 [31,35) 包含 31 但是不包含索引为 35 的位置
        //
        //如果再次指向 find 方法.仍然安上面分析来执行

        while (matcher.find()) {
            //小结
            //1. 如果正则表达式有() 即分组
            //2. 取出匹配的字符串规则如下
            //3. group(0) 表示匹配到的子字符串
            //4. group(1) 表示匹配到的子字符串的第一组字串
            //5. group(2) 表示匹配到的子字符串的第 2 组字串
            //6. ... 但是分组的数不能越界. System.out.println("找到: " + matcher.group(0));
            System.out.println("第 1 组()匹配到的值=" + matcher.group(1));
            System.out.println("第 2 组()匹配到的值=" + matcher.group(2));
        }
    }
}
