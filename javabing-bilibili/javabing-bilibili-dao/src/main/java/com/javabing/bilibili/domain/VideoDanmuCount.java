package com.javabing.bilibili.domain;/*
 * ClassName: VideoDanmuCount
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/16/星期三 8:17
 * @Version 1.0
 **/

public class VideoDanmuCount {

    private Long videoId;

    private Integer count;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

