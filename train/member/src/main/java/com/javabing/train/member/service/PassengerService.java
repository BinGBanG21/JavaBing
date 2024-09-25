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
import com.javabing.train.member.domain.Member;
import com.javabing.train.member.domain.MemberExample;
import com.javabing.train.member.domain.Passenger;
import com.javabing.train.member.domain.PassengerExample;
import com.javabing.train.member.enums.PassengerTypeEnum;
import com.javabing.train.member.mapper.MemberMapper;
import com.javabing.train.member.mapper.PassengerMapper;
import com.javabing.train.member.req.PassengerQueryReq;
import com.javabing.train.member.req.PassengerSaveReq;
import com.javabing.train.member.resp.PassengerQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PassengerService {

    private static final Logger LOG = LoggerFactory.getLogger(PassengerService.class);


    @Resource
    private PassengerMapper passengerMapper;

    @Resource
    private MemberMapper memberMapper;


    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        //创建domain实体 并且执行sql语句
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        //对其他属性赋值 如果没有id证明是新增 有id证明是编辑
        if (ObjectUtil.isNull(req.getId())) {
            passenger.setId(SnowUtil.getSnowflakeNextId());
            passenger.setMemberId(LoginMemberContext.getId());
            passenger.setCreateTime(now);
            passenger.setUpdateTime(now);
            passengerMapper.insert(passenger);
        } else {
            passenger.setUpdateTime(now);
            passengerMapper.updateByPrimaryKey(passenger);
        }


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

    public void delete(long id) {
        passengerMapper.deleteByPrimaryKey(id);
    }

    /**
     * +     * 查询我的所有乘客
     * +
     */
    public List<PassengerQueryResp> queryMine() {
        PassengerExample passengerExample = new PassengerExample();
        passengerExample.setOrderByClause("name asc");
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        criteria.andMemberIdEqualTo(LoginMemberContext.getId());
        List<Passenger> list = passengerMapper.selectByExample(passengerExample);
        return BeanUtil.copyToList(list, PassengerQueryResp.class);
    }


    /**
     * +     * 初始化乘客，如果没有张三，就增加乘客张三，李四、王五同理，防止线上体验时乘客被删光
     * +
     */
    public void init() {
        DateTime now = DateTime.now();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo("13000000000");
        List<Member> memberList = memberMapper.selectByExample(memberExample);
        Member member = memberList.get(0);

        List<Passenger> passengerList = new ArrayList<>();

        List<String> nameList = Arrays.asList("张三", "李四", "王五");
        for (String s : nameList) {
            Passenger passenger = new Passenger();
            passenger.setId(SnowUtil.getSnowflakeNextId());
            passenger.setMemberId(member.getId());
            passenger.setName(s);
            passenger.setIdCard("123456789123456789");
            passenger.setType(PassengerTypeEnum.ADULT.getCode());
            passenger.setCreateTime(now);
            passenger.setUpdateTime(now);
            passengerList.add(passenger);
        }

        for (Passenger passenger : passengerList) {
            PassengerExample passengerExample = new PassengerExample();
            passengerExample.createCriteria().andNameEqualTo(passenger.getName());
            long l = passengerMapper.countByExample(passengerExample);
            if (l == 0) {
                passengerMapper.insert(passenger);
            }
        }
    }
}
