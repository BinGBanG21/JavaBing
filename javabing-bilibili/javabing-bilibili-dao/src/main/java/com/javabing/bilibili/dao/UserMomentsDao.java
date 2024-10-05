package com.javabing.bilibili.dao;/*
 * ClassName: UserMomentsDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/5/星期六 19:09
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.UserMoment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMomentsDao {

    Integer addUserMoments(UserMoment userMoment);
}
