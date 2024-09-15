package com.javabing.train.business.req;/*
 * ClassName: DailyTrainQueryReq
 * Package: com.javabing.train.business.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 8:16
 * @Version 1.0
 **/

import com.javabing.train.common.req.PageReq;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DailyTrainQueryReq extends PageReq {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String code;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DailyTrainQueryReq{" +
                "date=" + date +
                ", code='" + code + '\'' +
                "} " + super.toString();
    }
}
