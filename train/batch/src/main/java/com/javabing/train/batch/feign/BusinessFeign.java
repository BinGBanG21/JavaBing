package com.javabing.train.batch.feign;/*
 * ClassName: BusinessFeign
 * Package: com.javabing.train.batch.feign
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 21:34
 * @Version 1.0
 **/

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("business")
// @FeignClient(name = "business", url = "http://127.0.0.1:8002/business")
public interface BusinessFeign {

    @GetMapping("/hello")
    String hello();
}
