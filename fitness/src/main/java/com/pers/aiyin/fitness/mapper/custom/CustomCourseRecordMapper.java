package com.pers.aiyin.fitness.mapper.custom;

import com.pers.aiyin.fitness.response.CustomCourseRecord;

import java.util.List;

public interface CustomCourseRecordMapper {
    List<CustomCourseRecord> getRecordByStuId(Integer stuId);
    List<CustomCourseRecord> getRecordByCoachId(Integer coachId);
}
