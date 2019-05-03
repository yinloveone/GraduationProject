package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.CourseHour;
import com.pers.aiyin.fitness.entity.CourseHourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseHourMapper {
    long countByExample(CourseHourExample example);

    int deleteByExample(CourseHourExample example);

    int deleteByPrimaryKey(Integer hourId);

    int insert(CourseHour record);

    int insertSelective(CourseHour record);

    List<CourseHour> selectByExample(CourseHourExample example);

    CourseHour selectByPrimaryKey(Integer hourId);

    int updateByExampleSelective(@Param("record") CourseHour record, @Param("example") CourseHourExample example);

    int updateByExample(@Param("record") CourseHour record, @Param("example") CourseHourExample example);

    int updateByPrimaryKeySelective(CourseHour record);

    int updateByPrimaryKey(CourseHour record);
}