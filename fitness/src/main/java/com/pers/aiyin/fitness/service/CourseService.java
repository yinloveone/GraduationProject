package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClassRoom;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.utils.Result;

import java.util.List;

public interface CourseService {

    PageInfo<CustomCourse> getCourseList(int pageCurrent, int pageSize, CustomCourse course);

    Result addCourse(Course course);

    Course getCourse(Integer courseId);

    Result deleteCourse(Course course);

    int updateCourse(Course course);

    List<Coach> getCoachList();

    List<ClassRoom> getRoomList();

    Result getPrivateList(Integer coachId);
}
