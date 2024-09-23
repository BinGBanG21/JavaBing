package com.javabing.train.business.config;/*
 * ClassName: SpringMvcConfig
 * Package: com.javabing.train.business.config
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 20:55
 * @Version 1.0
 **/

import com.javabing.train.common.interceptor.LogInterceptor;
import com.javabing.train.common.interceptor.MemberInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LogInterceptor logInterceptor;

    @Resource
    MemberInterceptor memberInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(memberInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/hello"
                );
    }
}
