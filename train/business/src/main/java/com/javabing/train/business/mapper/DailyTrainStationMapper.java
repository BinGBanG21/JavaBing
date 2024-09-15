package com.javabing.train.business.mapper;/*
 * ClassName: DailyTrainStationMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 15:46
 * @Version 1.0
 **/

import com.javabing.train.business.domain.DailyTrainStation;
import com.javabing.train.business.domain.DailyTrainStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyTrainStationMapper {
    long countByExample(DailyTrainStationExample example);

    int deleteByExample(DailyTrainStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrainStation record);

    int insertSelective(DailyTrainStation record);

    List<DailyTrainStation> selectByExample(DailyTrainStationExample example);

    DailyTrainStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DailyTrainStation record, @Param("example") DailyTrainStationExample example);

    int updateByExample(@Param("record") DailyTrainStation record, @Param("example") DailyTrainStationExample example);

    int updateByPrimaryKeySelective(DailyTrainStation record);

    int updateByPrimaryKey(DailyTrainStation record);
}
