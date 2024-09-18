package com.javabing.train.business.controller.admin;/*
 * ClassName: ConfirmOrderAdminController
 * Package: com.javabing.train.business.controller.admin
 * Description:
 * @Author WangBing
 * @Create 2024/9/18/星期三 14:46
 * @Version 1.0
 **/

import com.javabing.train.common.context.LoginMemberContext;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import com.javabing.train.business.req.ConfirmOrderQueryReq;
import com.javabing.train.business.req.ConfirmOrderSaveReq;
import com.javabing.train.business.resp.ConfirmOrderQueryResp;
import com.javabing.train.business.service.ConfirmOrderService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/confirm-order")
public class ConfirmOrderAdminController {

    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody ConfirmOrderSaveReq req) {
        confirmOrderService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<ConfirmOrderQueryResp>> queryList(@Valid ConfirmOrderQueryReq req) {
        PageResp<ConfirmOrderQueryResp> list = confirmOrderService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        confirmOrderService.delete(id);
        return new CommonResp<>();
    }

}
