package com.javabing.train.batch.domain;/*
 * ClassName: Member
 * Package: com.javabing.train.batch.domain
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 20:19
 * @Version 1.0
 **/

public class Member {
    private Long id;

    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobile=").append(mobile);
        sb.append("]");
        return sb.toString();
    }
}