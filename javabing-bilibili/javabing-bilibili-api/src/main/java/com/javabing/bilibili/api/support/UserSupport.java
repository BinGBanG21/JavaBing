package com.javabing.bilibili.api.support;/*
 * ClassName: UserSupport
 * Package: com.javabing.bilibili.api.support
 * Description:
 * @Author WangBing
 * @Create 2024/10/4/星期五 11:39
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.exception.ConditionException;
import com.javabing.bilibili.service.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class UserSupport {

    public Long getCurrentUserId(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        String token = requestAttributes.getRequest().getHeader("token");
        Long userId = TokenUtil.verifyToken(token);
        if(userId < 0){
            throw new ConditionException("非法用户！");
        }
        return userId;
    }
}
