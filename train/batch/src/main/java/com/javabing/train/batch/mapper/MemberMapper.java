package com.javabing.train.batch.mapper;/*
 * ClassName: MemberMapper
 * Package: com.javabing.train.batch.mapper
 * Description:
 * @Author WangBing
 * @Create 2024/9/14/星期六 20:21
 * @Version 1.0
 **/
import com.javabing.train.batch.domain.Member;
import com.javabing.train.batch.domain.MemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}