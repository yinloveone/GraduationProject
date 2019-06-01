package com.pers.aiyin.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pers.aiyin.fitness.entity.Course;
import com.pers.aiyin.fitness.entity.CourseRecord;
import com.pers.aiyin.fitness.response.CourseRecordList;
import com.pers.aiyin.fitness.response.CourseRecordOption;
import com.pers.aiyin.fitness.response.CustomCourseRecord;
import com.pers.aiyin.fitness.service.CourseRecordService;
import com.pers.aiyin.fitness.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
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
    @PostMapping("/courseRecord/getRecordById")
    public Result getRecordById(HttpServletRequest request) throws
            IOException {
        CourseRecordOption course=new ObjectMapper().readValue(request.getInputStream(), CourseRecordOption.class);
        if(null!=course.getStuId()) {
            if(null!=course.getDateRange()) {
                LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(course.getDateRange().getTime()), ZoneId.systemDefault());
                LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
                LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
                Date beginDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
                Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
                course.setDateRange(beginDate);
                course.setDateRangeEnd(endDate);
            }
            List<CourseRecordList> courseRecordList = courseRecordService.getRecordByStuId(course);
            if (null != courseRecordList && courseRecordList.size() > 0) {
                return Result.success(courseRecordList);
            } else {
                return new Result(1, "没有课表记录");
            }
        }else{
            return new Result(1, "stuId为空");
        }

    }
    /*
     * *根据教练id获得课程表
     */
    @PostMapping("/courseRecord/getRecordByCoachId")
    public Result getRecordByCoachId(HttpServletRequest request) throws
            IOException {
        CourseRecordOption courseRecordOption=new ObjectMapper().readValue(request.getInputStream(), CourseRecordOption.class);
        if(null!=courseRecordOption.getCoachId()) {
            List<CourseRecordList> courseRecordList = courseRecordService.getRecordByCoachId(courseRecordOption);
            if (null != courseRecordList && courseRecordList.size() > 0) {
                return Result.success(courseRecordList);
            } else {
                return new Result(1, "没有课表记录");
            }
        }else{
            return new Result(1, "coachId为空");
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
