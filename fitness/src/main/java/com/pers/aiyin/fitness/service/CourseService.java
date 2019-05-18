package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.utils.Result;

public interface CourseService {

    PageInfo<Course> getCourseList(int pageCurrent, int pageSize);

    Result addCourse(Course course);

    Course getCourse(Integer courseId);

    int deleteCourse(Integer courseId);

    int updateCourse(Course course);
}
