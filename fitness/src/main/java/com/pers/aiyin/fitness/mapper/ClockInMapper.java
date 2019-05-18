package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.ClockIn;
import com.pers.aiyin.fitness.entity.ClockInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClockInMapper {
    long countByExample(ClockInExample example);

    int deleteByExample(ClockInExample example);

    int deleteByPrimaryKey(Integer clockInId);

    int insert(ClockIn record);

    int insertSelective(ClockIn record);

    List<ClockIn> selectByExample(ClockInExample example);

    ClockIn selectByPrimaryKey(Integer clockInId);

    int updateByExampleSelective(@Param("record") ClockIn record, @Param("example") ClockInExample example);

    int updateByExample(@Param("record") ClockIn record, @Param("example") ClockInExample example);

    int updateByPrimaryKeySelective(ClockIn record);

    int updateByPrimaryKey(ClockIn record);
}