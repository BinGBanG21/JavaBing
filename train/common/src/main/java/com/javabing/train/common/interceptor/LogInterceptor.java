package com.javabing.train.common.interceptor;/*
 * ClassName: LogInterceptor
 * Package: com.javabing.train.common.interceptor
 * Description:
 * @Author WangBing
 * @Create 2024/9/11/星期三 10:02
 * @Version 1.0
 **/

import cn.hutool.core.util.RandomUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 日志拦截器
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 增加日志流水号
        MDC.put("LOG_ID", System.currentTimeMillis() + RandomUtil.randomString(3));
        return true;
    }

}