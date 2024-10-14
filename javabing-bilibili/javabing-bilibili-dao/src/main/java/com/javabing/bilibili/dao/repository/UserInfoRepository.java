package com.javabing.bilibili.dao.repository;/*
 * ClassName: UserInfoRepository
 * Package: com.javabing.bilibili.dao.repository
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:01
 * @Version 1.0
 **/


import com.javabing.bilibili.domain.UserInfo;
import com.javabing.bilibili.domain.Video;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserInfoRepository extends ElasticsearchRepository<UserInfo, Long> {

}
