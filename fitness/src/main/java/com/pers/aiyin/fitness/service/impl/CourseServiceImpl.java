package com.pers.aiyin.fitness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.CourseExample;
import com.pers.aiyin.fitness.mapper.CourseMapper;
import com.pers.aiyin.fitness.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public PageInfo<Course> getCourseList(int pageCurrent, int pageSize){
        CourseExample courseExample = new CourseExample();
        PageHelper.startPage(pageCurrent,pageSize);
        List<Course> list = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo =new PageInfo<>(list);
        return pageInfo;
    }

    public int addCourse(Course course){
        return courseMapper.insertSelective(course);
    }

    public Course getCourse(Integer courseId){
        return courseMapper.selectByPrimaryKey(courseId);
    }

    public int deleteCourse(Integer courseId){
        return courseMapper.deleteByPrimaryKey(courseId);
    }

    public int updateCourse(Course course){
        return courseMapper.updateByPrimaryKeySelective(course);
    }
}
