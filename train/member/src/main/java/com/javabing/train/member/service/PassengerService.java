package com.javabing.train.member.service;/*
 * ClassName: PassengerService
 * Package: com.javabing.train.member.service
 * Description:
 * @Author WangBing
 * @Create 2024/9/10/星期二 21:35
 * @Version 1.0
 **/

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.javabing.train.common.util.SnowUtil;
import com.javabing.train.member.domain.Passenger;
import com.javabing.train.member.mapper.PassengerMapper;
import com.javabing.train.member.req.PassengerSaveReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {


    @Resource
    private PassengerMapper passengerMapper;


    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        //创建domain实体 并且执行sql语句
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        //对其他属性赋值 存入数据库中
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);

    }
}
