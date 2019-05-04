package com.pers.aiyin.fitness.service;

import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Course;

public interface CourseService {

    PageInfo<Course> getCourseList(int pageCurrent, int pageSize);

    int addCourse(Course course);

    Course getCourse(Integer courseId);

    int deleteCourse(Integer courseId);

    int updateCourse(Course course);
}
