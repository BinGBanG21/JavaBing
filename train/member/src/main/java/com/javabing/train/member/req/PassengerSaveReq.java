package com.javabing.train.member.req;/*
 * ClassName: PassengerSaveReq
 * Package: com.javabing.train.member.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/10/星期二 21:34
 * @Version 1.0
 **/

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PassengerSaveReq {
    private Long id;

    @NotNull(message = "【会员id】不能为空")
    private Long memberId;

    @NotNull(message = "【名字】不能为空")
    private String name;

    @NotNull(message = "【身份证号ze】不能为空")
    private String idCard;

    @NotNull(message = "【旅客类型】不能为空")
    private String type;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", name=").append(name);
        sb.append(", idCard=").append(idCard);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}

