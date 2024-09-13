package com.javabing.train.business.mapper;/*
 * ClassName: TrainStationMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/13/星期五 15:02
 * @Version 1.0
 **/

import com.javabing.train.business.domain.TrainStation;
import com.javabing.train.business.domain.TrainStationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainStationMapper {
    long countByExample(TrainStationExample example);

    int deleteByExample(TrainStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrainStation record);

    int insertSelective(TrainStation record);

    List<TrainStation> selectByExample(TrainStationExample example);

    TrainStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrainStation record, @Param("example") TrainStationExample example);

    int updateByExample(@Param("record") TrainStation record, @Param("example") TrainStationExample example);

    int updateByPrimaryKeySelective(TrainStation record);

    int updateByPrimaryKey(TrainStation record);
}
