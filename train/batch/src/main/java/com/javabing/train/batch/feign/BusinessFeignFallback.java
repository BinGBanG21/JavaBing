package com.javabing.train.batch.feign;/*
 * ClassName: BusinessFeignFallback
 * Package: com.javabing.train.batch.feign
 * Description:
 * @Author WangBing
 * @Create 2024/9/24/星期二 14:42
 * @Version 1.0
 **/


import com.javabing.train.common.resp.CommonResp;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BusinessFeignFallback implements BusinessFeign {
    @Override
    public String hello() {
        return "Fallback";
    }

    @Override
    public CommonResp<Object> genDaily(Date date) {
        return null;
    }
}
