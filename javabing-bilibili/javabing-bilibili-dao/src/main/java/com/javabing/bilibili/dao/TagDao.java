package com.javabing.bilibili.dao;/*
 * ClassName: TagDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/17/星期四 8:35
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagDao {
    void addTag(Tag tag);

}
