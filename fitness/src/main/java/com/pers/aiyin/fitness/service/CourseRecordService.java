package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.response.CustomCourseRecord;

import java.util.List;

public interface CourseRecordService {
    List<CustomCourseRecord> getRecordByStuId(Integer stuId);
    List<CustomCourseRecord> getRecordByCoachId(Integer coachId);

    String orderCourse(CourseRecord courseRecord);

}
