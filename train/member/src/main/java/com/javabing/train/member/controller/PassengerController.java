package com.javabing.train.member.controller;/*
 * ClassName: PassengerController
 * Package: com.javabing.train.member.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/10/星期二 21:57
 * @Version 1.0
 **/

import com.javabing.train.common.context.LoginMemberContext;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.member.req.PassengerQueryReq;
import com.javabing.train.member.req.PassengerSaveReq;
import com.javabing.train.member.resp.PassengerQueryResp;
import com.javabing.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/query-list")
    public CommonResp<List<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        //从线程池中拿到值然后查询
        req.setMemberId(LoginMemberContext.getId());
        List<PassengerQueryResp> list = passengerService.queyrList(req);
        return new CommonResp<>(list);
    }
}
