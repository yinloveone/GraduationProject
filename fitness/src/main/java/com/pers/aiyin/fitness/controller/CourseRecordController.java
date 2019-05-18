package com.pers.aiyin.fitness.controller;

import com.pers.aiyin.fitness.response.CourseRecordList;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.service.CourseRecordService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* 学生和教练的课表管理
* */

@RestController
@RequestMapping("api")
public class CourseRecordController {

    @Autowired
    private CourseRecordService courseRecordService;

    /*
    * *根据学生id获得课程表
     */
    @GetMapping("/courseRecord/getRecordById/{stuId}")
    public Result getRecordById(@PathVariable("stuId") Integer stuId){
        List<CourseRecordList> courseRecordList = courseRecordService.getRecordByStuId(stuId);
        if(null!=courseRecordList&&courseRecordList.size()>0){
            return Result.success(courseRecordList);
        }else{
            return new Result(1,"没有课表记录");
        }

    }

    /*
     * *根据教练id获得课程表
     */
    @GetMapping("/courseRecord/getRecordByCoachId/{coachId}")
    public Result getRecordByCoachId(@PathVariable("coachId") Integer coachId){
        List<CourseRecordList> courseRecordList = courseRecordService.getRecordByCoachId(coachId);
        if(null!=courseRecordList&&courseRecordList.size()>0){
            return Result.success(courseRecordList);
        }else{
            return new Result(1,"没有课表记录");
        }
    }

}
