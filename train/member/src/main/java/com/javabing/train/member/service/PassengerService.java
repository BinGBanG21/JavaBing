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
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.javabing.train.common.context.LoginMemberContext;
import com.javabing.train.common.util.SnowUtil;
import com.javabing.train.member.domain.Passenger;
import com.javabing.train.member.domain.PassengerExample;
import com.javabing.train.member.mapper.PassengerMapper;
import com.javabing.train.member.req.PassengerQueryReq;
import com.javabing.train.member.req.PassengerSaveReq;
import com.javabing.train.member.resp.PassengerQueryResp;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);

    }

    public List<PassengerQueryResp> queyrList(PassengerQueryReq req) {
        PassengerExample example = new PassengerExample();
        PassengerExample.Criteria criteria = example.createCriteria();
        //如果有值 证明是客户端的请求 进行id查询 没有值 就是后台管理系统自己在看
        if (ObjectUtil.isNotNull(req.getMemberId())) {
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        PageHelper.startPage(2, 2);
        List<Passenger> list = passengerMapper.selectByExample(example);
        return BeanUtil.copyToList(list, PassengerQueryResp.class);

    }
}
