package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.CourseRecordList;
import com.pers.aiyin.fitness.response.CustomCourseR;
import com.pers.aiyin.fitness.response.CustomCourseRecord;

import java.util.List;

public interface CustomCourseRecordMapper {
    List<CourseRecordList> getRecordByStuId(Integer stuId);
    List<CourseRecordList> getRecordByCoachId(Integer coachId);
    List<CustomCourseR> getSelectStudent(Integer courseId);

}
