package com.javabing.bilibili.domain;/*
 * ClassName: UserFollowingCount
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/20/星期日 8:49
 * @Version 1.0
 **/

public class UserFollowingCount {

    private Long groupId;

    private Integer count;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

