package com.javabing.train.batch.controller;/*
 * ClassName: TestController
 * Package: com.javabing.train.batch.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 20:10
 * @Version 1.0
 **/

import com.javabing.train.batch.feign.BusinessFeign;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

            @Resource
    BusinessFeign businessFeign;

    @GetMapping("/hello")
    public String hello() {
        String businessHello = businessFeign.hello();
                LOG.info(businessHello);
        return "Hello World! Batch!";
    }
}
