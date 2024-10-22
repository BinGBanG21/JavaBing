package com.javabing.bilibili.domain;/*
 * ClassName: Content
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/22/星期二 8:23
 * @Version 1.0
 **/


import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class Content {

    private Long id;

    private JSONObject contentDetail;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JSONObject getContentDetail() {
        return contentDetail;
    }

    public void setContentDetail(JSONObject contentDetail) {
        this.contentDetail = contentDetail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
