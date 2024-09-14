package com.javabing.train.batch.job;/*
 * ClassName: TestJob
 * Package: com.javabing.train.batch.job
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 22:09
 * @Version 1.0
 **/

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TestJob TEST开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestJob TEST结束");
    }
}
