package com.javabing.bilibili.domain.exception;/*
 * ClassName: ConditionException
 * Package: com.javabing.bilibili.domain.exception
 * Description:
 * @Author WangBing
 * @Create 2024/9/30/星期一 14:55
 * @Version 1.0
 **/

public class ConditionException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String code;

    public ConditionException(String code, String name){
        super(name);
        this.code = code;
    }

    public ConditionException(String name){
        super(name);
        code = "500";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
