package com.javabing.train.business.feign;/*
 * ClassName: MemberFeign
 * Package: com.javabing.train.business.feign
 * Description:
 * @Author WangBing
 * @Create 2024/9/19/星期四 15:03
 * @Version 1.0
 **/

import com.javabing.train.common.req.MemberTicketReq;
import com.javabing.train.common.resp.CommonResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

// @FeignClient("member")
@FeignClient(name = "member", url = "http://127.0.0.1:8001")
public interface MemberFeign {

    @GetMapping("/member/feign/ticket/save")
    CommonResp<Object> save(@RequestBody MemberTicketReq req);

}
