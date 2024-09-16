package com.javabing.train.business.mapper;/*
 * ClassName: DailyTrainTicketMapper
 * Package: com.javabing.train.business.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/16/星期一 11:13
 * @Version 1.0
 **/

import com.javabing.train.business.domain.DailyTrainTicket;
import com.javabing.train.business.domain.DailyTrainTicketExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyTrainTicketMapper {
    long countByExample(DailyTrainTicketExample example);

    int deleteByExample(DailyTrainTicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrainTicket record);

    int insertSelective(DailyTrainTicket record);

    List<DailyTrainTicket> selectByExample(DailyTrainTicketExample example);

    DailyTrainTicket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DailyTrainTicket record, @Param("example") DailyTrainTicketExample example);

    int updateByExample(@Param("record") DailyTrainTicket record, @Param("example") DailyTrainTicketExample example);

    int updateByPrimaryKeySelective(DailyTrainTicket record);

    int updateByPrimaryKey(DailyTrainTicket record);
}
