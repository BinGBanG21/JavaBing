package com.javabing.train.business.req;/*
 * ClassName: TrainSeatQueryReq
 * Package: com.javabing.train.business.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 15:53
 * @Version 1.0
 **/

import com.javabing.train.common.req.PageReq;

public class TrainSeatQueryReq extends PageReq {

    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        return "TrainSeatQueryReq{" +
                "trainCode='" + trainCode + '\'' +
                "} " + super.toString();
    }
}
