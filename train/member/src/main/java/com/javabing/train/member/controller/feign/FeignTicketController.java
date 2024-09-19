package com.javabing.train.member.controller.feign;/*
 * ClassName: FeignTicketController
 * Package: com.javabing.train.member.controller.feign
 * Description:
 * @Author WangBing
 * @Create 2024/9/19/星期四 15:00
 * @Version 1.0
 **/

import com.javabing.train.common.req.MemberTicketReq;
import com.javabing.train.common.resp.CommonResp;
import com.javabing.train.member.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/feign/ticket")
public class FeignTicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody MemberTicketReq req) throws Exception {
        ticketService.save(req);
        return new CommonResp<>();
    }

}
