package com.javabing.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.javabing.train.common.exception.BusinessException;
import com.javabing.train.common.exception.BusinessExceptionEnum;
import com.javabing.train.common.util.SnowUtil;
import com.javabing.train.member.domain.Member;
import com.javabing.train.member.domain.MemberExample;
import com.javabing.train.member.mapper.MemberMapper;
import com.javabing.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        //校验数据库中本手机号码是否注册过
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        //创建校验条件
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        //如果存在就返回
        if (CollUtil.isNotEmpty(list)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        //不存在就插入到数据库中
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}