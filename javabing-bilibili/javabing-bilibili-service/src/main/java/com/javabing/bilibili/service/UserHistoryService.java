package com.javabing.bilibili.service;/*
 * ClassName: UserHistoryService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/23/星期三 12:27
 * @Version 1.0
 **/

import com.javabing.bilibili.dao.UserHistoryDao;
import com.javabing.bilibili.domain.PageResult;
import com.javabing.bilibili.domain.UserVideoHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserHistoryService {

    @Autowired
    private UserHistoryDao userHistoryDao;

    @Value("${fdfs.http.storage-addr}")
    private String fastdfsUrl;

    public PageResult<UserVideoHistory> pagListUserVideoHistory(Integer size,
                                                                Integer no,
                                                                Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (no-1)*size);
        params.put("limit", size);
        params.put("userId", userId);
        int total = userHistoryDao.pageCountUserVideoHistory(params);
        List<UserVideoHistory> list = new ArrayList<>();
        if(total > 0){
            list = userHistoryDao.pageListUserVideoHistory(params);
            list.forEach(history -> history.setThumbnail(fastdfsUrl + history.getThumbnail()));
        }
        return new PageResult<>(total, list);
    }
}

