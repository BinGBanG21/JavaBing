package com.javabing.bilibili.dao;/*
 * ClassName: AuthRoleDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/8/星期二 21:32
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.auth.AuthRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthRoleDao {

    AuthRole getRoleByCode(String code);
}

