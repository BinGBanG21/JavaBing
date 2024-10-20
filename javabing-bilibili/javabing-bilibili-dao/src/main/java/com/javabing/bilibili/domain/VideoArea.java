package com.javabing.bilibili.domain;/*
 * ClassName: VideoArea
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/20/星期日 8:49
 * @Version 1.0
 **/

public class VideoArea {

    private Long userId;

    private String area;

    private Integer count;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}


