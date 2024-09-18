package com.javabing.train.business.controller;/*
 * ClassName: ConfirmOrderController
 * Package: com.javabing.train.business.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/18/星期三 15:15
 * @Version 1.0
 **/

import com.javabing.train.business.req.ConfirmOrderDoReq;
import com.javabing.train.business.service.ConfirmOrderService;
import com.javabing.train.common.resp.CommonResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    public CommonResp<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req) {
        confirmOrderService.doConfirm(req);
        return new CommonResp<>();
    }

}