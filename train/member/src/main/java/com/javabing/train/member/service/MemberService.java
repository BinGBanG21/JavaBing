package com.javabing.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.javabing.train.member.domain.Member;
import com.javabing.train.member.domain.MemberExample;
import com.javabing.train.member.mapper.MemberMapper;
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

    public long register(String mobile) {
        //校验数据库中本手机号码是否注册过
        MemberExample memberExample = new MemberExample();
        //创建校验条件
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        //如果存在就返回
        if (CollUtil.isNotEmpty(list)) {
            throw new RuntimeException("手机号已注册");
        }
        //不存在就插入到数据库中
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}