package com.javabing.bilibili.service;/*
 * ClassName: DemoService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:12
 * @Version 1.0
 **/

import com.javabing.bilibili.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public Long query(Long id){
        return demoDao.query(id);
    }
}
