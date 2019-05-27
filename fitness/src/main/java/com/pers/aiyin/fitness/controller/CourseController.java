package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pers.aiyin.fitness.entity.ClassRoom;
import com.pers.aiyin.fitness.entity.Coach;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.response.CustomCourse;
import com.pers.aiyin.fitness.service.CourseService;
import com.pers.aiyin.fitness.utils.ResponseCode;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
    public String getCourseList(Integer rows, Integer page, CustomCourse course){
        Map<String,Object> resultMap=new HashMap<>();
        PageInfo<CustomCourse> pageInfo = courseService.getCourseList(page,rows,course);
        resultMap.put("rows",pageInfo.getList());
        resultMap.put("total",pageInfo.getList().size());
        return new Gson().toJson(resultMap);
    }

    @PostMapping("/course/addCourse")
    public Result addCourse(Course course){
        return courseService.addCourse(course);
    }

    @PostMapping("/course/addPrivateCourse")
    public Result addPrivateCourse(HttpServletRequest request) throws
            IOException {
        Course course=new ObjectMapper().readValue(request.getInputStream(),Course.class);
        return courseService.addCourse(course);
    }

    @GetMapping("/course/getCourse/{courseId}")
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
   /* @PostMapping("/course/getByCourseId/{courseId}")
    public Result getByCourseId(@PathVariable("courseId") Integer courseId){
       return null;
    }*/

    @GetMapping("/course/getCoachList")
    public Result getCoachList(){
        List<Coach> list = courseService.getCoachList();
        if(null!=list&&list.size()>0){
            return Result.success(list);
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }
    @GetMapping("/course/getRoomList")
    public Result getRoomList(){
        List<ClassRoom> list = courseService.getRoomList();
        if(null!=list&&list.size()>0){
            return Result.success(list);
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

    @PostMapping("/course/updatePrivateCourse")
    public Result updatePrivateCourse(HttpServletRequest request) throws
            IOException {
        Course course=new ObjectMapper().readValue(request.getInputStream(),Course.class);
        int result = courseService.updateCourse(course);
        if(result!=-1){
            return Result.success();
        }else {
            return  Result.failure(ResponseCode.FAIL);
        }
    }

    @GetMapping("/course/getPrivateList/{coachId}")
    public Result getPrivateList(@PathVariable("coachId") Integer coachId){
        return courseService.getPrivateList(coachId);
    }

}
