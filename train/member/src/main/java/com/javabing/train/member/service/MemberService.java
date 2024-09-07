package com.javabing.train.member.service;/*
 * ClassName: MemberService
 * Package: com.javabing.train.member.service
 * Description:
 * @Author WangBing
 * @Create 2024/9/7/星期六 20:12
 * @Version 1.0
 **/

import com.javabing.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return memberMapper.count();
    }

}
