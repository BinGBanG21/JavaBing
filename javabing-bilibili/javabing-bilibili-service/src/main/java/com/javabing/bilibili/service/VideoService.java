package com.javabing.bilibili.service;/*
 * ClassName: VideoService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/11/星期五 21:20
 * @Version 1.0
 **/

import com.javabing.bilibili.dao.VideoDao;
import com.javabing.bilibili.domain.PageResult;
import com.javabing.bilibili.domain.Video;
import com.javabing.bilibili.domain.VideoTag;
import com.javabing.bilibili.domain.exception.ConditionException;
import com.javabing.bilibili.service.util.FastDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class VideoService {

    @Autowired
    private VideoDao videoDao;

    @Autowired
    private FastDFSUtil fastDFSUtil;

    @Transactional
    public void addVideos(Video video) {
        Date now = new Date();
        video.setCreateTime(new Date());
        videoDao.addVideos(video);
        Long videoId = video.getId();
        List<VideoTag> tagList = video.getVideoTagList();
        tagList.forEach(item -> {
            item.setCreateTime(now);
            item.setVideoId(videoId);
        });
        videoDao.batchAddVideoTags(tagList);
    }

    public PageResult<Video> pageListVideos(Integer size, Integer no, String area) {
        if(size == null || no == null){
            throw new ConditionException("参数异常！");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("start", (no-1)*size);
        params.put("limit", size);
        params.put("area" , area);
        List<Video> list = new ArrayList<>();
        Integer total = videoDao.pageCountVideos(params);
        if(total > 0){
            list = videoDao.pageListVideos(params);
        }
        return new PageResult<>(total, list);
    }

    public void viewVideoOnlineBySlices(HttpServletRequest request,
                                        HttpServletResponse response,
                                        String url) throws Exception{
        fastDFSUtil.viewVideoOnlineBySlices(request, response, url);
    }
}
