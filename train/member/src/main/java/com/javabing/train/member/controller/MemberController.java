package com.javabing.train.member.controller;/*
 * ClassName: MemberController
 * Package: com.javabing.train.member.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/7/星期六 20:18
 * @Version 1.0
 **/

import com.javabing.train.common.resq.CommonResp;
import com.javabing.train.member.req.MemberLoginReq;
import com.javabing.train.member.req.MemberRegisterReq;
import com.javabing.train.member.req.MemberSendCodeReq;
import com.javabing.train.member.resp.MemberLoginResp;
import com.javabing.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }
}
