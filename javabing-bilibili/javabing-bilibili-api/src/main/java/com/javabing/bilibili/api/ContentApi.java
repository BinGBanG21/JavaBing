package com.javabing.bilibili.api;/*
 * ClassName: ContentApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/22/星期二 8:21
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.Content;
import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentApi {

    @Autowired
    private ContentService contentService;

    @PostMapping("/contents")
    public JsonResponse<Long> addContent(@RequestBody Content content){
        Long contentId = contentService.addContent(content);
        return new JsonResponse<>(contentId);
    }
}
