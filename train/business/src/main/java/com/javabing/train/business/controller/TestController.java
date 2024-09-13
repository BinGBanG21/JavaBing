package com.javabing.train.business.controller;/*
 * ClassName: TestController
 * Package: com.javabing.train.business.controller
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 10:43
 * @Version 1.0
 **/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World! Business!";
    }
}