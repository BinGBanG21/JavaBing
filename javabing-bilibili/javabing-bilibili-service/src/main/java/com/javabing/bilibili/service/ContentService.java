package com.javabing.bilibili.service;/*
 * ClassName: ContentService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/22/星期二 8:26
 * @Version 1.0
 **/


import com.javabing.bilibili.dao.ContentDao;
import com.javabing.bilibili.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    private ContentDao contentDao;
    public Long addContent(Content content) {
        contentDao.addContent(content);
        return content.getId();
    }
}

