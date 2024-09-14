package com.javabing.train.batch.job;/*
 * ClassName: SpringBootTestJob
 * Package: com.javabing.train.batch.job
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 21:40
 * @Version 1.0
 **/

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 适合单体应用，不适合集群
 * 没法实时更改定时任务状态和策略
 */
@Component
@EnableScheduling
public class SpringBootTestJob {

    @Scheduled(cron = "0/5 * * * * ?")
    private void test() {
        // 增加分布式锁，解决集群问题
        System.out.println("SpringBootTestJob TEST");
    }
}