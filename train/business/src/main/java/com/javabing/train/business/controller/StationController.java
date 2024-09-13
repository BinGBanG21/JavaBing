package com.javabing.train.business.controller;/*
 * ClassName: StationController
 * Package: com.javabing.train.business.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 12:28
 * @Version 1.0
 **/

import com.javabing.train.business.req.StationQueryReq;
import com.javabing.train.business.req.StationSaveReq;
import com.javabing.train.business.resp.StationQueryResp;
import com.javabing.train.business.service.StationService;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {

    @Resource
    private StationService stationService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody StationSaveReq req) {
        stationService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<StationQueryResp>> queryList(@Valid StationQueryReq req) {
        PageResp<StationQueryResp> list = stationService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        stationService.delete(id);
        return new CommonResp<>();
    }

}