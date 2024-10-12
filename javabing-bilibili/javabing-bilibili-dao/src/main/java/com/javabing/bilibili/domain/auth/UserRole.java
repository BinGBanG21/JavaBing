package com.javabing.bilibili.domain.auth;/*
 * ClassName: UserRole
 * Package: com.javabing.bilibili.domain.auth
 * Description:
 * @Author WangBing
 * @Create 2024/10/8/星期二 20:36
 * @Version 1.0
 **/

import java.util.Date;

public class UserRole {

    private Long id;

    private Long userId;

    private Long roleId;

    private String roleName;

    private String roleCode;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
