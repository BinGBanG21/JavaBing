package com.javabing.train.business.dto;/*
 * ClassName: ConfirmOrderMQDto
 * Package: com.javabing.train.business.dto
 * Description:
 * @Author WangBing
 * @Create 2024/9/25/星期三 13:05
 * @Version 1.0
 **/


import java.util.Date;

public class ConfirmOrderMQDto {
    /**
     * 日志流程号，用于同转异时，用同一个流水号
     */
    private String logId;

    /**
     * 日期
     */
    private Date date;

    /**
     * 车次编号
     */
    private String trainCode;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConfirmOrderMQDto{");
        sb.append("logId=").append(logId);
        sb.append(", date=").append(date);
        sb.append(", trainCode='").append(trainCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

