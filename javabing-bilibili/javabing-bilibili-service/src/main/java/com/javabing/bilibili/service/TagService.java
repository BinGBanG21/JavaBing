package com.javabing.bilibili.service;/*
 * ClassName: TagService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/17/星期四 8:36
 * @Version 1.0
 **/


import com.javabing.bilibili.dao.TagDao;
import com.javabing.bilibili.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    public Long addTag(Tag tag) {
        tagDao.addTag(tag);
        return tag.getId();
    }
}

