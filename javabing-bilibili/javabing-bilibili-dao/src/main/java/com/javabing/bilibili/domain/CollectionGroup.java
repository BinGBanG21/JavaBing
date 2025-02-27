package com.javabing.bilibili.domain;/*
 * ClassName: CollectionGroup
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/20/星期日 8:48
 * @Version 1.0
 **/

public class CollectionGroup {

    private Long groupId;

    private String groupName;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

