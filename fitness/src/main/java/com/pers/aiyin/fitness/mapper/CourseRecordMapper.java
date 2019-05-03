package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.entity.CourseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseRecordMapper {
    long countByExample(CourseRecordExample example);

    int deleteByExample(CourseRecordExample example);

    int deleteByPrimaryKey(Integer courseRecordId);

    int insert(CourseRecord record);

    int insertSelective(CourseRecord record);

    List<CourseRecord> selectByExample(CourseRecordExample example);

    CourseRecord selectByPrimaryKey(Integer courseRecordId);

    int updateByExampleSelective(@Param("record") CourseRecord record, @Param("example") CourseRecordExample example);

    int updateByExample(@Param("record") CourseRecord record, @Param("example") CourseRecordExample example);

    int updateByPrimaryKeySelective(CourseRecord record);

    int updateByPrimaryKey(CourseRecord record);
}