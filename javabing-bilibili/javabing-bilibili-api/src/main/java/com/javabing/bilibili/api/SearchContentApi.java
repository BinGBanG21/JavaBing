package com.javabing.bilibili.api;/*
 * ClassName: SearchContentApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/24/星期四 18:33
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.domain.PageResult;
import com.javabing.bilibili.domain.Video;
import com.javabing.bilibili.service.SearchContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SearchContentApi {

    @Autowired
    private SearchContentService searchContentService;


    @GetMapping("/search-counts")
    public JsonResponse<Map<String, Object>> countBySearchTxt(String searchTxt){
        Map<String, Object> result = searchContentService.countBySearchTxt(searchTxt);
        return new JsonResponse<>(result);
    }

    @GetMapping("/search-videos")
    public JsonResponse<Page<Video>> pageListSearchVideos(@RequestParam String keyword,
                                                          @RequestParam Integer pageSize,
                                                          @RequestParam Integer pageNo,
                                                          @RequestParam String searchType){
        Page<Video> result = searchContentService.pageListSearchVideos(keyword, pageSize,
                pageNo, searchType);
        return new JsonResponse<>(result);
    }

}

