package com.javabing.train.business.controller.admin;/*
 * ClassName: DailyTrainSeatAdminController
 * Package: com.javabing.train.business.controller.admin
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 18:47
 * @Version 1.0
 **/

import com.javabing.train.common.context.LoginMemberContext;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import com.javabing.train.business.req.DailyTrainSeatQueryReq;
import com.javabing.train.business.req.DailyTrainSeatSaveReq;
import com.javabing.train.business.resp.DailyTrainSeatQueryResp;
import com.javabing.train.business.service.DailyTrainSeatService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-seat")
public class DailyTrainSeatAdminController {

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSeatSaveReq req) {
        dailyTrainSeatService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainSeatQueryResp>> queryList(@Valid DailyTrainSeatQueryReq req) {
        PageResp<DailyTrainSeatQueryResp> list = dailyTrainSeatService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainSeatService.delete(id);
        return new CommonResp<>();
    }

}

