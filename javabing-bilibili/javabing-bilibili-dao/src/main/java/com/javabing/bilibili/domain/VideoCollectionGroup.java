package com.javabing.bilibili.domain;/*
 * ClassName: VideoCollectionGroup
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/20/星期日 8:50
 * @Version 1.0
 **/

import java.util.Date;

public class VideoCollectionGroup {

    private Long id;

    private Long userId;

    private String name;

    private String type;

    private Date createTime;

    private Date updateTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
