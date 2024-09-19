package com.javabing.train.member.req;/*
 * ClassName: TicketQueryReq
 * Package: com.javabing.train.member.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/19/星期四 14:19
 * @Version 1.0
 **/


import com.javabing.train.common.req.PageReq;

public class TicketQueryReq extends PageReq {

    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "TicketQueryReq{" +
                "memberId=" + memberId +
                "} " + super.toString();
    }
}

