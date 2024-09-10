package com.javabing.train.member.controller;/*
 * ClassName: PassengerController
 * Package: com.javabing.train.member.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/10/星期二 21:57
 * @Version 1.0
 **/

import com.javabing.train.common.resq.CommonResp;
import com.javabing.train.member.req.PassengerSaveReq;
import com.javabing.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    public PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new CommonResp<>();
    }
}
