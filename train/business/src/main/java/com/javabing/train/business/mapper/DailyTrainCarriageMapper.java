package com.javabing.train.business.mapper;/*
 * ClassName: DailyTrainCarriageMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 18:36
 * @Version 1.0
 **/

import com.javabing.train.business.domain.DailyTrainCarriage;
import com.javabing.train.business.domain.DailyTrainCarriageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyTrainCarriageMapper {
    long countByExample(DailyTrainCarriageExample example);

    int deleteByExample(DailyTrainCarriageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrainCarriage record);

    int insertSelective(DailyTrainCarriage record);

    List<DailyTrainCarriage> selectByExample(DailyTrainCarriageExample example);

    DailyTrainCarriage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DailyTrainCarriage record, @Param("example") DailyTrainCarriageExample example);

    int updateByExample(@Param("record") DailyTrainCarriage record, @Param("example") DailyTrainCarriageExample example);

    int updateByPrimaryKeySelective(DailyTrainCarriage record);

    int updateByPrimaryKey(DailyTrainCarriage record);
}

