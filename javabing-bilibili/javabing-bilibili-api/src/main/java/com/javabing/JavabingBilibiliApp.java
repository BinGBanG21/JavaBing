package com.javabing;/*
 * ClassName: JavabingBilibiliApp
 * Package: com.javabing
 * Description:
 * @Author WangBing
 * @Create 2024/9/28/星期六 23:20
 * @Version 1.0
 **/


import com.javabing.bilibili.service.websocket.WebSocketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class JavabingBilibiliApp {

    public static void main(String[] args){
        ApplicationContext app = SpringApplication.run(JavabingBilibiliApp.class, args);
        WebSocketService.setApplicationContext(app);
    }

}
