package com.javabing.train.business.controller.admin;/*
 * ClassName: TrainAdminController
 * Package: com.javabing.train.business.controller.admin
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 12:59
 * @Version 1.0
 **/

import com.javabing.train.business.req.TrainQueryReq;
import com.javabing.train.business.req.TrainSaveReq;
import com.javabing.train.business.resp.TrainQueryResp;
import com.javabing.train.business.service.TrainService;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/train")
public class TrainAdminController {

    @Resource
    private TrainService trainService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody TrainSaveReq req) {
        trainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req) {
        PageResp<TrainQueryResp> list = trainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        trainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResp>> queryList() {
        List<TrainQueryResp> list = trainService.queryAll();
        return new CommonResp<>(list);
    }

}

