package com.javabing.bilibili.dao;/*
 * ClassName: FileDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/11/星期五 12:31
 * @Version 1.0
 **/


import com.javabing.bilibili.domain.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDao {

    Integer addFile(File file);

    File getFileByMD5(String md5);
}
