package com.javabing.train.member.req;/*
 * ClassName: MemberRegisterReq
 * Package: com.javabing.train.member.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/7/星期六 21:51
 * @Version 1.0
 **/
import jakarta.validation.constraints.NotBlank;

public class MemberRegisterReq {

    @NotBlank(message = "【手机号】不能为空")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
