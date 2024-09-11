package com.javabing.train.common.resp;/*
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

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
        final StringBuffer sb = new StringBuffer("MemberLoginResp{");
        sb.append("id=").append(id);
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
