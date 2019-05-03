package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.CoachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachMapper {
    long countByExample(CoachExample example);

    int deleteByExample(CoachExample example);

    int deleteByPrimaryKey(Integer coachId);

    int insert(Coach record);

    int insertSelective(Coach record);

    List<Coach> selectByExample(CoachExample example);

    Coach selectByPrimaryKey(Integer coachId);

    int updateByExampleSelective(@Param("record") Coach record, @Param("example") CoachExample example);

    int updateByExample(@Param("record") Coach record, @Param("example") CoachExample example);

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);
}