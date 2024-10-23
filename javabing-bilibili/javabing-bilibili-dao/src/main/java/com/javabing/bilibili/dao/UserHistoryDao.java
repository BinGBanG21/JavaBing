package com.javabing.bilibili.dao;/*
 * ClassName: UserHistoryDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/23/星期三 12:26
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.UserVideoHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserHistoryDao {
    int pageCountUserVideoHistory(Map<String, Object> params);

    List<UserVideoHistory> pageListUserVideoHistory(Map<String, Object> params);
}
