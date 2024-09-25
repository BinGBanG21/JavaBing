package com.javabing.train.batch.feign;/*
 * ClassName: MemberFeign
 * Package: com.javabing.train.batch.feign
 * Description:
 * @Author WangBing
 * @Create 2024/9/25/星期三 21:42
 * @Version 1.0
 **/

import com.javabing.train.common.resp.CommonResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "member")
public interface MemberFeign {

    @GetMapping("/member/passenger/init")
    CommonResp init();

}