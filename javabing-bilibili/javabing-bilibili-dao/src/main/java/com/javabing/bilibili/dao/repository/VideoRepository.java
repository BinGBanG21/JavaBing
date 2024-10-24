package com.javabing.bilibili.dao.repository;/*
 * ClassName: VideoRepository
 * Package: com.javabing.bilibili.dao.repository
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:01
 * @Version 1.0
 **/

import com.javabing.bilibili.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface VideoRepository extends ElasticsearchRepository<Video, Long> {

    Video findByTitleLike(String keyword);

    long countByTitleOrDescription(String titleKeyword, String DescriptionKeyword);

    Page<Video> findByTitleOrDescriptionOrderByViewCountDesc(String title, String description,
                                                             PageRequest pageRequest);

    Page<Video> findByTitleOrDescriptionOrderByCreateTimeDesc(String title, String description,
                                                              PageRequest pageRequest);

    Page<Video> findByTitleOrDescriptionOrderByDanmuCountDesc(String title, String description,
                                                              PageRequest pageRequest);
}