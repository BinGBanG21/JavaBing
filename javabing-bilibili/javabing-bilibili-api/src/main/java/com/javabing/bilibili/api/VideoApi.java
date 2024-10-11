package com.javabing.bilibili.api;/*
 * ClassName: VideoApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/11/星期五 21:17
 * @Version 1.0
 **/

import com.javabing.bilibili.api.support.UserSupport;
import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.domain.PageResult;
import com.javabing.bilibili.domain.Video;
import com.javabing.bilibili.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class VideoApi {

    @Autowired
    private VideoService videoService;

    @Autowired
    private UserSupport userSupport;

    @PostMapping("/videos")
    public JsonResponse<String> addVideos(@RequestBody Video video){
        Long userId = userSupport.getCurrentUserId();
        video.setUserId(userId);
        videoService.addVideos(video);
        return JsonResponse.success();
    }

    @GetMapping("videos")
    public JsonResponse<PageResult<Video>> pageListVideos(Integer size, Integer no, String area){
        PageResult<Video> result = videoService.pageListVideos(size, no ,area);
        return new JsonResponse<>(result);
    }

    @GetMapping("/video-slices")
    public void viewVideoOnlineBySlices(HttpServletRequest request,
                                        HttpServletResponse response,
                                        String url) throws Exception{
        videoService.viewVideoOnlineBySlices(request, response, url);
    }


}
