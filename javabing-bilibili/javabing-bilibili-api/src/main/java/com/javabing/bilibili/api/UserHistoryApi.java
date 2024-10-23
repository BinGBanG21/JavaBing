package com.javabing.bilibili.api;/*
 * ClassName: UserHistoryApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/23/星期三 12:25
 * @Version 1.0
 **/

import com.javabing.bilibili.api.support.UserSupport;
import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.domain.PageResult;
import com.javabing.bilibili.domain.UserVideoHistory;
import com.javabing.bilibili.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserHistoryApi {


    @Autowired
    private UserHistoryService userHistoryService;

    @Autowired
    private UserSupport userSupport;

    @GetMapping("/user-video-histories")
    public JsonResponse<PageResult<UserVideoHistory>> pagListUserVideoHistory(@RequestParam Integer size,
                                                                              @RequestParam Integer no){
        Long userId = userSupport.getCurrentUserId();
        PageResult<UserVideoHistory> result = userHistoryService.pagListUserVideoHistory(size,no,userId);
        return new JsonResponse<>(result);
    }

}
