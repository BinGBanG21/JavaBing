package com.javabing.train.business.mapper;/*
 * ClassName: DailyTrainSeatMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/15/星期日 18:49
 * @Version 1.0
 **/

import com.javabing.train.business.domain.DailyTrainSeat;
import com.javabing.train.business.domain.DailyTrainSeatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyTrainSeatMapper {
    long countByExample(DailyTrainSeatExample example);

    int deleteByExample(DailyTrainSeatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrainSeat record);

    int insertSelective(DailyTrainSeat record);

    List<DailyTrainSeat> selectByExample(DailyTrainSeatExample example);

    DailyTrainSeat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DailyTrainSeat record, @Param("example") DailyTrainSeatExample example);

    int updateByExample(@Param("record") DailyTrainSeat record, @Param("example") DailyTrainSeatExample example);

    int updateByPrimaryKeySelective(DailyTrainSeat record);

    int updateByPrimaryKey(DailyTrainSeat record);
}
