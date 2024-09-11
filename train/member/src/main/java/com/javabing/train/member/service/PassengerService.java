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
import com.github.pagehelper.PageInfo;
import com.javabing.train.common.context.LoginMemberContext;
import com.javabing.train.common.resp.PageResp;
import com.javabing.train.common.util.SnowUtil;
import com.javabing.train.member.domain.Passenger;
import com.javabing.train.member.domain.PassengerExample;
import com.javabing.train.member.mapper.PassengerMapper;
import com.javabing.train.member.req.PassengerQueryReq;
import com.javabing.train.member.req.PassengerSaveReq;
import com.javabing.train.member.resp.PassengerQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private static final Logger LOG = LoggerFactory.getLogger(PassengerService.class);


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

    public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req) {
        PassengerExample PassengerExample = new PassengerExample();
        PassengerExample.setOrderByClause("id desc");
        PassengerExample.Criteria criteria = PassengerExample.createCriteria();
        //如果有值 证明是客户端的请求 进行id查询 没有值 就是后台管理系统自己在看
        if (ObjectUtil.isNotNull(req.getMemberId())) {
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Passenger> passengerList = passengerMapper.selectByExample(PassengerExample);
        PageInfo<Passenger> pageInfo = new PageInfo<>(passengerList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<PassengerQueryResp> list = BeanUtil.copyToList(passengerList, PassengerQueryResp.class);

        PageResp<PassengerQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;

    }
}
