package com.javabing.train.member.mapper;/*
 * ClassName: TicketMapper
 * Package: com.javabing.train.member.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/19/星期四 14:19
 * @Version 1.0
 **/

import com.javabing.train.member.domain.Ticket;
import com.javabing.train.member.domain.TicketExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TicketMapper {
    long countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}
