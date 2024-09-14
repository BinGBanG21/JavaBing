package com.javabing.train.batch.controller;/*
 * ClassName: TestController
 * Package: com.javabing.train.batch.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 20:10
 * @Version 1.0
 **/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World! Batch!";
    }
}
