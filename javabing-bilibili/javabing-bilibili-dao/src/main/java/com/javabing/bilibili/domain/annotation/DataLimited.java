package com.javabing.bilibili.domain.annotation;/*
 * ClassName: DataLimited
 * Package: com.javabing.bilibili.domain.annotation
 * Description:
 * @Author WangBing
 * @Create 2024/10/9/星期三 11:21
 * @Version 1.0
 **/

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Component
public @interface DataLimited {

}
