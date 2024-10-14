package com.javabing.bilibili.api;/*
 * ClassName: DemoApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 11:58
 * @Version 1.0
 **/


import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.domain.Video;
import com.javabing.bilibili.service.DemoService;
import com.javabing.bilibili.service.ElasticSearchService;
import com.javabing.bilibili.service.util.FastDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DemoApi {

    @Autowired
    private DemoService demoService;

    @Autowired
    private FastDFSUtil fastDFSUtil;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/query")
    public Long query(Long id){
        return demoService.query(id);
    }

    @GetMapping("/slices")
    public void slices(MultipartFile file) throws Exception {
        fastDFSUtil.convertFileToSlices(file);
    }

    @GetMapping("/es-videos")
    public JsonResponse<Video> getEsVideos(@RequestParam String keyword){
        Video video = elasticSearchService.getVideos(keyword);
        return new JsonResponse<>(video);
    }

}
