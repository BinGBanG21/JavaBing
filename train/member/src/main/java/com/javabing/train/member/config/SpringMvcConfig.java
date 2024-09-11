package com.javabing.train.member.config;/*
 * ClassName: SpringMvcConfig
 * Package: com.javabing.train.member.config
 * Description:
 * @Author WangBing
 * @Create 2024/9/11/星期三 8:41
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

    LogInterceptor logInterceptor;

    @Resource
    MemberInterceptor memberInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
        registry.addInterceptor(memberInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/member/hello",
                        "/member/member/send-code",
                        "/member/member/login"
                );
    }
}