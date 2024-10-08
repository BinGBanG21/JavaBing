package com.javabing.train.batch.feign;/*
 * ClassName: BusinessFeign
 * Package: com.javabing.train.batch.feign
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 21:34
 * @Version 1.0
 **/

import com.javabing.train.common.resp.CommonResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;

@FeignClient(value = "business", fallback = BusinessFeignFallback.class)
// @FeignClient(name = "business", url = "http://127.0.0.1:8002/business")
public interface BusinessFeign {

    @GetMapping("business/hello")
    String hello();

    @GetMapping("business/admin/daily-train/gen-daily/{date}")
    CommonResp<Object> genDaily(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date);
}
