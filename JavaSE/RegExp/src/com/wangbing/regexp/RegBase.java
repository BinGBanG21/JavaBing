package com.wangbing.regexp;/*
 * @author WangBing
 * @version 1.0
    正则表达式语法
        如果要想灵活的运用正则表达式，必须了解其中各种元字符的功能，元字符从功能上大致分为∶
            1. 限定符
            2.选择匹配符
            3.分组组合和反向引用符
            4.特殊字符
            5.字符匹配符
            6.定位符
        需要用到转义符号的字符有以下∶.*+（）$/\?【】^{}

 **/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegBase {
    public static void main(String[] args) {

        //元字符(Metacharacter)-转义号 \\
        String content = "abc$(a.bc(123( )";
        //匹配( => \\(
        //匹配. => \\. //String regStr = "\\.";
        //String regStr = "\\d\\d\\d";
        String regStr = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }

        //元字符-字符匹配符
        //String content = "a11c8abc _ABCy @";
        //String regStr = "[a-z]";//匹配 a-z 之间任意一个字符
        //String regStr = "[A-Z]";//匹配 A-Z 之间任意一个字符
        //String regStr = "abc";//匹配 abc 字符串[默认区分大小写]
        //String regStr = "(?i)abc";//匹配 abc 字符串[不区分大小写]
        //String regStr = "[0-9]";//匹配 0-9 之间任意一个字符
        //String regStr = "[^a-z]";//匹配 不在 a-z 之间任意一个字符
        //String regStr = "[^0-9]";//匹配 不在 0-9 之间任意一个字符
        //String regStr = "[abcd]";//匹配 在 abcd 中任意一个字符
        //String regStr = "\\D";//匹配 不在 0-9 的任意一个字符
        //String regStr = "\\w";//匹配 大小写英文字母, 数字，下划线
        //String regStr = "\\W";//匹配 等价于 [^a-zA-Z0-9_]
        //\\s 匹配任何空白字符(空格,制表符等)
        //String regStr = "\\s";
        //\\S 匹配任何非空白字符 ,和\\s 刚好相反
        //String regStr = "\\S";
        //. 匹配出 \n 之外的所有字符,如果要匹配.本身则需要使用 \\. String regStr = ".";
        //说明
        //1. 当创建 Pattern 对象时，指定 Pattern.CASE_INSENSITIVE, 表示匹配是不区分字母大小写. Pattern pattern = Pattern.compile(regStr/*, Pattern.CASE_INSENSITIVE*/);
//        Matcher matcher = pattern.matcher(content);
//        while (matcher.find()) {
//            System.out.println("找到 " + matcher.group(0));
//        }
    }
}
