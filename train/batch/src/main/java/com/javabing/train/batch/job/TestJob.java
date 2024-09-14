package com.javabing.train.batch.job;/*
 * ClassName: TestJob
 * Package: com.javabing.train.batch.job
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 22:09
 * @Version 1.0
 **/

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TestJob TEST");
    }
}
