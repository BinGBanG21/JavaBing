package com.javabing.train.business.mapper;/*
 * ClassName: DailyTrainMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 8:17
 * @Version 1.0
 **/

import com.javabing.train.business.domain.DailyTrain;
import com.javabing.train.business.domain.DailyTrainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyTrainMapper {
    long countByExample(DailyTrainExample example);

    int deleteByExample(DailyTrainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrain record);

    int insertSelective(DailyTrain record);

    List<DailyTrain> selectByExample(DailyTrainExample example);

    DailyTrain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DailyTrain record, @Param("example") DailyTrainExample example);

    int updateByExample(@Param("record") DailyTrain record, @Param("example") DailyTrainExample example);

    int updateByPrimaryKeySelective(DailyTrain record);

    int updateByPrimaryKey(DailyTrain record);
}
