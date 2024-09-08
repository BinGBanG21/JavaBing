package com.javabing.train.member.controller;/*
 * ClassName: MemberController
 * Package: com.javabing.train.member.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/7/星期六 20:18
 * @Version 1.0
 **/

import com.javabing.train.common.resq.CommonResp;
import com.javabing.train.member.req.MemberRegisterReq;
import com.javabing.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        //拿到结果 进行统一返回类的封装
        int count = memberService.count();
        return new CommonResp<>(count);
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
        return new CommonResp<>(register);
    }
}