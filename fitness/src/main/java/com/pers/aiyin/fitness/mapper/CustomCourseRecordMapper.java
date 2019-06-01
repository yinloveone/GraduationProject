package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.response.*;

import java.util.List;

public interface CustomCourseRecordMapper {
    List<CourseRecordList> getRecordByStuId(CourseRecordOption course);
    List<CourseRecordList> getRecordByCoachId(CourseRecordOption course);
    List<CustomCourseR> getSelectStudent(Integer courseId);
    List<CustomCourse> getCourseList(CustomCourse customCourse);
    List<CustomCourseR> getContentByCoach(CustomCourse customCourse);
    List<CustomCourseR> getDetailContent(CustomCourse customCourse);
}
