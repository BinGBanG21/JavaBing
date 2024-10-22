package com.javabing.bilibili.dao;/*
 * ClassName: ContentDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/22/星期二 8:22
 * @Version 1.0
 **/


import com.javabing.bilibili.domain.Content;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentDao {
    Long addContent(Content content);
}

