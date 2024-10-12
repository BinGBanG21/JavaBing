package com.javabing.bilibili.service.config;/*
 * ClassName: WebSocketConfig
 * Package: com.javabing.bilibili.service.config
 * Description:
 * @Author WangBing
 * @Create 2024/10/12/星期六 21:23
 * @Version 1.0
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
