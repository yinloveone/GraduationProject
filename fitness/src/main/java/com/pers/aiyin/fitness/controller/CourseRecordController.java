package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.response.CourseRecordList;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.service.CourseRecordService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    /*
    * 根据课程Id获取选课的学员
    * */

    @GetMapping("/courseRecord/getSelectStudent/{courseId}")
    public Result getSelectStudent(@PathVariable("courseId") Integer courseId){
        return courseRecordService.getSelectStudent(courseId);
    }

    /*
    * 学员签到
    * */
    @PostMapping("/courseRecord/studentIn")
    public Result studentIn(HttpServletRequest request) throws
            IOException {
        CourseRecord record=new ObjectMapper().readValue(request.getInputStream(),CourseRecord.class);
        return courseRecordService.studentIn(record);
    }

    /*
    * 课程打分
    * */
    @PostMapping("/courseRecord/submitScore")
    public Result submitScore(HttpServletRequest request) throws
            IOException {
        CourseRecord record=new ObjectMapper().readValue(request.getInputStream(),CourseRecord.class);
        return courseRecordService.submitScore(record);
    }
    /*
    * 根据教练Id获取课程评价统计
    * */
    @GetMapping("/courseRecord/getContent/{coachId}")
    public Result getContent(@PathVariable("coachId") Integer coachId){
        return courseRecordService.getContent(coachId);
    }
    /*
     * 根据教练Id获取每一条课程评价
     * */
    @GetMapping("/courseRecord/getDetailContent/{coachId}")
    public Result getDetailContent(@PathVariable("coachId") Integer coachId){
        return courseRecordService.getDetailContent(coachId);
    }



}
