package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.ClassRoom;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.utils.Result;

import java.util.List;

public interface CourseService {

    PageInfo<Course> getCourseList(int pageCurrent, int pageSize,Course course);

    Result addCourse(Course course);

    Course getCourse(Integer courseId);

    int deleteCourse(Integer courseId);

    int updateCourse(Course course);

    List<Coach> getCoachList();

    List<ClassRoom> getRoomList();
}
