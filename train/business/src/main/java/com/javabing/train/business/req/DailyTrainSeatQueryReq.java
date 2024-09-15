package com.javabing.train.business.req;/*
 * ClassName: DailyTrainSeatQueryReq
 * Package: com.javabing.train.business.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 18:49
 * @Version 1.0
 **/

import com.javabing.train.common.req.PageReq;

public class DailyTrainSeatQueryReq extends PageReq {

    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        return "DailyTrainSeatQueryReq{" +
                "trainCode='" + trainCode + '\'' +
                "} " + super.toString();
    }
}