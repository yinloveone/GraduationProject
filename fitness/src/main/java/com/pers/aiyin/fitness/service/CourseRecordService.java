package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.utils.Result;

import java.util.List;

public interface CourseRecordService {
    List<CustomCourseRecord> getRecordByStuId(Integer stuId);
    List<CustomCourseRecord> getRecordByCoachId(Integer coachId);
    Result orderCourse(CourseRecord courseRecord);

    Result cancelOrder(CourseRecord courseRecord);

}
