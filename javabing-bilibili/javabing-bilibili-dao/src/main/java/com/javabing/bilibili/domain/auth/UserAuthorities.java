package com.javabing.bilibili.domain.auth;/*
 * ClassName: UserAuthorities
 * Package: com.javabing.bilibili.domain.auth
 * Description:
 * @Author WangBing
 * @Create 2024/10/8/星期二 20:36
 * @Version 1.0
 **/

import java.util.List;

public class UserAuthorities {

    List<AuthRoleElementOperation> roleElementOperationList;

    List<AuthRoleMenu> roleMenuList;

    public List<AuthRoleElementOperation> getRoleElementOperationList() {
        return roleElementOperationList;
    }

    public void setRoleElementOperationList(List<AuthRoleElementOperation> roleElementOperationList) {
        this.roleElementOperationList = roleElementOperationList;
    }

    public List<AuthRoleMenu> getRoleMenuList() {
        return roleMenuList;
    }

    public void setRoleMenuList(List<AuthRoleMenu> roleMenuList) {
        this.roleMenuList = roleMenuList;
    }
}

