package com.javabing.bilibili.dao;/*
 * ClassName: UserCoinDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/12/星期六 12:49
 * @Version 1.0
 **/

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface UserCoinDao {

    Integer getUserCoinsAmount(Long userId);

    Integer updateUserCoinAmount(@Param("userId") Long userId,
                                 @Param("amount") Integer amount,
                                 @Param("updateTime") Date updateTime);
}
