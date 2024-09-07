package com.javabing.train.member.controller;/*
 * ClassName: MemberController
 * Package: com.javabing.train.member.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/7/星期六 20:18
 * @Version 1.0
 **/

import com.javabing.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public Integer count() {
        return memberService.count();
    }

    @PostMapping("/register")
    public long register(String mobile) {
        return memberService.register(mobile);
    }
}
