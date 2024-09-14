package com.javabing.train.batch.config;/*
 * ClassName: SpringMvcConfig
 * Package: com.javabing.train.batch.config
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 22:41
 * @Version 1.0
 **/

import com.javabing.train.common.interceptor.LogInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**");

    }
}
