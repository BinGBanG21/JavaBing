package com.javabing.train.business.service;/*
 * ClassName: TestService
 * Package: com.javabing.train.business.service
 * Description:
 * @Author WangBing
 * @Create 2024/9/24/星期二 14:15
 * @Version 1.0
 **/

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource("hello2")
    public void hello2() throws InterruptedException {
        Thread.sleep(500);
    }
}
