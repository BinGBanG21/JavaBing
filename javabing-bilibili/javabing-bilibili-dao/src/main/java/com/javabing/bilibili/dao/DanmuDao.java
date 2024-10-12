package com.javabing.bilibili.dao;/*
 * ClassName: DanmuDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/12/星期六 21:20
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.Danmu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DanmuDao {

    Integer addDanmu(Danmu danmu);

    List<Danmu> getDanmus(Map<String,Object> params);
}
