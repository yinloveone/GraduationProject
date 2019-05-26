package com.pers.aiyin.fitness.service;

import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.response.CourseRecordList;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.utils.Result;

import java.util.List;

public interface CourseRecordService {

    List<CourseRecordList> getRecordByStuId(Integer stuId);

    List<CourseRecordList> getRecordByCoachId(Integer coachId);

    Result orderCourse(CourseRecord courseRecord);

    Result cancelOrder(CourseRecord courseRecord);

    Result getSelectStudent(Integer courseId);

    Result studentIn(CourseRecord courseRecord);

    Result submitScore(CourseRecord courseRecord);
}
