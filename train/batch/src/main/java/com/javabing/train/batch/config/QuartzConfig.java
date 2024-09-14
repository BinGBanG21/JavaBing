//package com.javabing.train.batch.config;/*
// * ClassName: QuartzConfig
// * Package: com.javabing.train.batch.config
// * Description:
// * @Author WangBing
// * @Create 2024/9/14/星期六 22:09
// * @Version 1.0
// **/
//
//import com.javabing.train.batch.job.TestJob;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//    /**
//     * 声明一个任务
//     * @return
//     */
//    @Bean
//    public JobDetail jobDetail() {
//        return JobBuilder.newJob(TestJob.class)
//                .withIdentity("TestJob", "test")
//                .storeDurably()
//                .build();
//    }
//
//    /**
//     * 声明一个触发器，什么时候触发这个任务
//     * @return
//     */
//    @Bean
//    public Trigger trigger() {
//        return TriggerBuilder.newTrigger()
//                .forJob(jobDetail())
//                .withIdentity("trigger", "trigger")
//                .startNow()
//                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
//                .build();
//    }
//}

