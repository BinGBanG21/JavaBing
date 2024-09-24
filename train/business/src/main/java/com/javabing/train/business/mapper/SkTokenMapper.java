package com.javabing.train.business.mapper;/*
 * ClassName: SkTokenMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/24/星期二 15:09
 * @Version 1.0
 **/

import com.javabing.train.business.domain.SkToken;
import com.javabing.train.business.domain.SkTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkTokenMapper {
    long countByExample(SkTokenExample example);

    int deleteByExample(SkTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkToken record);

    int insertSelective(SkToken record);

    List<SkToken> selectByExample(SkTokenExample example);

    SkToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkToken record, @Param("example") SkTokenExample example);

    int updateByExample(@Param("record") SkToken record, @Param("example") SkTokenExample example);

    int updateByPrimaryKeySelective(SkToken record);

    int updateByPrimaryKey(SkToken record);
}
