package com.javabing.train.member.req;/*
 * ClassName: PassengerQueryReq
 * Package: com.javabing.train.member.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/11/星期三 15:29
 * @Version 1.0
 **/

public class PassengerQueryReq {

    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PassengerQueryReq{");
        sb.append("memberId=").append(memberId);
        sb.append('}');
        return sb.toString();
    }
}
