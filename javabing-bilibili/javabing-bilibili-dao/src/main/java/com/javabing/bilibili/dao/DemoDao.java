package com.javabing.bilibili.dao;/*
 * ClassName: DemoDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:14
 * @Version 1.0
 **/

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoDao {

    public Long query(Long id);
}