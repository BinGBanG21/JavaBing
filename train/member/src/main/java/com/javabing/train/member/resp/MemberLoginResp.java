package com.javabing.train.member.resp;/*
 * ClassName: MemberLoginResp
 * Package: com.javabing.train.member.resp
 * Description:
 * @Author WangBing
 * @Create 2024/9/9/星期一 15:30
 * @Version 1.0
 **/

public class MemberLoginResp {
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
