package com.javabing.train.business.controller;/*
 * ClassName: DailyTrainStationController
 * Package: com.javabing.train.business.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/25/星期三 18:07
 * @Version 1.0
 **/

import com.javabing.train.business.req.DailyTrainStationQueryAllReq;
import com.javabing.train.business.resp.DailyTrainStationQueryResp;
import com.javabing.train.business.service.DailyTrainStationService;
import com.javabing.train.common.resp.CommonResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/daily-train-station")
public class DailyTrainStationController {

    @Autowired
    private DailyTrainStationService dailyTrainStationService;

    @GetMapping("/query-by-train-code")
    public CommonResp<List<DailyTrainStationQueryResp>> queryByTrain(@Valid DailyTrainStationQueryAllReq req) {
        List<DailyTrainStationQueryResp> list = dailyTrainStationService.queryByTrain(req.getDate(), req.getTrainCode());
        return new CommonResp<>(list);
    }

}

