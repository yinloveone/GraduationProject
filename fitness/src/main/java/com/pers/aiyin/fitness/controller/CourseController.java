package com.pers.aiyin.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.service.CourseService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 课程管理
* */

@RestController
@RequestMapping("api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course/courseList")
    public String getCourseList(Integer rows, Integer page){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<Course> pageInfo = courseService.getCourseList(rows,page);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getList().size());
        return new Gson().toJson(resultMap);
    }

    @PostMapping("/course/addCourse")
    public Result addCourse(Course course){
        return courseService.addCourse(course);
    }
    @PostMapping("/course/getCourse/{courseId}")
    public Result getCourse(@PathVariable("courseId") Integer courseId){
        Course course = courseService.getCourse(courseId);
        if(null!=course){
            return Result.success(course);
        }
        return Result.failure(ResponseCode.FAIL);
    }

    @PostMapping("/course/deleteCourse/{courseId}")
    public Result deleteCourse(@PathVariable("courseId") Integer courseId){
        int result = courseService.deleteCourse(courseId);
        if(result!=-1){
            return Result.success();
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }

    @PostMapping("/course/updateCourse")
    public Result updateCourse(Course course){
        int result = courseService.updateCourse(course);
        if(result!=-1){
            return Result.success();
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }
}
