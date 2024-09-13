package com.javabing.train.business.mapper;/*
 * ClassName: TrainCarriageMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 15:12
 * @Version 1.0
 **/

import com.javabing.train.business.domain.TrainCarriage;
import com.javabing.train.business.domain.TrainCarriageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainCarriageMapper {
    long countByExample(TrainCarriageExample example);

    int deleteByExample(TrainCarriageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrainCarriage record);

    int insertSelective(TrainCarriage record);

    List<TrainCarriage> selectByExample(TrainCarriageExample example);

    TrainCarriage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrainCarriage record, @Param("example") TrainCarriageExample example);

    int updateByExample(@Param("record") TrainCarriage record, @Param("example") TrainCarriageExample example);

    int updateByPrimaryKeySelective(TrainCarriage record);

    int updateByPrimaryKey(TrainCarriage record);
}
