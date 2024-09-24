package com.javabing.train.business.controller;/*
 * ClassName: TestController
 * Package: com.javabing.train.business.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 10:43
 * @Version 1.0
 **/

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.javabing.train.business.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController  {

    @Resource
    private TestService testService;


    @SentinelResource("hello")
    @GetMapping("/hello")
    public String hello() throws InterruptedException{
        testService.hello2();
        return "Hello World! Business!";
    }

    @SentinelResource("hello1")
    @GetMapping("/hello1")
    public String hello1() throws InterruptedException {
                testService.hello2();
                return "Hello World! Business1!";
            }

}