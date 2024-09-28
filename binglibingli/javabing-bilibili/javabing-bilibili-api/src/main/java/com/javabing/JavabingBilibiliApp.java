package com.javabing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/*
 * ClassName: ${NAME}
 * Package: org.example
 * Description:
 * @Author WangBing
 * @Create 2024/9/28/星期六 19:23
 * @Version 1.0
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//没有配置数据库 启动会报错 暂时排除dataSource bean
public class JavabingBilibiliApp {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(JavabingBilibiliApp.class, args);
    }
}