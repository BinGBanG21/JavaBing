package com.javabing.train.common.resp;/*
 * ClassName: PageResp
 * Package: com.javabing.train.common.resp
 * Description:
 * @Author WangBing
 * @Create 2024/9/11/星期三 20:48
 * @Version 1.0
 **/

import java.io.Serializable;
import java.util.List;

public class PageResp<T> implements Serializable {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 当前页的列表
     */
    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}