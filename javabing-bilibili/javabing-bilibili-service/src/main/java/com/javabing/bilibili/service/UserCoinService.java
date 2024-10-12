package com.javabing.bilibili.service;/*
 * ClassName: UserCoinService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/12/星期六 12:52
 * @Version 1.0
 **/

import com.javabing.bilibili.dao.UserCoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserCoinService {

    @Autowired
    private UserCoinDao userCoinDao;

    public Integer getUserCoinsAmount(Long userId) {
        return userCoinDao.getUserCoinsAmount(userId);
    }

    public void updateUserCoinsAmount(Long userId, Integer amount) {
        Date updateTime = new Date();
        userCoinDao.updateUserCoinAmount(userId, amount, updateTime);
    }
}

