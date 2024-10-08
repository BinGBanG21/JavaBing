package com.javabing.bilibili.domain.auth;/*
 * ClassName: AuthMenu
 * Package: com.javabing.bilibili.domain.auth
 * Description:
 * @Author WangBing
 * @Create 2024/10/8/星期二 20:33
 * @Version 1.0
 **/

import java.util.Date;

public class AuthMenu {

    private Long id;

    private String name;

    private String code;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

