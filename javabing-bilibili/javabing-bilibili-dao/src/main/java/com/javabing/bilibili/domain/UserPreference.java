package com.javabing.bilibili.domain;/*
 * ClassName: UserPreference
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:02
 * @Version 1.0
 **/

import java.util.Date;

public class UserPreference {

    private Long id;

    private Long userId;

    private Long videoId;

    private Float value;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

