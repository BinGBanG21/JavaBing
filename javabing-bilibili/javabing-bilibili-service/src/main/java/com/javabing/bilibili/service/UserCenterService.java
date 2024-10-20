package com.javabing.bilibili.service;/*
 * ClassName: UserCenterService
 * Package: com.javabing.bilibili.service
 * Description:
 * @Author WangBing
 * @Create 2024/10/20/星期日 8:51
 * @Version 1.0
 **/

import com.javabing.bilibili.dao.UserCenterDao;
import com.javabing.bilibili.domain.*;
import com.javabing.bilibili.domain.constant.UserCollectionGroupConstant;
import com.javabing.bilibili.domain.exception.ConditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserCenterService {

    @Autowired
    private UserCenterDao userCenterDao;

    @Autowired
    private UserService userService;

    @Autowired
    private VideoService videoService;

    @Value("${fdfs.http.storage-addr}")
    private String fastdfsUrl;

    public Map<String, Integer> getUserCenterVideoAreas(Long userId) {
        List<VideoArea> videoAreas = userCenterDao.getUserCenterVideoAreas(userId);
        return videoAreas.stream().
                collect(Collectors.toMap(VideoArea::getArea,VideoArea::getCount));
    }

    public PageResult<Video> pageListUserVideos(Integer size, Integer no,
                                                String area, Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (no-1)*size);
        params.put("limit", size);
        params.put("area" , area);
        params.put("userId", userId);
        Integer total = userCenterDao.pageCountUserCenterVideos(params);
        List<Video> list = new ArrayList<>();
        if(total > 0){
            list = userCenterDao.pageListUserCenterVideos(params);
            //视频封面相对路径转为绝对路径
            list.forEach(video -> video.setThumbnail(fastdfsUrl + video.getThumbnail()));
            //计算播放量和弹幕量
            list = videoService.getVideoCount(list);
        }
        return new PageResult<>(total, list);
    }

    public Map<String, Object> pageListUserCenterCollections(Integer size, Integer no,
                                                             Long userId, Long groupId) {
        //查询分组菜单
        List<CollectionGroup> groups = userCenterDao.countUserCenterCollectionGroups(userId);
        //分页查询收藏视频
        Map<String, Object> params = new HashMap<>();
        params.put("start", (no-1)*size);
        params.put("limit", size);
        params.put("userId", userId);
        params.put("groupId", groupId);
        Integer total = userCenterDao.pageCountUserCollections(params);
        List<VideoCollection> list = new ArrayList<>();
        if(total > 0){
            list = userCenterDao.pageListUserCollections(params);
            //查询收藏视频对应的信息
            if(!list.isEmpty()){
                Set<Long> videoIdSet = list.stream().map(VideoCollection :: getVideoId)
                        .collect(Collectors.toSet());
                List<Video> videoList = userCenterDao.getVideoInfoByIds(videoIdSet);
                videoList.forEach(video -> video.setThumbnail(fastdfsUrl + video.getThumbnail()));
                list.forEach(item -> videoList.forEach(video -> {
                    if(video.getId().equals(item.getVideoId())){
                        item.setVideoInfo(video);
                    }
                }));
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("pageResult", new PageResult<>(total, list));
        result.put("groups",groups);
        return result;
    }
    public void addUserCollectionGroups(VideoCollectionGroup videoCollectionGroup) {
        videoCollectionGroup.setCreateTime(new Date());
        videoCollectionGroup.setType(UserCollectionGroupConstant.TYPE_USER);
        userCenterDao.addUserCollectionGroups(videoCollectionGroup);
    }

}

