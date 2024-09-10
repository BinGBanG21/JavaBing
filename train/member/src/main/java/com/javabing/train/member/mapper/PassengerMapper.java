package com.javabing.train.member.mapper;/*
 * ClassName: PassengerMapper
 * Package: com.javabing.train.member.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/10/星期二 19:43
 * @Version 1.0
 **/

import com.javabing.train.member.domain.Passenger;
import com.javabing.train.member.domain.PassengerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PassengerMapper {
    long countByExample(PassengerExample example);

    int deleteByExample(PassengerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Passenger record);

    int insertSelective(Passenger record);

    List<Passenger> selectByExample(PassengerExample example);

    Passenger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Passenger record, @Param("example") PassengerExample example);

    int updateByExample(@Param("record") Passenger record, @Param("example") PassengerExample example);

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);
}