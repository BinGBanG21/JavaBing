package com.javabing.train.business.service;/*
 * ClassName: SkTokenService
 * Package: com.javabing.train.business.service
 * Description:
 * @Author WangBing
 * @Create 2024/9/24/星期二 15:13
 * @Version 1.0
 **/

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javabing.train.business.domain.SkToken;
import com.javabing.train.business.domain.SkTokenExample;
import com.javabing.train.business.mapper.SkTokenMapper;
import com.javabing.train.business.req.SkTokenQueryReq;
import com.javabing.train.business.req.SkTokenSaveReq;
import com.javabing.train.business.resp.SkTokenQueryResp;
import com.javabing.train.common.resp.PageResp;
import com.javabing.train.common.util.SnowUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkTokenService {

    private static final Logger LOG = LoggerFactory.getLogger(SkTokenService.class);

    @Resource
    private SkTokenMapper skTokenMapper;

    public void save(SkTokenSaveReq req) {
        DateTime now = DateTime.now();
        SkToken skToken = BeanUtil.copyProperties(req, SkToken.class);
        if (ObjectUtil.isNull(skToken.getId())) {
            skToken.setId(SnowUtil.getSnowflakeNextId());
            skToken.setCreateTime(now);
            skToken.setUpdateTime(now);
            skTokenMapper.insert(skToken);
        } else {
            skToken.setUpdateTime(now);
            skTokenMapper.updateByPrimaryKey(skToken);
        }
    }

    public PageResp<SkTokenQueryResp> queryList(SkTokenQueryReq req) {
        SkTokenExample skTokenExample = new SkTokenExample();
        skTokenExample.setOrderByClause("id desc");
        SkTokenExample.Criteria criteria = skTokenExample.createCriteria();

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<SkToken> skTokenList = skTokenMapper.selectByExample(skTokenExample);

        PageInfo<SkToken> pageInfo = new PageInfo<>(skTokenList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<SkTokenQueryResp> list = BeanUtil.copyToList(skTokenList, SkTokenQueryResp.class);

        PageResp<SkTokenQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void delete(Long id) {
        skTokenMapper.deleteByPrimaryKey(id);
    }
}

