package com.javabing.train.business.controller;/*
 * ClassName: DailyTrainTicketController
 * Package: com.javabing.train.business.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/17/星期二 19:28
 * @Version 1.0
 **/

import com.javabing.train.business.req.DailyTrainTicketQueryReq;
import com.javabing.train.business.resp.DailyTrainTicketQueryResp;
import com.javabing.train.business.service.DailyTrainTicketService;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(list);
    }

}

