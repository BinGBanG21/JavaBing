package com.javabing.bilibili.dao;/*
 * ClassName: VideoDao
 * Package: com.javabing.bilibili.dao
 * Description:
 * @Author WangBing
 * @Create 2024/10/11/星期五 21:18
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.Video;
import com.javabing.bilibili.domain.VideoTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VideoDao {

    Integer addVideos(Video video);

    Integer batchAddVideoTags(List<VideoTag> videoTagList);

    Integer pageCountVideos(Map<String, Object> params);

    List<Video> pageListVideos(Map<String, Object> params);

}