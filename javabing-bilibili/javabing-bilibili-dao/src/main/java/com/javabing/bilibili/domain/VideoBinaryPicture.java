package com.javabing.bilibili.domain;/*
 * ClassName: VideoBinaryPicture
 * Package: com.javabing.bilibili.domain
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:03
 * @Version 1.0
 **/

import java.util.Date;

public class VideoBinaryPicture {

    private Long id;

    private Long videoId;

    private Integer frameNo;

    private String url;

    private Long videoTimestamp;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Integer getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(Integer frameNo) {
        this.frameNo = frameNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getVideoTimestamp() {
        return videoTimestamp;
    }

    public void setVideoTimestamp(Long videoTimestamp) {
        this.videoTimestamp = videoTimestamp;
    }
}

