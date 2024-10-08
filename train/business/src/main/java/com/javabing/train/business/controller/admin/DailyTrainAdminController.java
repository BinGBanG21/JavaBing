package com.javabing.train.business.controller.admin;/*
 * ClassName: DailyTrainAdminController
 * Package: com.javabing.train.business.controller.admin
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 8:20
 * @Version 1.0
 **/

import com.javabing.train.business.req.DailyTrainQueryReq;
import com.javabing.train.business.req.DailyTrainSaveReq;
import com.javabing.train.business.resp.DailyTrainQueryResp;
import com.javabing.train.business.service.DailyTrainService;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

    @Resource
    private DailyTrainService dailyTrainService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/gen-daily/{date}")
    public CommonResp<Object> genDaily(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        dailyTrainService.genDaily(date);
        return new CommonResp<>();
    }
}
