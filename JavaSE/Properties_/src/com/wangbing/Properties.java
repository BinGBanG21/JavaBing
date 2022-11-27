package com.wangbing;/*
 * @author WangBing
 * @version 1.0
    properties基本介绍
        1）专门用于读写配置文件的集合类 配置文件的格式∶键=值键=值
        2）注意键值对不需要有空格，值不需要用引号一起来，默认类型是String
    Properties的常见方法
        · load∶加载配置文件的键值对到Properties对象
        · list∶将数据显示到指定设备getProperty（key）根据键获取值
        · setProperty（key，value）∶设置键值对到Properties对象
        · store∶将Properties中的键值对存储到配置文件，在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码
 **/

public class Properties {
    public static void main(String[] args) {
        
    }
}
