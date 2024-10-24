package com.javabing.bilibili.api;/*
 * ClassName: UserMomentsApi
 * Package: com.javabing.bilibili.api
 * Description:
 * @Author WangBing
 * @Create 2024/10/5/星期六 19:08
 * @Version 1.0
 **/


import com.javabing.bilibili.api.support.UserSupport;
import com.javabing.bilibili.domain.JsonResponse;
import com.javabing.bilibili.domain.PageResult;
import com.javabing.bilibili.domain.UserMoment;
import com.javabing.bilibili.domain.annotation.ApiLimitedRole;
import com.javabing.bilibili.domain.annotation.DataLimited;
import com.javabing.bilibili.domain.constant.AuthRoleConstant;
import com.javabing.bilibili.service.UserMomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMomentsApi {

    @Autowired
    private UserMomentsService userMomentsService;

    @Autowired
    private UserSupport userSupport;


    @ApiLimitedRole(limitedRoleCodeList = {AuthRoleConstant.ROLE_LV0})
//    @DataLimited
    @PostMapping("/user-moments")
    public JsonResponse<String> addUserMoments(@RequestBody UserMoment userMoment) throws Exception {
        Long userId = userSupport.getCurrentUserId();
        userMoment.setUserId(userId);
        userMomentsService.addUserMoments(userMoment);
        return JsonResponse.success();
    }

    @GetMapping("/user-subscribed-moments")
    public JsonResponse<List<UserMoment>> getUserSubscribedMoments(){
        Long userId = userSupport.getCurrentUserId();
        List<UserMoment> list = userMomentsService.getUserSubscribedMoments(userId);
        return new JsonResponse<>(list);
    }

    @GetMapping("/moments")
    public JsonResponse<PageResult<UserMoment>> pageListMoments(@RequestParam("size") Integer size,
                                                                @RequestParam("no") Integer no,
                                                                String type){
        Long userId = userSupport.getCurrentUserId();
        PageResult<UserMoment> list = userMomentsService.pageListMoments(size, no,
                userId, type);
        return new JsonResponse<>(list);
    }

}



