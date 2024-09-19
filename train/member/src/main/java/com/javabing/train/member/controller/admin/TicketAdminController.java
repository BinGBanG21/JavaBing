package com.javabing.train.member.controller.admin;/*
 * ClassName: TicketAdminController
 * Package: com.javabing.train.member.controller.admin
 * Description:
 * @Author WangBing
 * @Create 2024/9/19/星期四 14:16
 * @Version 1.0
 **/

import com.javabing.train.common.context.LoginMemberContext;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.common.resp.PageResp;
import com.javabing.train.member.req.TicketQueryReq;
import com.javabing.train.member.req.TicketSaveReq;
import com.javabing.train.member.resp.TicketQueryResp;
import com.javabing.train.member.service.TicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ticket")
public class TicketAdminController {

    @Resource
    private TicketService ticketService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody TicketSaveReq req) {
        ticketService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TicketQueryResp>> queryList(@Valid TicketQueryReq req) {
        PageResp<TicketQueryResp> list = ticketService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return new CommonResp<>();
    }

}

