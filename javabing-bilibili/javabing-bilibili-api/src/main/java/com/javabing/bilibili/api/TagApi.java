package com.javabing.bilibili.api;/*
 * ClassName: TagApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/17/星期四 8:34
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.domain.Tag;
import com.javabing.bilibili.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TagApi {

    @Autowired
    private TagService tagService;

    @PostMapping("/tags")
    public JsonResponse<Long> addTag(@RequestBody Tag tag){
        Long tagId = tagService.addTag(tag);
        return new JsonResponse<>(tagId);
    }



}
