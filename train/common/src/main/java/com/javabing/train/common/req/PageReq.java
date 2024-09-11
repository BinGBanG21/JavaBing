package com.javabing.train.common.req;/*
 * ClassName: PageReq
 * Package: com.javabing.train.common.req
 * Description:
 * @Author WangBing
 * @Create 2024/9/11/星期三 20:34
 * @Version 1.0
 **/

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class PageReq {

    @NotNull(message = "【页码】不能为空")
    private Integer page;

    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 100, message = "【每页条数】不能超过100")
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
