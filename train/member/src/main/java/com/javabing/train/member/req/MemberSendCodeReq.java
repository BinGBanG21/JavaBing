package com.javabing.train.member.req;/*
 * ClassName: MemberSendCodeReq
 * Package: com.javabing.train.member.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/9/星期一 13:35
 * @Version 1.0
 **/

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberSendCodeReq {

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^1\\d{10}$", message = "手机号码格式错误")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberSendCodeReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
