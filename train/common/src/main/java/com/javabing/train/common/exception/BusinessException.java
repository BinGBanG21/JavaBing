package com.javabing.train.common.exception;/*
 * ClassName: BusinessException
 * Package: com.javabing.train.common.exception
 * Description:
 * @Author WangBing
 * @Create 2024/9/8/星期日 12:14
 * @Version 1.0
 **/


public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessExceptionEnum getE() {
        return e;
    }

    public void setE(BusinessExceptionEnum e) {
        this.e = e;
    }


    //重写exception的方法
    //让我们自定义的异常在打印的时候不计入堆栈
    //同时更容易看懂 不报一大堆堆栈错误信息
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
